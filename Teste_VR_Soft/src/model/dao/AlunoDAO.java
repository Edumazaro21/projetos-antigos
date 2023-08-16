/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionDefinations;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Aluno;

/**
 *
 * @author eduma
 */
public class AlunoDAO {
    
    public void create(Aluno aluno){
        
        Connection con = ConnectionDefinations.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO aluno (nome) VALUES(?)");
            stmt.setString(1, aluno.getNome());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Dados salvos com sucesso !");
                    
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
            }finally{
            ConnectionDefinations.closeConnection(con, stmt);
        }
        
    }
    public void update(Aluno aluno){
        
        Connection con = ConnectionDefinations.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE aluno SET nome = ? WHERE codigo = ?");
            stmt.setString(1, aluno.getNome());
            stmt.setInt(2, aluno.getCodigo());
            
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("UPDATE curso_aluno SET nome_aluno = ? WHERE codigo_aluno = ?");
            stmt.setString(1, aluno.getNome());
            stmt.setInt(2, aluno.getCodigo());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso !");
                    
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar: "+ex);
            }finally{
            ConnectionDefinations.closeConnection(con, stmt);
        }
        
    }
    
    public void delete(Aluno aluno){
        
        Connection con = ConnectionDefinations.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM aluno WHERE codigo = ?");
            stmt.setInt(1, aluno.getCodigo());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Aluno excluido com sucesso !");
                    
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao excluir: "+ex);
            }finally{
            ConnectionDefinations.closeConnection(con, stmt);
        }
        
    }
    
    public List<Aluno> readAll(){
        
        Connection con = ConnectionDefinations.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Aluno> alunos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM aluno");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Aluno aluno = new Aluno();
                
                aluno.setCodigo(rs.getInt("codigo"));
                aluno.setNome(rs.getString("nome"));
                
                alunos.add(aluno);
                
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao ler arquivos do banco "+ex);
        } finally{
            ConnectionDefinations.closeConnection(con, stmt, rs);
        }       
        return alunos;
    }
    public List<Aluno> readNome(Aluno aluno){
        
        Connection con = ConnectionDefinations.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Aluno> alunos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM aluno WHERE nome = ?");
            stmt.setString(1, aluno.getNome());
            rs = stmt.executeQuery();
            
            if(!rs.next()){
                JOptionPane.showMessageDialog(null, "Aluno não Cadastrado");
                throw new IllegalArgumentException("Aluno não Cadastrado");
            }
            else{
                aluno.setCodigo(rs.getInt("codigo"));
                aluno.setNome(rs.getString("nome"));
                
                alunos.add(aluno);
            } 
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao ler arquivos do banco "+ex);
        } finally{
            ConnectionDefinations.closeConnection(con, stmt, rs);
        }       
        return alunos;
    }
    public List<Aluno> readCodigo(Aluno aluno){
        
        Connection con = ConnectionDefinations.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Aluno> alunos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM aluno WHERE codigo = ?");
            stmt.setInt(1, aluno.getCodigo());
            rs = stmt.executeQuery();
            
            if(!rs.next()){
                JOptionPane.showMessageDialog(null, "Aluno não Cadastrado");
                throw new IllegalArgumentException("Aluno não Cadastrado");
            }else {
                            
                aluno.setCodigo(rs.getInt("codigo"));
                aluno.setNome(rs.getString("nome"));
                
                alunos.add(aluno);
                
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao ler arquivos do banco "+ex);
        } finally{
            ConnectionDefinations.closeConnection(con, stmt, rs);
        }       
        return alunos;
    }
    
}
