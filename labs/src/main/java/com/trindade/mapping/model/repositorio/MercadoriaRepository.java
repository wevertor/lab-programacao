package com.trindade.mapping.model.repositorio;

import java.util.Optional;

import com.trindade.mapping.model.Mercadoria;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MercadoriaRepository extends JpaRepository<Mercadoria, Long> {
	Optional<Mercadoria> findByCodigo(Long codigo);

	long countByCodigo(Long codigo);
}
