/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.individual.atividade.service;

import com.individual.atividade.model.ManutecaoDTO;
import com.individual.atividade.model.VeiculoDTO;
import com.individual.atividade.repository.VeiculoDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Aluno
 */
@Service
public class VeiculoService {
@Autowired
    private VeiculoDAO repository;

    public List<VeiculoDTO> lerVeiculos() {
        
        return repository.lerVeiculos();
    }
    public List<ManutecaoDTO> lerManutecao() {
        return repository.lerManutecao();
    }
    public void adicionar(ManutecaoDTO manutecao) {
        
        repository.adicionar(manutecao);
    }
    public ManutecaoDTO ValorTotal(int id) {
        return repository.ValorTotal(id);
    }    
}
