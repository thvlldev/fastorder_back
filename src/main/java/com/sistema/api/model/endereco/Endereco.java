package com.sistema.api.model.endereco;

import com.sistema.api.model.usuario.Usuario;

import jakarta.persistence.*;
import lombok.*;

@Entity 
@Table (name = "enderecos")
@Getter 
@Setter 
@AllArgsConstructor 
@NoArgsConstructor 

public class Endereco {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne 
    @JoinColumn (name = "usuarioId") 
    private Usuario usuario;

    private String logradouro;
    private String numero;
    private String complemento;
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
