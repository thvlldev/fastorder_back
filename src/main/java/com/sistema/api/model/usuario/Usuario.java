package com.sistema.api.model.usuario;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private int id;

    @Column(name = "usuario_nome")
    private String nome;

    @Column(name = "usuario_email")
    private String email;

    @Column(name = "usuario_hash_senha")
    private String hash_senha;

    @Enumerated(EnumType.STRING)
    @Column(name = "usuario_tipo_usuario")
    private TipoUsuario tipo_usuario;

    @Column(name = "usuario_ativo")
    private boolean ativo = true;

    @Column(name = "usuario_data_cadastro")
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