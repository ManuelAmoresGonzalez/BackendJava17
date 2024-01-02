package com.manuelamores.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SaleDetailDTO {

    @JsonBackReference
    private SaleDTO sale;

    @NotNull
    private ProductDTO product;

    @Min(value = 1)
    private short quantity;

    @Min(value = 1)
    private Double salePrice;

    @Min(value = 0)
    private Double discount;
}
