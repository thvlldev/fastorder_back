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
    private MetodoPagamento metodoPagamento;

    
    public Cliente(DadosCadastroCliente dados) {
        this.telefone = dados.telefone();
        this.metodoPagamento = dados.metodoPagamento();
    }

    public void atualizarInfoCliente(DadosAtualizacaoCliente dados) {
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.metodoPagamento() != null) {
            this.metodoPagamento = dados.metodoPagamento();
        }


    }



    
    



    
}
