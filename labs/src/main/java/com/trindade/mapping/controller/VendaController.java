package com.trindade.mapping.controller;

import java.util.List;

import com.trindade.mapping.model.Mercadoria;
import com.trindade.mapping.model.Venda;
import com.trindade.mapping.service.VendaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/venda")
public class VendaController {

    @Autowired
    VendaService service;

    @PostMapping
    public ResponseEntity salvar(@RequestBody VendaDTO dto) {

        List<MercadoriaDTO> mercadoriasDTO = dto.getListaMercadoria();
        List<Mercadoria> mercadorias;

        for (MercadoriaDTO mercadoriaDTO : mercadoriasDTO) {
            Mercadoria mercadoria = Mercadoria.builder().codigo(mercadoriaDTO.getCodigo())
                    .descricao(mercadoriaDTO.getDescricao());
            mercadorias.add(mercadoria);
        }

        try {
            Venda venda = service.venderMercadoria(mercadorias);
            return new ResponseEntity(venda, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity listarVendas() {
        try {
            List<Venda> vendas = service.listarVendas();
            return new ResponseEntity(vendas, HttpStatus.ACCEPTED);
        } catch (RuntimeException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
