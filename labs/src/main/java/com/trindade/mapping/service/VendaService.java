package com.trindade.mapping.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import com.trindade.mapping.model.Mercadoria;
import com.trindade.mapping.model.Venda;
import com.trindade.mapping.model.VendaMercadoria;
import com.trindade.mapping.model.repositorio.VendaMercadoriaRepository;
import com.trindade.mapping.model.repositorio.VendaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendaService {

	@Autowired
	VendaRepository vendaRepository;

	@Autowired
	VendaMercadoriaRepository vmRepository;

	public Venda salvarVenda(Venda venda) {
		Venda vendaSalva = vendaRepository.save(venda);
		return vendaSalva;
	}

	public Venda venderMercadoria(List<Mercadoria> mercadoriasVendidas) {
		LocalDate novaDataVenda = LocalDate.ofInstant(new Date().toInstant(), ZoneId.systemDefault());
		Venda novaVenda = Venda.builder().dataVenda(novaDataVenda).build();

		this.salvarVenda(novaVenda);

		for (Mercadoria novaMercadoria : mercadoriasVendidas) {
			VendaMercadoria novaVendaMercadoria = VendaMercadoria.builder().venda(novaVenda.getNumeroVenda())
					.mercadoria(novaMercadoria.getCodigo());

			vmRepository.save(novaVendaMercadoria);
		}

		return novaVenda;
	}

	public List<Venda> listarVendas() {
		List<Venda> vendas = vendaRepository.findAll(dataVenda);
		return vendas;
	}

	public List<Venda> listarVendasEmUmaData(LocalDate dataVenda) {
		List<Venda> vendas = vendaRepository.findAllByDataVenda(dataVenda);
		return vendas;
	}
}
