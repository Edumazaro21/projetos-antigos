package br.com.cardboard;

import br.com.cardboard.framework.Conexao;
import br.com.cardboard.framework.Properties;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CardBoardApplication {

    private static Connection con;

    public static void main(String[] args) {
        try {
            //conecta banco
            String ipBanco = Properties.getString("database.ip");
            String ipSecBanco = Properties.getString("database.ipsec");
            int portaBanco = Properties.getInt("database.porta");
            String nomeBanco = Properties.getString("database.nome");
            String usuarioBanco = Properties.getString("database.usuario", "postgres");
            String senhaBanco = Properties.getString("database.senha", "postgres");
            
            Conexao.abrirConexao(ipBanco, ipSecBanco, portaBanco, nomeBanco, usuarioBanco, senhaBanco);
            
            SpringApplication.run(CardBoardApplication.class, args);
        } catch (Exception ex) {
            Logger.getLogger(CardBoardApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
