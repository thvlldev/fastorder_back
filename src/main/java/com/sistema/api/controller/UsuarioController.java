package com.sistema.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.sistema.api.model.usuario.*;

import jakarta.transaction.Transactional;

@RestController 
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    public UsuarioRepository usuarioRepository;

    //CRUD

    //POST(Criar Usuarios)

    @PostMapping("/criar-usuario")
    @Transactional
    public void cadastrarUsuario(@RequestBody DadosCadastroUsuario dados) {
        usuarioRepository.save(new Usuario(dados));
    }

    //GET(Ler Usuarios)
    @GetMapping("/listar-usuarios")
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    //PUT(Atualizar Usuarios)
    @PutMapping("/atualizar-usuario")
    @Transactional
    public void atualizar(@RequestBody DadosAtualizacaoUsuario dados) {
        var usuario = usuarioRepository.getReferenceById(dados.id());
        usuario.atualizarInfoUsuario(dados);
    }

    //DEL(Deletar Usuario(lógico))
    @DeleteMapping("/delete/{id}")
    @Transactional 
    public void deletar(@PathVariable Integer id){
        var usuario = usuarioRepository.getReferenceById(id);
        usuario.excluirLogico();
    }

    
    
}
