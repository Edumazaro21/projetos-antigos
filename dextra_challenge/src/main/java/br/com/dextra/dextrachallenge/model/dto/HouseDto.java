package br.com.dextra.dextrachallenge.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseDto {

    private String id;
    private String name;
    private String headOfHouse;
    private String school;
    private String mascot;
    private String houseGhost;
    private String founder;
    private List<String> values;
    private List<String> colors;
}
