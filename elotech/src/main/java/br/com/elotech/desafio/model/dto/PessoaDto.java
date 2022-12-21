package br.com.elotech.desafio.model.dto;

import br.com.elotech.desafio.validacao.Cpf;
import javax.validation.constraints.NotNull;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PessoaDto {
    
    private Long id;
    
    @NotNull @NotEmpty @Cpf
    private String cpf;
    
    @NotNull @NotEmpty
    private String nome;
    
    @NotNull @NotEmpty
    private String dataNascimento;
    
    @NotNull @NotEmpty
    private List<ContatoDto> vContato;
}
