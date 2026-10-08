package com.sistema.api.model.pedido;
import java.time.LocalDateTime;
import java.util.UUID;

import com.sistema.api.model.usuario.Usuario;

import jakarta.persistence.*;
import lombok.*;


@Entity 
@Table (name = "produtos")
@Getter 
@Setter 
@AllArgsConstructor 
@NoArgsConstructor 
public class Pedido {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn (name="usuarioId")
    private Usuario usuario;

    private String numero;


    private LocalDateTime data;
    private double total;
    private boolean ativo = true;

    @Enumerated (EnumType.STRING)
    private Status status;


    



    public void excluirLogico() {
        this.ativo = false;
    }


}


