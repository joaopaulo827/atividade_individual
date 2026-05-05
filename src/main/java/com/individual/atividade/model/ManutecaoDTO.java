/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.individual.atividade.model;

/**
 *
 * @author Aluno
 */
public class ManutecaoDTO {
    private int id_veiculo;
    private String serviço;
    private double preço;

    public ManutecaoDTO() {
    }    

    public ManutecaoDTO(int id_veiculo, String serviço, double preço) {
        this.id_veiculo = id_veiculo;
        this.serviço = serviço;
        this.preço = preço;
    }

    public int getId_veiculo() {
        return id_veiculo;
    }

    public void setId_veiculo(int id_veiculo) {
        this.id_veiculo = id_veiculo;
    }

    public String getServiço() {
        return serviço;
    }

    public void setServiço(String serviço) {
        this.serviço = serviço;
    }

    public double getPreço() {
        return preço;
    }

    public void setPreço(double preço) {
        this.preço = preço;
    }
   
}
