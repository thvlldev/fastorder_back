package com.sistema.api.model.endereco;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
    List<Endereco> findByUsuarioIdAndAtivoTrue(int usuarioId);




}
