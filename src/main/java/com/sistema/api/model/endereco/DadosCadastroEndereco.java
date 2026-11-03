package com.sistema.api.model.endereco;

public record DadosCadastroEndereco(
    int usuarioId,
    String logradouro,
    String numero,
    String complemento
) {
    
}
