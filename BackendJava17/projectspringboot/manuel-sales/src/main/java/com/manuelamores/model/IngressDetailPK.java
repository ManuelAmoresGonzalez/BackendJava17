package com.manuelamores.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class IngressDetailPK implements Serializable {

    @ManyToOne
    @JoinColumn(name="idIngress", nullable = false)
    private Ingress ingress;
    @ManyToOne
    @JoinColumn(name="idIngress", nullable = false)
    private Product product;
}
