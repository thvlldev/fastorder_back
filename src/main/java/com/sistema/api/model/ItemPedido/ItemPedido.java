package com.sistema.api.model.ItemPedido;

import com.sistema.api.model.pedido.Pedido;
import com.sistema.api.model.produto.Produto;

import jakarta.persistence.*;
import lombok.*;


@Entity 
@Table (name = "itens_pedido")
@IdClass(ItemPedidoId.class)// falar com o professor William
@Getter 
@Setter 
@AllArgsConstructor 
@NoArgsConstructor 
public class ItemPedido {

    
    @ManyToOne
    @JoinColumn (name = "produtoId")
    @Id 
    private Produto produto;

    @ManyToOne
    @JoinColumn (name = "pedidoId")
    @Id 
    private Pedido pedido;

    private int quantidade;

    private double preco_unitario;

    private String observacao;

    public ItemPedido(DadosCadastroItemPedido dados, Produto produto, Pedido pedido) {
        this.produto = produto;
        this.pedido = pedido;
        this.quantidade = dados.quantidade();
        this.preco_unitario = dados.preco_unitario();
        this.observacao = dados.observacao();
    }
    
}
