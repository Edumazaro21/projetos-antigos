package br.com.dextra.dextrachallenge.config.responseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DefaultResponseEntity {

    private String message;
    private List<?> data;
}
