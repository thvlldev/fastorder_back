package com.sistema.api.model.pedido;



import java.time.LocalDateTime;

public record DadosCadastroPedido(
    int usuarioId,
    String numero,
    LocalDateTime data,
    double total,
    Status status
) {
}
