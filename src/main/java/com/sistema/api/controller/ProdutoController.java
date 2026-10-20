package com.sistema.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.sistema.api.model.produto.*;

import jakarta.transaction.Transactional;

@RestController 
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    public ProdutoRepository produtoRepository;

    //CRUD

    //POST(Criar Produtos)

    @PostMapping("/criar-produto")
    @Transactional
    public void cadastrarProduto(@RequestBody DadosCadastroProduto dados) {
        produtoRepository.save(new Produto(dados));
    }

    //GET(Ler Produtos)
    @GetMapping("/listar-produtos")
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    //PUT(Atualizar Produtos)
    @PutMapping("/atualizar-produto")
    @Transactional
    public void atualizar(@RequestBody DadosAtualizacaoProduto dados) {
        var produto = produtoRepository.getReferenceById(dados.id());
        produto.atualizarInfoProduto(dados);
    }

    //DEL(Deletar Produto(lógico))
    @DeleteMapping("/delete/{id}")
    @Transactional 
    public void deletar(@PathVariable Integer id){
        var produto = produtoRepository.getReferenceById(id);
        produto.excluirLogico();
    }

    
    
}
