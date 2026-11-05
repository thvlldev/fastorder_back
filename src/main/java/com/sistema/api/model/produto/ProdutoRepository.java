package com.sistema.api.model.produto;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    List<Produto> findByAtivoTrue();
    List<Produto> findByNomeContainingIgnoreCaseAndAtivoTrue(String nome);





}
