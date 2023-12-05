package com.manuelamores.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
    @Pattern(regexp = "[0-9]+")
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
