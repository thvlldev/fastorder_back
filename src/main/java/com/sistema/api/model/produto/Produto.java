package com.sistema.api.model.produto;

import jakarta.persistence.*;
import lombok.*;

@Entity 
@Table (name = "produtos")
@Getter 
@Setter 
@AllArgsConstructor 
@NoArgsConstructor 
@EqualsAndHashCode(of = "id")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private String descricao;
    private double preco;
    private String imagem;

    @Enumerated (EnumType.STRING)
    private Status status;

    @Enumerated (EnumType.STRING)
    private Categoria categoria;

    private boolean ativo = true;



    


    public void excluirLogico() {
        this.ativo = false;
    }

    
}
