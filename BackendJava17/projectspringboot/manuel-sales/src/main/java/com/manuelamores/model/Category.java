package com.manuelamores.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    private Integer idCategory;
    private String name;
    private String description;
    private Boolean enabled;

}
