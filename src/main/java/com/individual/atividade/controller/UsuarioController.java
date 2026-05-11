/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.individual.atividade.controller;

import com.individual.atividade.model.UsuarioDTO;
import com.individual.atividade.service.TokenService;
import com.individual.atividade.service.VeiculoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Aluno
 */
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    @Autowired
    private VeiculoService UsuarioService;
@GetMapping
    public List<UsuarioDTO> lerUsuario() {
        return UsuarioService.lerUsuario();
    }
@PostMapping("/adicionar")
    public String adicionar(@RequestBody UsuarioDTO usuario) {
        UsuarioService.adicionarUsuario(usuario);
        return "usuario adicionado com sucesso!";
    }    
@Autowired
private TokenService TokenService;

@GetMapping("/autorizacao")
    public List<UsuarioDTO> LerUsuario(@RequestHeader("Authorization") String auth){    
        String token = auth.replace("Bearer ", "");
        TokenService.validarToken(token);
            return UsuarioService.lerUsuario();   
}
}    