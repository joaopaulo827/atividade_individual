/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.individual.atividade.controller;

import com.individual.atividade.model.ManutecaoDTO;
import com.individual.atividade.service.TokenService;
import com.individual.atividade.service.VeiculoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/api/manutecao")
public class ManutecaoController {
@Autowired
    private VeiculoService ManutecaoService;
@GetMapping()
    public List<ManutecaoDTO> lerManutecao() {
        return ManutecaoService.lerManutecao();
    }     
@PostMapping("/adicionar")
    public String criar(@RequestBody ManutecaoDTO manutecao) {
        ManutecaoService.adicionar(manutecao);
        return "serviço adicionado com sucesso!";
    }   
@GetMapping("/{id}/gastos")
    public ManutecaoDTO ValorTotal(@PathVariable int id) {
        return ManutecaoService.ValorTotal(id);
    }
    @Autowired
private TokenService TokenService;
    
@GetMapping("/autorizacao")
    public List<ManutecaoDTO> Manutecao(@RequestHeader("Authorization") String auth){    
        String token = auth.replace("Bearer ", "");
        TokenService.validarToken(token);
            return ManutecaoService.lerManutecao();
}    
}
