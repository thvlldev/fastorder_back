package com.sistema.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sistema.api.model.ItemPedido.DadosCadastroItemPedido;
import com.sistema.api.model.ItemPedido.ItemPedido;
import com.sistema.api.model.ItemPedido.ItemPedidoRepository;
import com.sistema.api.model.pedido.PedidoRepository;
import com.sistema.api.model.produto.ProdutoRepository;

import jakarta.transaction.Transactional;

  @RestController 
  @RequestMapping("/item_pedido")
public class ItemPedidoController {
    
  

    @Autowired 
    public ItemPedidoRepository itemPedidoRepository;

    @Autowired 
    public ProdutoRepository ProdutoRepository;

    @Autowired 
    public PedidoRepository PedidoRepository;

    //CRUD



    //POST

    @PostMapping("/criar-item_pedido")
    @Transactional
    public ItemPedido cadastrarItemPedido(@RequestBody DadosCadastroItemPedido dados) {
        var produto = ProdutoRepository.getReferenceById(dados.produtoId());
        var pedido = PedidoRepository.getReferenceById(dados.pedidoId());
        var ItemPedido = new ItemPedido(dados, produto,pedido);
        return itemPedidoRepository.save(ItemPedido);
    }

    //GET

    @GetMapping("/listar-item_pedido")
    public List<ItemPedido> listarItensPedido() {
        return itemPedidoRepository.findAll();
    }


}
