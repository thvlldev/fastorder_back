package com.sistema.api.model.endereco;

import com.sistema.api.model.usuario.Usuario;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table (name = "endereco_cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "endereco_cliente_id")
    private int id;

    @ManyToOne
    @JoinColumn (name = "usuario_id")
    private Usuario usuario;

    @Column(name = "endereco_cliente_logradouro")
    private String logradouro;

    @Column(name = "endereco_cliente_numero")
    private String numero;

    @Column(name = "endereco_cliente_complemento")
    private String complemento;

    @Column(name = "endereco_cliente_status")
    private boolean ativo = true;



    public Endereco(DadosCadastroEndereco dados,Usuario usuario){
        this.usuario= usuario;
        this.logradouro = dados.logradouro();
        this.numero = dados.numero();
        this.complemento = dados.complemento();

    }

    public void atualizarInfoEndereco(DadosAtualizacaoEndereco dados){
        if(dados.logradouro()!=null){
            this.logradouro = dados.logradouro();
        }
        if(dados.numero()!=null){
            this.numero = dados.numero();
        }
        if(dados.complemento()!=null){
            this.complemento = dados.complemento();
        }
    }



    public void excluirLogico() {
        this.ativo = false;
    }

}