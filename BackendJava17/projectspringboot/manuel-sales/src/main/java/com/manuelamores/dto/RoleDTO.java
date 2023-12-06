package com.manuelamores.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO {

    private Integer idRole;

    @NotNull
    @NotEmpty
    private String nameRole;

    @NotNull
    private boolean enabledRole;

}
