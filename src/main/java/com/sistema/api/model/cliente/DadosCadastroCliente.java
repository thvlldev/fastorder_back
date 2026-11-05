package com.sistema.api.model.cliente;

public record DadosCadastroCliente(
        String nome,
        String email,
        String senha,
        String telefone,
        MetodoPagamento metodoPagamento
) {




}
