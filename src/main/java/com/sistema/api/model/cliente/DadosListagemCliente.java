package com.sistema.api.model.cliente;

public record DadosListagemCliente(
        Integer id,
        String nome,
        String email,
        String telefone,
        MetodoPagamento metodoPagamento
) {
}