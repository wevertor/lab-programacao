package com.trindade.mapping.services;

import com.trindade.mapping.model.Mercadoria;
import com.trindade.mapping.model.repositorio.MercadoriaRepository;
import com.trindade.mapping.service.MercadoriaService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("Test")
public class MercadoriaServiceTest {
	@Autowired
	MercadoriaService service;
	
	@Autowired
	MercadoriaRepository repository;

	@Test
	public void deveSalvarMercadoria() {
		Mercadoria mercadoria = Mercadoria.builder()
			.descricao("sabao")
			.build();
		
		Mercadoria salvo = service.salvarMercadoria(mercadoria);

		Assertions.assertNotNull(salvo);
		Assertions.assertNotNull(salvo.getCodigo());

		repository.delete(salvo);
	}

	@Test
	public void deveContarMercadorias() {
		Mercadoria mercadoria1 = Mercadoria.builder()
			.codigo(Long.valueOf(1))
			.descricao("sabao")
			.build();

		Mercadoria mercadoria2 = Mercadoria.builder()
			.codigo(Long.valueOf(1))
			.descricao("sabao")
			.build();
		
		Mercadoria salvo1 = repository.save(mercadoria1);
		Mercadoria salvo2 = repository.save(mercadoria2);

		// acao
		long quant = service.contarMercadorias(1);

		Assertions.assertTrue(quant == 2);
		
		repository.delete(salvo1);
		repository.delete(salvo2);
	}

	
}
