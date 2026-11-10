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
    @JoinColumn (name = "produto_id")
    @Id
    private Produto produto;

    @ManyToOne
    @JoinColumn (name = "pedido_id")
    @Id
    private Pedido pedido;

    @Column(name = "itens_pedido_quantidade")
    private int quantidade;

    @Column(name = "itens_pedido_preco_unitario")
    private double preco_unitario;

    @Column(name = "itens_pedido_observacao")
    private String observacao;

    public ItemPedido(DadosCadastroItemPedido dados, Produto produto, Pedido pedido) {
        this.produto = produto;
        this.pedido = pedido;
        this.quantidade = dados.quantidade();
        this.preco_unitario = dados.preco_unitario();
        this.observacao = dados.observacao();
    }

}