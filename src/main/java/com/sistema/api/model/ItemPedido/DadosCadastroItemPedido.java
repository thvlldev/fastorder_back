package com.sistema.api.model.ItemPedido;

import java.util.UUID;

public record DadosCadastroItemPedido(
    int produtoId, 
    UUID pedidoId,
    int quantidade,
    double preco_unitario,
    String observacao
) {
    
}
