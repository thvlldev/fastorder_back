package com.sistema.api.model.usuario;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuarios")
@Getter 
@Setter 
@AllArgsConstructor 
@NoArgsConstructor 
@EqualsAndHashCode(of = "id")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private String email;
    private String hash_senha;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipo_usuario;

    private boolean ativo = true;
    private LocalDateTime data_cadastro;




    public void excluirLogico() {
        this.ativo = false;
    }


}
