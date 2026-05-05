/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.individual.atividade.model;

/**
 *
 * @author Aluno
 */
public class VeiculoDTO {
  private int id_veículo;
  private String placa;
  private String modelo;

  public VeiculoDTO(){
    }
    public VeiculoDTO(int id_veículo, String placa, String modelo) {
        this.id_veículo = id_veículo;
        this.placa = placa;
        this.modelo = modelo;
    }

    public int getId_veículo() {
        return id_veículo;
    }

    public void setId_veículo(int id_veículo) {
        this.id_veículo = id_veículo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
}
