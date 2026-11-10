package com.sistema.api.model.produto;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table (name = "produto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "produto_id")
    private int id;

    @Column(name = "produto_nome")
    private String nome;

    @Column(name = "produto_descricao")
    private String descricao;

    @Column(name = "produto_preco")
    private double preco;

    @Column(name = "produto_imagem")
    private String imagem;

    @Enumerated (EnumType.STRING)
    @Column(name = "produto_status")
    private Status status;

    @Enumerated (EnumType.STRING)
    @Column(name = "produto_categoria")
    private Categoria categoria;

    @Column(name = "produto_ativo")
    private boolean ativo = true;


    //CONSTRUTOR DO DTO

    public Produto(DadosCadastroProduto dados) {
        this.nome = dados.nome();
        this.descricao = dados.descricao();
        this.preco = dados.preco();
        this.imagem = dados.imagem();
        this.status = dados.status();
        this.categoria = dados.categoria();
    }


    //Método para atualizar informações do produto(VERBO PUT)

    public void atualizarInfoProduto(DadosAtualizacaoProduto dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.descricao() != null) {
            this.descricao = dados.descricao();
        }
        if (dados.preco() != null) {
            this.preco = dados.preco();
        }
        if (dados.imagem() != null) {
            this.imagem = dados.imagem();
        }
        if (dados.status() != null) {
            this.status = dados.status();
        }
        if (dados.categoria() != null) {
            this.categoria = dados.categoria();
        }
    }



    public void excluirLogico() {
        this.ativo = false;
    }


}