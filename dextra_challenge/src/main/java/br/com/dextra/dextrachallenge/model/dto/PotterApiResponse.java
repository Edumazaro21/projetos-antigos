package br.com.dextra.dextrachallenge.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PotterApiResponse {

    private List<HouseDto> houses;
}
