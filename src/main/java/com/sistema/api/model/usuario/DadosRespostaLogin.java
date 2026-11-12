package com.sistema.api.model.usuario;

public record DadosRespostaLogin(int id, String nome, String email, TipoUsuario tipoUsuario) {
        public DadosRespostaLogin(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getTipo_usuario());
        }   
}
