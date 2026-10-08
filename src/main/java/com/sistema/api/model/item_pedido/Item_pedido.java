package com.sistema.api.model.item_pedido;

import com.sistema.api.model.pedido.Pedido;
import com.sistema.api.model.produto.Produto;

import jakarta.persistence.*;
import lombok.*;


@Entity 
@Table (name = "itens_pedido")
@Getter 
@Setter 
@AllArgsConstructor 
@NoArgsConstructor 
public class Item_pedido {

    
    @ManyToOne
    @JoinColumn (name = "produtoId") 
    private Produto produto;

    @ManyToOne
    @JoinColumn (name = "pedidoId")
    private Pedido pedido;

    private int quantidade;

    private double preco_unitario;

    private String observacao;


    
}
