package com.sistema.api.service;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.sistema.api.model.usuario.*;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public AuthService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public DadosRespostaLogin login(DadosLogin dados) {
        // 1. procura o usuário pelo e-mail
        var usuario = usuarioRepository.findByEmail(dados.email())
            .orElseThrow(this::credenciaisInvalidas);

        // 2. usuário excluído (lógico) não pode entrar
        if (!usuario.isAtivo()) {
            throw credenciaisInvalidas();
        }

        // 3. compara a senha digitada com o hash do banco
        if (!encoder.matches(dados.senha(), usuario.getHash_senha())) {
            throw credenciaisInvalidas();
        }

        // 4. deu certo: devolve os dados sem o hash
        return new DadosRespostaLogin(usuario);
    }

    private ResponseStatusException credenciaisInvalidas() {
        return new ResponseStatusException(HttpStatus.UNAUTHORIZED, "E-mail ou senha inválidos");
    }
}