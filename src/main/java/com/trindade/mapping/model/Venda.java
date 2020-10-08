package com.trindade.mapping.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@Entity
@Table(name = "venda")
public class Venda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "numero_venda")
	private Long numeroVenda;

	@Column(name = "data_venda")
	@Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
	private LocalDate dataVenda;

	@ManyToMany(mappedBy = "venda_mercadoria")
	private List<Mercadoria> mercadorias;
}
