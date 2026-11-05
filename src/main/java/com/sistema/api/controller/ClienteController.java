package com.sistema.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.web.bind.annotation.*;

import com.sistema.api.model.cliente.*;

import jakarta.transaction.Transactional;


@RestController 
@RequestMapping("cliente")
public class ClienteController {


     @Autowired
    public ClienteRepository clienteRepository;

    //CRUD

    //POST(Criar Clientes)

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @PostMapping("/criar-cliente")
    @Transactional
    public void cadastrarCliente(@RequestBody DadosCadastroCliente dados) {
        var hash = encoder.encode(dados.senha());
        clienteRepository.save(new Cliente(dados, hash));
    }

    //GET(Ler Clientes)
    @GetMapping("/listar-clientes")
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    @GetMapping("/buscar-cliente/{id}")
    public DadosListagemCliente buscarPorId(@PathVariable int id) {
        var cliente = clienteRepository.findById(id).orElseThrow();
        return new DadosListagemCliente(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone(), cliente.getMetodoPagamento());
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
