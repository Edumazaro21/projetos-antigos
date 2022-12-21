package br.com.cardboard.Framework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Conexao {

    private static List<String> vLogMetodo = new ArrayList();
    private static int contBegin = 0;
    private static Connection con;
    private static String ip = "";
    private static String ipSec = "";
    private static int porta = 0;
    private static String dataBase = "";
    private static String usuario = "";
    private static String senha = "";

    public static void abrirConexao(String i_ip, int i_porta, String i_database, String i_usuario, String i_senha) throws Exception {
        abrirConexao(i_ip, "", i_porta, i_database, i_usuario, i_senha);
    }

    public static void abrirConexao(String i_ip, String i_ipSec, int i_porta, String i_database, String i_usuario, String i_senha) throws Exception {
        Class.forName("org.postgresql.Driver");

        ip = i_ip;
        ipSec = i_ipSec;
        porta = i_porta;
        dataBase = i_database;
        usuario = i_usuario;
        senha = i_senha;

        try {
            con = DriverManager.getConnection("jdbc:postgresql://" + i_ip + ":" + i_porta + "/" + i_database, i_usuario, i_senha);

        } catch (Exception ex) {
            if (!ipSec.isEmpty()) {
                con = DriverManager.getConnection("jdbc:postgresql://" + i_ipSec + ":" + i_porta + "/" + i_database, i_usuario, i_senha);
            } else {
                throw ex;
            }
        }
    }

    public static Connection getConexao() {
        return con;
    }

    public static void setApplicationName(String i_applicationName) throws Exception {
        Statement stm = createStatement();
        stm.execute("SET application_name TO '" + i_applicationName + "'");
        stm.close();
    }

    public static Statement createStatement() throws Exception {
        if (contBegin == 0) {
            testarConexao();
        }

        return con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }

    public static void begin() throws Exception {
        if (con == null) {
            testarConexao();
        }

        if (contBegin == 0) {
            con.createStatement().execute("begin");
        }

        contBegin++;
    }

    public static void commit() throws Exception {
        contBegin--;

        if (contBegin == 0) {
            con.createStatement().execute("commit");
        }
    }

    public static void rollback() throws Exception {
        contBegin--;

        if (contBegin <= 0) {
            contBegin = 0;

            if (con != null) {
                con.createStatement().execute("rollback");
            }
        }
    }

    public static void close() throws Exception {
        try {
            con.close();
            con = null;

        } catch (Exception ex) {
        }
    }

    private static void testarConexao() throws Exception {
        Statement stm = null;

        try {
            stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stm.setQueryTimeout(10);

            stm.execute("SELECT 1");
            stm.close();

        } catch (Exception ex) {
            close();
            abrirConexao(ip, ipSec, porta, dataBase, usuario, senha);
        }
    }

    public static PreparedStatement prepareStatement(String i_sql) throws Exception {
        return con.prepareStatement(i_sql);
    }

    public static void destruir(Connection i_con, Statement i_stm, ResultSet i_rst) throws Exception {
        if (i_rst != null) {
            i_rst.close();
        }

        if (i_stm != null) {
            i_stm.close();
        }

        if (i_con != null) {
            i_con.close();
        }
    }

    public static void closeConnection(Statement i_stm) {
        closeConnection(null, i_stm, null);
    }

    public static void closeConnection(ResultSet i_rst, Statement i_stm) {
        closeConnection(i_rst, i_stm, null);
    }

    public static void closeConnection(Statement i_stm, Connection i_con) {
        closeConnection(null, i_stm, i_con);
    }

    public static void closeConnection(ResultSet i_rst, Statement i_stm, Connection i_con) {
        try {
            if (i_rst != null) {
                i_rst.close();
            }

            if (i_stm != null) {
                i_stm.close();
            }

            if (i_con != null) {
                i_con.close();
            }
        } catch (SQLException ex) {
        }
    }

}

