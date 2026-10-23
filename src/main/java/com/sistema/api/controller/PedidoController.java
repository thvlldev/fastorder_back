package com.sistema.api.controller;

import java.util.List;
import java.util.UUID;

import com.sistema.api.model.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.sistema.api.model.pedido.*;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    public PedidoRepository pedidoRepository;

    @Autowired
    public UsuarioRepository usuarioRepository;
    //CRUD

    //POST(Criar Pedidos)

    @PostMapping("/criar-pedido")
    @Transactional
    public void cadastrarPedido(@RequestBody DadosCadastroPedido dados) {
        var usuario = usuarioRepository.getReferenceById(dados.usuarioId());
        pedidoRepository.save(new Pedido(dados,usuario));
    }

    //GET(Ler Pedidos)
    @GetMapping("/listar-pedidos")
    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    //PUT(Atualizar Pedidos)
    @PutMapping("/atualizar-pedido")
    @Transactional
    public void atualizar(@RequestBody DadosAtualizacaoPedido dados) {
        var pedido = pedidoRepository.getReferenceById(dados.id());
        pedido.atualizarInfoPedido(dados);
    }

    //DEL(Deletar Pedido(lógico))
    @DeleteMapping("/delete/{id}")
    @Transactional
    public void deletar(@PathVariable UUID id){
        var pedido = pedidoRepository.getReferenceById(id);
        pedido.excluirLogico();
    }



}
