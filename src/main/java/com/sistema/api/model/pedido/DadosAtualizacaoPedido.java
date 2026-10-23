package com.sistema.api.model.pedido;

import java.util.UUID;

public record DadosAtualizacaoPedido(
        UUID id,
        Status status
) {
}
