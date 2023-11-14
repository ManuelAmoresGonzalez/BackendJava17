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
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idProvider;

    @Column(length = 50, nullable = false)
    private String nameProvider;

    @Column(length = 150, nullable = false)
    private String address;

    @Column(nullable = false)
    private boolean enabled;
}
