package br.com.elotech.desafio.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContatoDto {
    
    private Long id;
    
    @NotNull @NotEmpty
    private String nome;
    
    @NotNull @NotEmpty
    private String telefone;
    
    @NotNull @NotEmpty @Email
    private String email;
}
