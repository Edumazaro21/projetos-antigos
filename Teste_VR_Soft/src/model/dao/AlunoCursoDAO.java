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
import model.bean.CursoAluno;

/**
 *
 * @author eduma
 */
public class AlunoCursoDAO {
    
    public void create(CursoAluno cursoaluno){
        
        Connection con = ConnectionDefinations.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO curso_aluno (codigo_aluno, nome_aluno, codigo_curso, "
                                       +"descricao_curso) VALUES(?, ?, ?, ?)");
            
            stmt.setInt(1, cursoaluno.getCodigo_aluno());
            stmt.setString(2, cursoaluno.getNome_aluno());
            stmt.setInt(3, cursoaluno.getCodigo_curso());
            stmt.setString(4, cursoaluno.getDescricao_curso());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Dados salvos com sucesso !");
                    
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
            }finally{
            ConnectionDefinations.closeConnection(con, stmt);
        }
        
    }
    public void update(CursoAluno cursoaluno){
        
        Connection con = ConnectionDefinations.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE curso_aluno SET codigo_aluno = ? , nome_aluno = ? , codigo_curso = ? , descricao_curso = ? WHERE codigo = ?");
            stmt.setInt(1, cursoaluno.getCodigo_aluno());
            stmt.setString(2, cursoaluno.getNome_aluno());
            stmt.setInt(3, cursoaluno.getCodigo_curso());
            stmt.setString(4, cursoaluno.getDescricao_curso());
            
            stmt.setInt(5, cursoaluno.getCodigo());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso !");
                    
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar: "+ex);
            }finally{
            ConnectionDefinations.closeConnection(con, stmt);
        }
        
    }
    
    public void delete(CursoAluno cursoaluno){
        
        Connection con = ConnectionDefinations.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM curso_aluno WHERE codigo = ?");
            stmt.setInt(1, cursoaluno.getCodigo());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Registro excluido com sucesso !");
                    
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao excluir: "+ex);
            }finally{
            ConnectionDefinations.closeConnection(con, stmt);
        }
        
    }
    
    public List<CursoAluno> readAll(){
        
        Connection con = ConnectionDefinations.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<CursoAluno> cursoalunos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM curso_aluno");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                CursoAluno cursoaluno = new CursoAluno();
                
                cursoaluno.setCodigo(rs.getInt("codigo"));
                cursoaluno.setCodigo_aluno(rs.getInt("codigo_aluno"));
                cursoaluno.setNome_aluno(rs.getString("nome_aluno"));
                cursoaluno.setCodigo_curso(rs.getInt("codigo_curso"));
                cursoaluno.setDescricao_curso(rs.getString("descricao_curso"));
                
                cursoalunos.add(cursoaluno);
                
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao ler arquivos do banco "+ex);
        } finally{
            ConnectionDefinations.closeConnection(con, stmt, rs);
        }       
        return cursoalunos;
    }
        
}
