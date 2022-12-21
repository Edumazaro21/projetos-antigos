package br.com.elotech.desafio.repository;

/*import br.com.elotech.desafio.model.entity.Contato;
import br.com.elotech.desafio.model.entity.Pessoa;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PessoaRepositoryTest {

    @Autowired
    private PessoaRepository repository;

    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    private static Pessoa pessoa = null;

    @Test
    @Order(1)
    @DisplayName("Salvar pessoa.")
    public void testSave() throws Exception {

        Contato conatato = Contato.builder()
                .nome("teste")
                .email("teste@teste.com")
                .telefone("9999999999")
                .build();

        pessoa = Pessoa.builder()
                .nome("Eduardo")
                .cpf("34034468831")
                .dataNascimento(format.parse("21/07/1995"))
                .contato(Arrays.asList(conatato))
                .build();

        Assertions.assertDoesNotThrow(() -> repository.save(pessoa));

        Assertions.assertTrue(pessoa.getId() > 0L);
    }

    @Test
    @Order(2)
    @DisplayName("Consulta todas pessoas.")
    public void testFindAll() {

        List<Pessoa> vPessoa = repository.findAll();

        Assertions.assertTrue(vPessoa.stream().anyMatch(p -> p.getCpf().equals("34034468831")));
    }

    @Test
    @Order(3)
    @DisplayName("Consulta pessoa especifica.")
    public void testFindById() {

        Optional<Pessoa> pessoaOptional = repository.findById(pessoa.getId());

        Assertions.assertTrue(pessoaOptional.isPresent());
    }

    @Test
    @Order(4)
    @DisplayName("Consulta pessoas com paginacao.")
    public void testFindPage() {

        Pageable page = PageRequest.of(0, 5, Sort.by(Sort.Direction.ASC, "id"));

        Assertions.assertFalse(repository.findAll(page).toList().isEmpty());
    }

    @Test
    @Order(5)
    @DisplayName("Alterar pessoa.")
    public void testUpdate() {

        pessoa.setNome("Eduardo Mazaro");

        repository.save(pessoa);

        Optional<Pessoa> pessoaOptional = repository.findById(pessoa.getId());

        Assertions.assertEquals("Eduardo Mazaro", pessoaOptional.get().getNome());
    }

    @Test
    @Order(6)
    @DisplayName("Deletar pessoa.")
    public void testDelete() {

        repository.delete(pessoa);

        Optional<Pessoa> pessoaOptional = repository.findById(pessoa.getId());

        Assertions.assertFalse(pessoaOptional.isPresent());
    }
}*/
