package com.manuelamores.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Sale {

    @Id
    @EqualsAndHashCode.Include
    private Integer idSale;

    @ManyToOne
    @JoinColumn(name = "idClient", nullable = false, foreignKey = @ForeignKey(name = "FK_SALE_CLIENT"))
    private Client client;

    @ManyToOne
    @JoinColumn(name = "idUser", nullable = false, foreignKey = @ForeignKey(name = "FK_SALE_USER"))
    private User user;

    @Column(nullable = false)
    private LocalDate dateTime;

    @Column(columnDefinition = "DECIMAL(6,2)" , nullable = false)
    private double total;

    @Column(columnDefinition = "DECIMAL(6,2)" , nullable = false)
    private double tax;

    @Column(nullable = false)
    public boolean enabled;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    private List<SaleDetail> saleDetails;

}
