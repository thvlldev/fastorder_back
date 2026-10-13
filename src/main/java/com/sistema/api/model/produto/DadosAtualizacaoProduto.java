package com.sistema.api.model.produto;

public record DadosAtualizacaoProduto(
    Integer id,
    String nome,
    String descricao,
    Double preco,
    String imagem,
    Status status,
    Categoria categoria
) {
    
}
