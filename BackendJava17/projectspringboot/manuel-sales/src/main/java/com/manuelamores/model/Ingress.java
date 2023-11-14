package com.manuelamores.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CollectionId;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Ingress {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idIngress;

    @ManyToOne
    @JoinColumn(name="idProvider", nullable = false, foreignKey = @ForeignKey(name = "FK_ingress_provider"))
    private Provider provider;

    @ManyToOne
    @JoinColumn(name="idUser", nullable = false, foreignKey = @ForeignKey(name = "FK_ingress_user"))
    private User user;

    @Column(nullable = false)
    private LocalDate dateTime;

    @Column(columnDefinition = "DECIMAL(6,2)", nullable = false)
    private Double total;

    @Column(columnDefinition = "DECIMAL(6,2)", nullable = false)
    private double tax;

    @Column(nullable = false)
    private boolean enabled;
}
