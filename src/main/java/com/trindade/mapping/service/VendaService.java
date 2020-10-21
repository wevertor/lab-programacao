package com.trindade.mapping.service;

import java.time.LocalDate;
import java.util.List;

import com.trindade.mapping.model.Venda;
import com.trindade.mapping.model.repositorio.VendaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendaService {

	@Autowired
	VendaRepository vendaRepository;

	public Venda salvarVenda(Venda venda) {
		Venda vendaSalva = vendaRepository.save(venda);
		return vendaSalva;
	}

	public List<Venda> listarVendasEmUmaData(LocalDate dataVenda) {
		List<Venda> vendas = vendaRepository.findAllByDataVenda(dataVenda);
		return vendas;
	}
}
