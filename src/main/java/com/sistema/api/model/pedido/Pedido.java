package com.sistema.api.model.pedido;
import java.time.LocalDateTime;
import java.util.UUID;

import com.sistema.api.model.usuario.Usuario;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table (name = "pedido")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "pedido_id")
    private UUID id;

    @ManyToOne
    @JoinColumn (name="usuario_id")
    private Usuario usuario;

    @Column(name = "pedido_numero")
    private String numero;

    @Column(name = "pedido_data")
    private LocalDateTime data;

    @Column(name = "pedido_total")
    private double total;

    @Column(name = "pedido_ativo")
    private boolean ativo = true;

    @Enumerated (EnumType.STRING)
    @Column(name = "pedido_status")
    private Status status;

    public Pedido(DadosCadastroPedido dados,Usuario usuario){
        this.usuario= usuario;
        this.numero = dados.numero();
        this.data = dados.data();
        this.total = dados.total();
        this.status =dados.status();

    }

    public void atualizarInfoPedido(DadosAtualizacaoPedido dados){
        if(dados.status() != null){
            this.status = dados.status();
        }
    }


    public void excluirLogico() {
        this.ativo = false;
    }


}