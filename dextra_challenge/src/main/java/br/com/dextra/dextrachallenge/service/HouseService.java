package br.com.dextra.dextrachallenge.service;

import br.com.dextra.dextrachallenge.config.ApiProperties;
import br.com.dextra.dextrachallenge.model.dto.HouseDto;
import br.com.dextra.dextrachallenge.model.dto.PotterApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class HouseService {

    @Autowired
    ApiProperties apiProperties;

    public void validateIdHouse(String idHouse) throws Exception {

        PotterApiResponse houses = getHouseToPotterApi();

        if (houses.getHouses().stream().noneMatch(h -> h.getId().equals(idHouse))) {
            throw new Exception("ID House invalid!");
        }

    }

    @Cacheable(value = "HouseApi")
    private PotterApiResponse getHouseToPotterApi() throws Exception {

        URI uri = new URI("http://us-central1-rh-challenges.cloudfunctions.net/potterApi/houses");

        HttpHeaders headers = new HttpHeaders();
        headers.set("apikey", apiProperties.getKey());

        HttpEntity<PotterApiResponse> requestEntity = new HttpEntity<>(null, headers);

        ResponseEntity<PotterApiResponse> result = new RestTemplate().exchange(uri, HttpMethod.GET, requestEntity, PotterApiResponse.class);

        return result.getBody();
    }
}
