package com.sistema.api.model.usuario;

public record DadosListagemUsuario(
        int id,
        String nome,
        String email



) {
    public DadosListagemUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail());
    }

}

