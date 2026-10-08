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

    @ManyToOne 
    @JoinColumn (name = "usuarioId")
    private Usuario usuario;

    private String logradouro;
    private String numero;
    private String complemento;
    private boolean ativo = true;



    public void excluirLogico() {
        this.ativo = false;
    }
    
}
