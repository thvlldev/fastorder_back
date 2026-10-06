package com.sistema.api.model.cliente;

import com.sistema.api.model.usuario.Usuario;

import jakarta.persistence.*;
import lombok.*;


@Entity 
@Table (name = "clientes")
@Getter 
@Setter 
@AllArgsConstructor 
@NoArgsConstructor 
public class Cliente extends Usuario{

    private String telefone;

    @Enumerated (EnumType.STRING)
    private MetodoPagamento metodo_pagamento;



    
    



    
}
