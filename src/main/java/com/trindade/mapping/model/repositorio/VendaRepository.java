package com.trindade.mapping.model.repositorio;

import java.time.LocalDate;
import java.util.Optional;

import com.trindade.mapping.model.Venda;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Long> {
	Optional<Venda> findByNumeroVenda(Long numeroVenda);

	long countByNumeroVenda(Long numeroVenda);

	Optional<Venda> countByDataVenda(LocalDate dataVenda);

}
