package com.trindade.mapping.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class MercadoriaDTO {
    private String codigo;
    private String data;
    private String descricao;
}
