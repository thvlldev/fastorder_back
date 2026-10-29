package com.sistema.api.model.ItemPedido;

import java.io.Serializable;
import java.util.UUID;

import lombok.*;


@Getter 
@Setter 
@AllArgsConstructor 
@NoArgsConstructor
@EqualsAndHashCode  
public class ItemPedidoId implements Serializable{
    
    private UUID pedido;
    private int produto;
}
