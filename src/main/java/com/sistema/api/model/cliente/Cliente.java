package com.sistema.api.model.cliente;

import com.sistema.api.model.usuario.TipoUsuario;
import com.sistema.api.model.usuario.Usuario;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


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


    public Cliente(DadosCadastroCliente dados, String hashSenha) {
        this.setNome(dados.nome());
        this.setEmail(dados.email());
        this.setHash_senha(hashSenha);
        this.setTipo_usuario(TipoUsuario.CLIENTE);
        this.setData_cadastro(LocalDateTime.now());
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
