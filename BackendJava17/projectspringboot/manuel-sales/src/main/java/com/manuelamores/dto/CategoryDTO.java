package com.manuelamores.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {

    private Integer idCategory;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    private String nameOfCategory;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    private String descriptionCategory;

    @NotNull
    private boolean enabledCategory;
}
