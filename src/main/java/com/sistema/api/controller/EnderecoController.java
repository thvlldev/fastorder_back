package com.sistema.api.controller;

import java.util.List;


import com.sistema.api.model.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.sistema.api.model.endereco.*;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("endereco")
public class EnderecoController {

    @Autowired
    public EnderecoRepository enderecoRepository;

    @Autowired
    public UsuarioRepository usuarioRepository;
    //CRUD

    //POST(Criar Enderecos)

    @PostMapping("/criar-endereco")
    @Transactional
    public void cadastrarEndereco(@RequestBody DadosCadastroEndereco dados) {
        var usuario = usuarioRepository.getReferenceById(dados.usuarioId());
        enderecoRepository.save(new Endereco(dados,usuario));
    }

    //GET(Ler Enderecos)
    @GetMapping("/listar-enderecos")
    public List<Endereco> listarEnderecos() {
        return enderecoRepository.findAll();
    }

    //PUT(Atualizar Enderecos)
    @PutMapping("/atualizar-endereco")
    @Transactional
    public void atualizar(@RequestBody DadosAtualizacaoEndereco dados) {
        var endereco = enderecoRepository.getReferenceById(dados.id());
        endereco.atualizarInfoEndereco(dados);
    }

    //DEL(Deletar Endereco(lógico))
    @DeleteMapping("/delete/{id}")
    @Transactional
    public void deletar(@PathVariable int id){
        var endereco = enderecoRepository.getReferenceById(id);
        endereco.excluirLogico();
    }



}
