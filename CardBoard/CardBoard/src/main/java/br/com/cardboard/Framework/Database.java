package br.com.cardboard.Framework;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {

    private static Connection con = Conexao.getConexao();
    private static boolean isWeb = false;

    public static void setConexao(Connection i_con, boolean i_isWeb) throws Exception {
        con = i_con;
        isWeb = i_isWeb;
    }

    private static Statement getStatement() throws Exception {
        if (isWeb) {
            return con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } else {
            return Conexao.createStatement();
        }
    }

    public static boolean tabelaExiste(String i_tabela) throws Exception {
        Statement stm = null;
        ResultSet rst = null;
        StringBuilder sql = null;

        stm = getStatement();

        sql = new StringBuilder();
        sql.append("SELECT DISTINCT");
        sql.append("   pg_namespace.nspname AS esquema,");
        sql.append("   pg_class.relname AS tabela");
        sql.append(" FROM pg_index, pg_attribute ");
        sql.append(" JOIN pg_class ON (pg_attribute.attrelid = pg_class.oid AND pg_class.relkind = 'r')");
        sql.append(" JOIN pg_namespace ON (pg_namespace.oid = pg_class.relnamespace)");
        sql.append("WHERE pg_class.relkind = 'r'");

        if (i_tabela.contains(".")) {
            sql.append("AND pg_namespace.nspname || '.' ||   pg_class.relname = '" + i_tabela.trim() + "'");
        } else {
            sql.append("AND pg_namespace.nspname || '.' ||   pg_class.relname = 'public." + i_tabela.trim() + "'");
        }

        rst = stm.executeQuery(sql.toString());

        boolean achou = rst.next();

        stm.close();

        return achou;
    }

    public static boolean schemaExiste(String i_schema) throws Exception {
        Statement stm = null;
        ResultSet rst = null;

        stm = getStatement();

        rst = stm.executeQuery("SELECT * FROM pg_namespace WHERE nspname = '" + i_schema + "'");

        boolean achou = rst.next();

        stm.close();

        return achou;
    }

    public static boolean colunaExiste(String i_coluna, String i_tabela) throws Exception {
        Statement stm = null;
        ResultSet rst = null;
        StringBuilder sql = null;

        stm = getStatement();

        sql = new StringBuilder();
        sql.append("SELECT pg_attribute.attname as campo");
        sql.append(" FROM pg_index, pg_attribute");
        sql.append(" JOIN pg_class ON (pg_attribute.attrelid = pg_class.oid AND pg_class.relkind = 'r')");
        sql.append(" JOIN pg_namespace ON (pg_namespace.oid = pg_class.relnamespace)");
        sql.append(" WHERE pg_class.relkind = 'r' AND pg_attribute.attname = '" + i_coluna + "'");

        if (i_tabela.contains(".")) {
            sql.append(" AND pg_namespace.nspname || '.' ||   pg_class.relname = '" + i_tabela + "'");
        } else {
            sql.append(" AND pg_namespace.nspname || '.' ||   pg_class.relname = 'public." + i_tabela + "'");
        }

        sql.append(" LIMIT 1");

        rst = stm.executeQuery(sql.toString());

        boolean achou = rst.next();

        stm.close();

        return achou;
    }

    public static boolean idExiste(int i_id, String i_tabela) throws Exception {
        Statement stm = null;
        ResultSet rst = null;
        StringBuilder sql = null;

        stm = getStatement();

        sql = new StringBuilder();
        sql.append("SELECT * FROM " + i_tabela + " WHERE id = " + i_id);

        rst = stm.executeQuery(sql.toString());

        boolean achou = rst.next();

        stm.close();

        return achou;
    }

    public static boolean valorColunaExiste(String i_valor, String i_coluna, String i_tabela) throws Exception {
        return valorColunaExiste(i_valor, i_coluna, i_tabela, -1);
    }

    public static boolean valorColunaExiste(String i_valor, String i_coluna, String i_tabela, long i_id) throws Exception {
        Statement stm = null;
        ResultSet rst = null;
        StringBuilder sql = null;

        stm = getStatement();

        sql = new StringBuilder();
        sql.append("SELECT * FROM " + i_tabela + " WHERE " + i_coluna + " = '" + i_valor + "'");

        if (i_id != -1) {
            sql.append(" AND id = " + i_id);
        }

        rst = stm.executeQuery(sql.toString());

        boolean achou = rst.next();

        stm.close();

        return achou;
    }
}

