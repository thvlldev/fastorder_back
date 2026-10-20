package com.sistema.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.api.model.cliente.*;

import jakarta.transaction.Transactional;


@RestController 
@RequestMapping("cliente")
public class ClienteController {


     @Autowired
    public ClienteRepository clienteRepository;

    //CRUD

    //POST(Criar Clientes)

    @PostMapping("/criar-cliente")
    @Transactional
    public void cadastrarCliente(@RequestBody DadosCadastroCliente dados) {
        clienteRepository.save(new Cliente(dados));
    }

    //GET(Ler Clientes)
    @GetMapping("/listar-clientes")
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    //PUT(Atualizar Clientes)
    @PutMapping("/atualizar-cliente")
    @Transactional
    public void atualizar(@RequestBody DadosAtualizacaoCliente dados) {
        var cliente = clienteRepository.getReferenceById(dados.id());
        cliente.atualizarInfoCliente(dados);
    }

    //DEL(Deletar Cliente(lógico))
    @DeleteMapping("/delete/{id}")
    @Transactional 
    public void deletar(@PathVariable Integer id){
        var cliente = clienteRepository.getReferenceById(id);
        cliente.excluirLogico();
    }




    


    
}
