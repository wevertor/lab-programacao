package com.trindade.mapping.controller;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class VendaDTO {
    private List<MercadoriaDTO> listaMercadorias;
}