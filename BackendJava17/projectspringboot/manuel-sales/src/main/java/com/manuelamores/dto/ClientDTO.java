package com.manuelamores.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientDTO {

    private Integer idClient;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 10)
    private String  firstName;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 100)
    private String lastName;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 100)
    private String country;

    @NotNull
    @NotEmpty
    @Size(min = 9, max = 9)
    private String cardId;

    @NotNull
    @NotEmpty
    @Pattern(regexp = "[0-9]+", message = "No cumple con el formato ")
    private String phoneNumber;

    @NotNull
    @NotEmpty
    @Email(message = "No es un formato valido")
    private String email;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 100)
    private String address;

}
