package com.sistema.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sistema.api.model.usuario.DadosLogin;
import com.sistema.api.model.usuario.DadosRespostaLogin;
import com.sistema.api.service.AuthService;

@RestController
@RequestMapping("auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<DadosRespostaLogin> login(@RequestBody DadosLogin dados) {
        return ResponseEntity.ok(authService.login(dados));
    }
}