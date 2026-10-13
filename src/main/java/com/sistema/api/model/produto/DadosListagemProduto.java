package com.sistema.api.model.produto;

public record DadosListagemProduto(
    Integer id,
    String nome,
    String descricao,
    Double preco,
    String imagem,
    Status status,
    Categoria categoria,
    Boolean ativo
) {
    
}
