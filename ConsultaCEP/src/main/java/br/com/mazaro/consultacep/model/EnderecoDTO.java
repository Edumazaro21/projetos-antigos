package br.com.mazaro.consultacep.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnderecoDTO {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;

    @Override
    public String toString() {

        return "RUA: " + (logradouro.isEmpty() ? "NÃO ENCONTRADO " : logradouro.toUpperCase()) + "  "
                + "BAIRRO: " + (bairro.isEmpty() ? "NÃO ENCONTRADO " : bairro.toUpperCase()) + "  "
                + "CIDADE: " + (localidade.isEmpty() ? "NÃO ENCONTRADO " : localidade.toUpperCase()) + "  "
                + "ESTADO: " + (uf.isEmpty() ? "NÃO ENCONTRADO " : uf.toUpperCase());
    }
}
