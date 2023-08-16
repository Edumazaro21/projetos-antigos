/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionDefinations;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author eduma
 */
public class LoginDAO {
    public void verificaDBExiste(){
        
        Connection con = ConnectionDefinations.testaDB();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("CREATE SCHEMA IF NOT EXISTS `dbcurso_aluno` ;");
            
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("CREATE TABLE IF NOT EXISTS `dbcurso_aluno`.`aluno` (\n" +
                                        "  `codigo` INT NOT NULL AUTO_INCREMENT,\n" +
                                        "  `nome` VARCHAR(50) NULL,\n" +
                                        "  PRIMARY KEY (`codigo`));");
            
            stmt.executeUpdate();       
            
            stmt = con.prepareStatement("CREATE TABLE IF NOT EXISTS `dbcurso_aluno`.`curso` (\n" +
                                        "  `codigo` INT NOT NULL AUTO_INCREMENT,\n" +
                                        "  `descricao` VARCHAR(50) NULL,\n" +
                                        "  `ementa` TEXT(500) NULL,\n" +
                                        "  PRIMARY KEY (`codigo`));");
            
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("CREATE TABLE IF NOT EXISTS `dbcurso_aluno`.`curso_aluno` (\n" +
                                        "  `codigo` INT NOT NULL AUTO_INCREMENT,\n" +
                                        "  `codigo_aluno` INT NULL,\n" +
                                        "  `nome_aluno` VARCHAR(50) NULL,\n" +
                                        "  `codigo_curso` INT NULL,\n" +
                                        "  `descricao_curso` VARCHAR(50) NULL,\n" +
                                        "  `ementa` TEXT NULL,\n" +
                                        "  PRIMARY KEY (`codigo`),\n" +
                                        "  INDEX `fk_codigo_aluno_idx` (`codigo_aluno` ASC) VISIBLE,\n" +
                                        "  INDEX `fk_codigo_curso_idx` (`codigo_curso` ASC) VISIBLE,\n" +
                                        "  CONSTRAINT `fk_codigo_aluno`\n" +
                                        "    FOREIGN KEY (`codigo_aluno`)\n" +
                                        "    REFERENCES `dbcurso_aluno`.`aluno` (`codigo`)\n" +
                                        "    ON DELETE NO ACTION\n" +
                                        "    ON UPDATE NO ACTION,\n" +
                                        "  CONSTRAINT `fk_codigo_curso`\n" +
                                        "    FOREIGN KEY (`codigo_curso`)\n" +
                                        "    REFERENCES `dbcurso_aluno`.`curso` (`codigo`)\n" +
                                        "    ON DELETE NO ACTION\n" +
                                        "    ON UPDATE NO ACTION);");
            
            stmt.executeUpdate();  
                                                           
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao criar DB: "+ex);
            }finally{
            ConnectionDefinations.closeConnection(con, stmt);
        }
        
    }    

}
