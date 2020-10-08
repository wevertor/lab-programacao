package com.trindade.mapping.services;

import com.trindade.mapping.model.Mercadoria;
import com.trindade.mapping.model.repositorio.MercadoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MercadoriaService {
	@Autowired
	MercadoriaRepository mercadoriaRepository;

	public Mercadoria salvarMercadoria(Mercadoria mercadoria) {
		Mercadoria mercadoriaSalva = mercadoriaRepository.save(mercadoria);
		return mercadoriaSalva;
	}

	public long contarMercadorias(long codigo) {
		long total = mercadoriaRepository.countByCodigo(codigo);
		return total;
	}
}
