/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.individual.atividade.controller;

import com.individual.atividade.model.AutDTO;
import com.individual.atividade.model.LoginDTO;
import com.individual.atividade.model.UsuarioDTO;
import com.individual.atividade.service.TokenService;
import com.individual.atividade.service.VeiculoService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Aluno
 */
@RestController
@RequestMapping("/api/chave")
public class EntradaController {
    @Autowired
    private TokenService service;
    @Autowired
    private VeiculoService servicea;
@GetMapping("/teste")
    public String testeToken() {
        return service.gerarToken("cesar_souza@desari.com.br");
    }
@PostMapping("/registro")
    public String registrar(@RequestBody UsuarioDTO usuario) {
        servicea.adicionarUsuario(usuario);
        return "sucesso";
    }    
    
@PostMapping("/validar-token")
    public String validarToken(@RequestParam String token) {
        if (service.validarToken(token)) {
            Claims claims = service.extrairClaims(token);
            return "Token válido! Subject: " + claims.getSubject() + 
                   ", Emitido em: " + claims.getIssuedAt() + 
                   ", Expira em: " + claims.getExpiration();
        } else {
            return "Token inválido ou expirado!";
        }
    }
@PostMapping("/logar")
    public String logar(@RequestBody LoginDTO req){
        AutDTO usuario = servicea.Login(req.getUsuario(), req.getSenha());
        if(usuario.getEmail() != null){
            return service.gerarToken(usuario.getEmail());
        }else{
            return "invalido";
        }
    }  
}
