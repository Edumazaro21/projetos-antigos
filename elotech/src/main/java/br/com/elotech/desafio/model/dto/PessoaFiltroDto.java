package br.com.elotech.desafio.model.dto;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PessoaFiltroDto {
    
    private String nome;
    private String cpf;
    private String dataNascimento;
    
    @NotNull
    private Integer pagina;
    
    @NotNull
    private Integer limite;
}
