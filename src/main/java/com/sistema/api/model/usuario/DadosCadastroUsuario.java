package com.sistema.api.model.usuario;

import java.time.LocalDateTime;

public record DadosCadastroUsuario(
    String nome,
    String email,
    String hash_senha,
    TipoUsuario tipo_usuario,
    LocalDateTime data_cadastro
    
) {

    
}
