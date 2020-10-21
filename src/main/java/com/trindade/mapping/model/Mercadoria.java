package com.trindade.mapping.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "mercadoria", schema = "public")
public class Mercadoria {
	@Id
	@Column(name = "codigo")
	private Long codigo;

	@Column(name = "decricao")
	private String descricao;

	@ManyToMany
	@JoinTable(name = "venda_mercadoria", joinColumns = @JoinColumn(name = "numeroVendas"), inverseJoinColumns = @JoinColumn(name = "mercadoria"))
	private List<Venda> vendas;

}
