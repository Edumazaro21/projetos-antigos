package br.com.mazaro.consultacep.service;

import br.com.mazaro.consultacep.model.EnderecoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsultaCepService {

    private final String URL = "http://viacep.com.br/ws/";
    private final RestTemplate restTemplate;

    public ConsultaCepService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ConsultaCepService() {
        this.restTemplate = new RestTemplate();
    }
    
    public ResponseEntity<String> buscaEndereco(String cep) {

        try {
            EnderecoDTO endereco = getEnderecoValido(cep);

            return ResponseEntity.ok().body(endereco.toString());

        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("CEP inválido");
        }
    }

    public EnderecoDTO getEnderecoValido(String cep) throws Exception {
        EnderecoDTO endereco = restTemplate.getForObject(URL + cep + "/json/", EnderecoDTO.class);

        while (!isValido(endereco)) {

            if (cep.replace("0", "").isEmpty()) {
                throw new Exception("CEP inválido");
            }

            cep = alterarUltimoCaracter(cep);

            endereco = restTemplate.getForObject(URL + cep + "/json/", EnderecoDTO.class);
        }

        return endereco;
    }

    public String alterarUltimoCaracter(String cep) {

        for (int i = (cep.length() - 1); i >= 0; i--) {
            if (cep.charAt(i) == '0') {
                continue;

            } else {
                String inicioStr = cep.substring(0, i);
                String finalStr = cep.substring((i + 1), cep.length());

                cep = inicioStr + "0" + finalStr;

                break;
            }
        }

        return cep;
    }

    private boolean isValido(EnderecoDTO endereco) {
        if (endereco.getLogradouro() == null || endereco.getLogradouro().isEmpty()
                || endereco.getBairro() == null || endereco.getBairro().isEmpty()
                || endereco.getLocalidade()== null || endereco.getLocalidade().isEmpty()
                || endereco.getUf()== null || endereco.getUf().isEmpty()) {

            return false;
        }
        
        return true;
    }

}
