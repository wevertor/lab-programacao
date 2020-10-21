package com.trindade.mapping.models.repository;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.trindade.mapping.model.Venda;
import com.trindade.mapping.model.repositorio.VendaRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class VendasRepositoryTest {
	@Autowired
	VendaRepository repository;

	@Test
	void testeSalvarVenda() {
		// cenario

		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date dataVenda = formato.parse("05/10/2020");
		Venda venda = Venda.builder().dataVenda(dataVenda).build();

		// ação
		Venda salvo = repository.save(venda);

		// verificação
		Assertions.assertNotNull(salvo);
		Assertions.assertNotEquals(venda.getId(), salvo.getId());
		Assertions.assertEquals(venda.getDataVenda(), salvo.getDataVenda());
	}

	@Test
	void testeListarPorData() {
		// cenário
		List<Venda> vendas = new ArrayList<Venda>();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

		LocalDate dataVenda1 = converteData(formato.parse("01/10/2020"));
		Venda venda1 = Venda.builder().dataVenda(dataVenda1).build();
		vendas.add(venda1);

		LocalDate dataVenda2 = converteData(formato.parse("01/10/2020"));
		Venda venda2 = Venda.builder().dataVenda(dataVenda2).build();
		vendas.add(venda2);

		LocalDate dataVenda3 = converteData(formato.parse("02/10/2020"));
		Venda venda3 = Venda.builder().dataVenda(dataVenda3).build();
		vendas.add(venda3);

		for (Venda venda : vendas) {
			repository.save(venda);
		}

		// ação
		LocalDate dataTeste = converteData(formato.parse("01/10/2020"));
		List<Venda> vendasNoDia = repository.findAllByDataVenda(dataTeste);

		// verificação
		for (Venda venda : vendasNoDia) {
			Assertions.assertEquals(venda.getDataVenda(), dataTeste);
		}
	}

	// converte Date -> LocalDate
	LocalDate converteData(Date data) {
		return data.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
}
