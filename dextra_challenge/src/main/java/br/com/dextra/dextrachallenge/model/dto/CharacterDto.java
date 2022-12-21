package br.com.dextra.dextrachallenge.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CharacterDto {

    private Long id;

    @NotNull(message = "Name is required") @NotEmpty(message = "Name cannot be empty")
    private String name;

    @NotNull(message = "Role is required") @NotEmpty(message = "Role cannot be empty")
    private String role;

    @NotNull(message = "School is required") @NotEmpty(message = "School cannot be empty")
    private String school;

    @NotNull(message = "House is required") @NotEmpty(message = "House cannot be empty")
    private String house;

    @NotNull(message = "Patronus is required") @NotEmpty(message = "Patronus cannot be empty")
    private String patronus;
}
