package com.sistema.api.model.endereco;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.api.model.usuario.Usuario;

public interface EnderecoRepository extends JpaRepository<Usuario, Integer> {
    
}
