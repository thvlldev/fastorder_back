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


    public Usuario(DadosCadastroUsuario dados){
        this.nome = dados.nome();
        this.email = dados.email();
        this.hash_senha = dados.hash_senha();
        this.tipo_usuario = dados.tipo_usuario();
        this.data_cadastro = dados.data_cadastro();
    }

    public void atualizarInfoUsuario(DadosAtualizacaoUsuario dados){
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
         if (dados.email() != null) {
            this.email = dados.email();
        }
    }

    public void excluirLogico() {
        this.ativo = false;
    }


}
