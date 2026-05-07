/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.individual.atividade.controller;

import com.individual.atividade.model.ManutecaoDTO;
import com.individual.atividade.model.UsuarioDTO;
import com.individual.atividade.model.VeiculoDTO;
import com.individual.atividade.service.VeiculoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Aluno
 */
@RestController
@RequestMapping("/api/veiculos")
public class VeiculoAPIController {
    
@Autowired
    private VeiculoService VeiculoService;
@GetMapping
    public List<VeiculoDTO> lerVeiculos() {
        return VeiculoService.lerVeiculos();
    }
@GetMapping("/manutecoes")
    public List<ManutecaoDTO> lerManutecao() {
        return VeiculoService.lerManutecao();
    }
@GetMapping("/usuario")
    public List<UsuarioDTO> lerUsuario() {
        return VeiculoService.lerUsuario();
    }     
@PostMapping("/manutecoes")
    public String criar(@RequestBody ManutecaoDTO manutecao) {
        VeiculoService.adicionar(manutecao);
        return "serviço adicionado com sucesso!";
    }
@PostMapping("/usuario")
    public String adicionar(@RequestBody UsuarioDTO usuario) {
        VeiculoService.adicionarUsuario(usuario);
        return "usuario adicionado com sucesso!";
    }    
@GetMapping("/{id}/gastos")
    public ManutecaoDTO ValorTotal(@PathVariable int id) {
        return VeiculoService.ValorTotal(id);
    }
@PostMapping("/login")
    public Object Login(@RequestBody UsuarioDTO user){
        UsuarioDTO usuarioLogado =VeiculoService.Login(user.getNome(), user.getEmail());
        if(user!= null){
          return user;  
        }
        return  "Email ou senha errada";      
    }    
}
