package com.manuelamores.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class SaleDetail {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSaleDetail;

    @ManyToOne
    @JoinColumn(name = "idSale", nullable = false, foreignKey = @ForeignKey(name = "FK_sale_detail_sale"))
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "idProduct", nullable = false, foreignKey = @ForeignKey(name = "FK_sale_detail_product"))
    private Product product;

    @Column(nullable = false)
    private short quantity;

    @Column(columnDefinition = "DECIMAL(6,2)" ,nullable = false)
    private double discount;
}
