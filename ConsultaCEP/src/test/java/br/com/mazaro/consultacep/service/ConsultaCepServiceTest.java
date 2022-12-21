package br.com.mazaro.consultacep.service;

import br.com.mazaro.consultacep.model.EnderecoDTO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ConsultaCepServiceTest {
    
    private final String URL = "http://viacep.com.br/ws/";
    
    @Test
    @DisplayName("Teste valida consulta de endereço passando um CEP válido.")
    public void testBuscaEndereco() {
        
        RestTemplate restTemplate = mock(RestTemplate.class);
        
        EnderecoDTO endereco = new EnderecoDTO();
        endereco.setLogradouro("RUA TESTE");
        endereco.setLocalidade("CIDADE TESTE");
        endereco.setBairro("BAIRRO TESTE");
        endereco.setUf("ESTADO TESTE");
        
        Mockito.when(restTemplate.getForObject(URL + "12345678/json/", EnderecoDTO.class)).thenReturn(endereco);
        
        ConsultaCepService instance = new ConsultaCepService(restTemplate);
        
        ResponseEntity<String> responce = instance.buscaEndereco("12345678");
        
        assertEquals(HttpStatus.OK, responce.getStatusCode());
        assertEquals(endereco.toString(), responce.getBody());
    }
    
    @Test
    @DisplayName("Teste valida consulta de endereço passando um CEP inválido.")
    public void testGetEnderecoValido() {
        
        RestTemplate restTemplate = mock(RestTemplate.class);
        
        EnderecoDTO endereco = new EnderecoDTO();
        
        Mockito.when(restTemplate.getForObject(URL + "12345678/json/", EnderecoDTO.class)).thenReturn(endereco);
        Mockito.when(restTemplate.getForObject(URL + "12345670/json/", EnderecoDTO.class)).thenReturn(endereco);
        Mockito.when(restTemplate.getForObject(URL + "12345600/json/", EnderecoDTO.class)).thenReturn(endereco);
        Mockito.when(restTemplate.getForObject(URL + "12345000/json/", EnderecoDTO.class)).thenReturn(endereco);
        Mockito.when(restTemplate.getForObject(URL + "12340000/json/", EnderecoDTO.class)).thenReturn(endereco);
        Mockito.when(restTemplate.getForObject(URL + "12300000/json/", EnderecoDTO.class)).thenReturn(endereco);
        Mockito.when(restTemplate.getForObject(URL + "12000000/json/", EnderecoDTO.class)).thenReturn(endereco);
        Mockito.when(restTemplate.getForObject(URL + "10000000/json/", EnderecoDTO.class)).thenReturn(endereco);
        Mockito.when(restTemplate.getForObject(URL + "00000000/json/", EnderecoDTO.class)).thenReturn(endereco);
        
        ConsultaCepService instance = new ConsultaCepService(restTemplate);
        
        ResponseEntity<String> responce = instance.buscaEndereco("12345678");
        
        assertEquals(HttpStatus.BAD_REQUEST, responce.getStatusCode());
        assertEquals("CEP inválido", responce.getBody());
    }

    @Test
    @DisplayName("Teste valida método responsável por alterar o último dígito diferente de zero por zero.")
    public void testAlterarUltimoCaracter() {
        
        ConsultaCepService instance = new ConsultaCepService(null);
        
        String cep = instance.alterarUltimoCaracter("1230");
        
        assertEquals("1200", cep);
    }
    
}
