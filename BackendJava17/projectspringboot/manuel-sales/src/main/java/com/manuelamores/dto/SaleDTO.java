package com.manuelamores.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SaleDTO {

    private Integer idSale;

    @NotNull
    private ClientDTO client;

    @NotNull
    private UserDTO user;

    @NotNull
    private LocalDateTime datetime;

    @Min(value = 1)
    private Double total;

    @Min(value = 1)
    private Double tax;

    @NotNull
    private boolean enabled;

    @NotNull
    @JsonManagedReference
    private List<SaleDetailDTO> saleDetails;
}
