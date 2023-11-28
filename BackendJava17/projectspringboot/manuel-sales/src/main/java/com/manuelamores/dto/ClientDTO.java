package com.manuelamores.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
    private String  firstName;
    private String lastName;
    private String country;
    private String cardId;
    private String phoneNumber;
    private String email;
    private String address;

}
