package br.com.cardboard.Main;

import br.com.cardboard.Framework.Banco;
import br.com.cardboard.Framework.Conexao;
import br.com.cardboard.Framework.Properties;
import br.com.cardboard.GUI.ConsultaRota;

public class Main {

    public static void main(String args[]) throws Exception {

        //conecta banco
        String ipBanco = Properties.getString("database.ip");
        String ipSecBanco = Properties.getString("database.ipsec");
        int portaBanco = Properties.getInt("database.porta");
        String nomeBanco = Properties.getString("database.nome");
        String usuarioBanco = Properties.getString("database.usuario", "postgres");
        String senhaBanco = Properties.getString("database.senha", "postgres");

        Conexao.abrirConexao(ipBanco, ipSecBanco, portaBanco, nomeBanco, usuarioBanco, senhaBanco);
        
        new Banco().criarTabela();
        
        ConsultaRota form = new ConsultaRota();
        form.setVisible(true);
    }
}
