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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Curso;

/**
 *
 * @author eduma
 */
public class CursoDAO {
    
    public void create(Curso curso){
        
        Connection con = ConnectionDefinations.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO curso (descricao,ementa) VALUES(?,?)");
            stmt.setString(1, curso.getDescricao());
            stmt.setString(2, curso.getEmenta());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Dados salvos com sucesso !");
                    
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
            }finally{
            ConnectionDefinations.closeConnection(con, stmt);
        }
        
    }
    public void update(Curso curso){
        
        Connection con = ConnectionDefinations.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE curso SET descricao = ? , ementa = ? WHERE codigo = ?");
            stmt.setString(1, curso.getDescricao());
            stmt.setString(2, curso.getEmenta());
            stmt.setInt(3, curso.getCodigo());
            
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("UPDATE curso_aluno SET descricao_curso = ? , ementa_curso = ? WHERE codigo_curso = ?");
            stmt.setString(1, curso.getDescricao());
            stmt.setString(2, curso.getEmenta());
            stmt.setInt(3, curso.getCodigo());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Curso atualizado com sucesso !");
                    
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar curso: "+ex);
            }finally{
            ConnectionDefinations.closeConnection(con, stmt);
        }
        
    }
    
    public void delete(Curso curso){
        
        Connection con = ConnectionDefinations.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM curso WHERE codigo = ?");
            stmt.setInt(1, curso.getCodigo());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Curso excluido com sucesso !");
                    
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao excluir curso: "+ex);
            }finally{
            ConnectionDefinations.closeConnection(con, stmt);
        }
        
    }
    
    public List<Curso> readAll(){
       
        Connection conn = ConnectionDefinations.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Curso> cursos = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("SELECT * FROM curso");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Curso curso = new Curso();
                
                curso.setCodigo(rs.getInt("codigo"));
                curso.setDescricao(rs.getString("descricao"));
                curso.setEmenta(rs.getString("ementa"));
                
                cursos.add(curso);
                
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao ler arquivos do banco "+ex);
        } finally{
            ConnectionDefinations.closeConnection(conn, stmt, rs);
        }       
        return cursos;   
    }
    
    public List<Curso> readCodigo(Curso curso){
       
        Connection conn = ConnectionDefinations.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Curso> cursos = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("SELECT * FROM curso WHERE codigo = ?");
            stmt.setInt(1, curso.getCodigo());
            rs = stmt.executeQuery();
               
            if(!rs.next()){
                JOptionPane.showMessageDialog(null, "Curso não Cadastrado");
                throw new IllegalArgumentException("Curso não Cadastrado");
            }else {            
                curso.setCodigo(rs.getInt("codigo"));
                curso.setDescricao(rs.getString("descricao"));
                curso.setEmenta(rs.getString("ementa"));
                
                cursos.add(curso);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao ler arquivos do banco "+ex);
        } finally{
            ConnectionDefinations.closeConnection(conn, stmt, rs);
        }       
        return cursos;   
    }
    public List<Curso> readDescricao(Curso curso){
       
        Connection conn = ConnectionDefinations.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Curso> cursos = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("SELECT * FROM curso WHERE descricao = ?");
            stmt.setString(1, curso.getDescricao());
            rs = stmt.executeQuery();
               
            if(!rs.next()){
                JOptionPane.showMessageDialog(null, "Curso não Cadastrado");
                throw new IllegalArgumentException("Curso não Cadastrado");
            }else {            
                curso.setCodigo(rs.getInt("codigo"));
                curso.setDescricao(rs.getString("descricao"));
                curso.setEmenta(rs.getString("ementa"));
                
                cursos.add(curso);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao ler arquivos do banco "+ex);
        } finally{
            ConnectionDefinations.closeConnection(conn, stmt, rs);
        }       
        return cursos;   
    }
    
}
