package com.sistema.api.model.cliente;

public record DadosAtualizacaoCliente(
    int id,
    String telefone,
    MetodoPagamento metodoPagamento
) {
    
}
