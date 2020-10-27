package com.trindade.mapping.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "venda_mercadoria")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VendaMercadoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "venda_mercadoria")
    private int id;

    @Column(name = "numerovenda")
    private Long venda;

    @Column(name = "codigo")
    private Long mercadoria;
}
