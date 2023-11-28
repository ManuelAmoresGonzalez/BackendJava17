package com.manuelamores.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {

    private Integer idCategory;
    private String nameOfCategory;
    private String descriptionCategory;
    private boolean enabledCategory;
}
