package com.sistema.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.api.model.cliente.ClienteRepository;


@RestController 
@RequestMapping("cliente")
public class ClienteController {


    @Autowired 
    public ClienteRepository clienteRepository;

    //CRUD

    


    
}
