package br.com.elotech.desafio.service;

import br.com.elotech.desafio.model.dto.ContatoDto;
import br.com.elotech.desafio.model.dto.PessoaDto;
import br.com.elotech.desafio.model.dto.PessoaFiltroDto;
import br.com.elotech.desafio.model.entity.Contato;
import br.com.elotech.desafio.model.entity.Pessoa;
import br.com.elotech.desafio.repository.PessoaRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PessoaService {

    @Autowired
    PessoaRepository repository;
    
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy"); 

    public List<PessoaDto> findAll() {

        List<Pessoa> vPessoa = repository.findAll();
        
        return getPessoaDto(vPessoa);
    }
    
    public List<PessoaDto> findById(Long id) throws Exception {

        Optional<Pessoa> pessoaOptional = repository.findById(id);
        
        if (pessoaOptional.isPresent()) {
            return getPessoaDto(Arrays.asList(pessoaOptional.get()));
            
        } else {
            throw new Exception("Pessoa não encontrada!");
        }
    }
    
    public List<PessoaDto> deleteById(Long id) throws Exception {

        Optional<Pessoa> pessoaOptional = repository.findById(id);
        
        if (pessoaOptional.isPresent()) {
            repository.delete(pessoaOptional.get());
            
            return getPessoaDto(Arrays.asList(pessoaOptional.get()));
            
        } else {
            throw new Exception("Pessoa não encontrada!");
        }
    }

    public void save(PessoaDto pessoa) throws Exception {
        
        validarPessoa(pessoa);
        
        Pessoa pessoaEntity = getPessoaEntity(pessoa);
        
        pessoaEntity.getContato().forEach(c -> c.setPessoa(pessoaEntity));
        
        repository.save(pessoaEntity);
    }

    private Pessoa getPessoaEntity(PessoaDto pessoa) throws ParseException {

        return Pessoa.builder().cpf(pessoa.getCpf())
                .nome(pessoa.getNome())
                .dataNascimento(format.parse(pessoa.getDataNascimento()))
                .contato(getContatoEntity(pessoa.getVContato()))
                .build();

    }

    private List<Contato> getContatoEntity(List<ContatoDto> vContato) {

        List<Contato> vContatoEntity = vContato.stream().map(c -> {

            Contato contato = Contato.builder()
                    .email(c.getEmail())
                    .nome(c.getNome())
                    .telefone(c.getTelefone())
                    .build();

            return contato;
        }).collect(Collectors.toList());

        return vContatoEntity;
    }

    private List<PessoaDto> getPessoaDto(List<Pessoa> vPessoa) {
        
        List<PessoaDto> vPessoaDto = vPessoa.stream().map(p -> {
            
            PessoaDto pessoa = PessoaDto.builder()
                    .id(p.getId())
                    .nome(p.getNome())
                    .cpf(p.getCpf())
                    .dataNascimento(format.format(p.getDataNascimento()))
                    .vContato(getContatoDto(p.getContato()))
                    .build();
            
            return pessoa;
        }).collect(Collectors.toList());
        
        return vPessoaDto;
    }
    
    private List<ContatoDto> getContatoDto(List<Contato> vContato) {
        
        List<ContatoDto> vContatoDto = vContato.stream().map(p -> {
            
            ContatoDto contato = ContatoDto.builder()
                    .id(p.getId())
                    .nome(p.getNome())
                    .email(p.getEmail())
                    .telefone(p.getTelefone())
                    .build();
            
            return contato;
        }).collect(Collectors.toList());
        
        return vContatoDto;
    }

    public List<PessoaDto> findByFilter(PessoaFiltroDto filtro) {
        
        Pageable page;
        List<Pessoa> vPessoa = new ArrayList<>();
        
        if (filtro.getPagina() >= 0 && filtro.getLimite() > 0) {
            page = PageRequest.of(filtro.getPagina(), filtro.getLimite(), Sort.by(Sort.Direction.ASC, "id"));
            
            vPessoa = repository.findAll(page).toList();
        
        } else {
            vPessoa = repository.findAll();
        }
        
        if (filtro.getCpf() != null && !filtro.getCpf().isEmpty()) {
            vPessoa = vPessoa.stream().filter(p -> p.getCpf().equals(filtro.getCpf())).collect(Collectors.toList());
        
        }
        
        if (filtro.getNome() != null && !filtro.getNome().isEmpty()) {
            vPessoa = vPessoa.stream().filter(p -> p.getNome().equals(filtro.getNome())).collect(Collectors.toList());
        
        }
        
        if (filtro.getDataNascimento() != null && !filtro.getDataNascimento().isEmpty()) {
            vPessoa = vPessoa.stream().filter(p -> format.format(p.getDataNascimento()).equals(filtro.getDataNascimento())).collect(Collectors.toList());
        
        }
        
        return getPessoaDto(vPessoa);
    }

    private void validarPessoa(PessoaDto pessoa) throws Exception {
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        LocalDate dataVerificada = LocalDate.parse(pessoa.getDataNascimento(), dtf);
        
        LocalDate hoje = LocalDate.now();
        
        if (dataVerificada.compareTo(hoje) > 0) {
            throw new Exception("Data de nascimento inválida!");
        }
    }
}
