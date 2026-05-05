/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.individual.atividade.repository;

import com.individual.atividade.model.ManutecaoDTO;
import com.individual.atividade.model.VeiculoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Aluno
 */
@Repository
public class VeiculoDAO {
    public List<VeiculoDTO> lerVeiculos() {
        List<VeiculoDTO> dados = new ArrayList();
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conn.prepareStatement("SELECT * FROM veículos");
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                VeiculoDTO veiculo = new VeiculoDTO();
                veiculo.setId_veículo(rs.getInt("id_veículo"));
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setModelo(rs.getString("modelo"));
                dados.add(veiculo);
            }
        } catch(SQLException e ) {
            e.printStackTrace();
        }
        return dados;
    }
    public List<ManutecaoDTO> lerManutecao() {
        List<ManutecaoDTO> ler = new ArrayList();
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conn.prepareStatement("SELECT * FROM manutecoes");
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                ManutecaoDTO manuteção = new ManutecaoDTO();
                manuteção.setId_veiculo(rs.getInt("id_veículo"));
                manuteção.setServiço(rs.getString("serviço"));
                manuteção.setPreço(rs.getDouble("preço"));
                ler.add(manuteção);
            }
        } catch(SQLException e ) {
            e.printStackTrace();
        }
        return ler;
    }    
    
 public void adicionar(ManutecaoDTO manutecao) {
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("INSERT INTO manutecoes (id_veículo, serviço, preço)"
                    + "VALUES (?,?,?)");
            stmt.setInt(1, manutecao.getId_veiculo());
            stmt.setString(2, manutecao.getServiço());
            stmt.setDouble(3, manutecao.getPreço());
            stmt.executeUpdate();
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
public ManutecaoDTO ValorTotal(int id) {
        ManutecaoDTO total = new ManutecaoDTO();
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conn.prepareStatement("SELECT * FROM manutecoes WHERE id_veículo=?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            if(rs.next()) {
                total.setId_veiculo(rs.getInt("id_veículo"));
                total.setPreço(rs.getDouble("preço"));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return total;
    }
 
}

