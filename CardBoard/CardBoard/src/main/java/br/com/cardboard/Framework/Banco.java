package br.com.cardboard.Framework;

import br.com.cardboard.VO.TipoTransporte;
import br.com.cardboard.VO.Transportadora;
import java.sql.Statement;

public class Banco {

    public void criarTabela() throws Exception {
        Statement stm = null;
        StringBuilder sql = null;

        try {
            Conexao.begin();

            stm = Conexao.createStatement();

            if (!Database.tabelaExiste("tipotransporte")) {
                sql = new StringBuilder();
                sql.append("CREATE TABLE tipotransporte (");
                sql.append(" id INTEGER NOT NULL,");
                sql.append(" descricao CHARACTER VARYING(30),");
                sql.append(" CONSTRAINT pk_tipotransporte PRIMARY KEY (id)");
                sql.append(");");

                stm.execute(sql.toString());

                sql = new StringBuilder();
                sql.append("INSERT INTO tipotransporte (id, descricao) VALUES (");
                sql.append(TipoTransporte.AEREO.getId() + ", '");
                sql.append(TipoTransporte.AEREO.getDescricao() + "');");

                stm.execute(sql.toString());

                sql = new StringBuilder();
                sql.append("INSERT INTO tipotransporte (id, descricao) VALUES (");
                sql.append(TipoTransporte.TERRESTRE.getId() + ", '");
                sql.append(TipoTransporte.TERRESTRE.getDescricao() + "');");

                stm.execute(sql.toString());
            }

            if (!Database.tabelaExiste("transportadora")) {
                sql = new StringBuilder();
                sql.append("CREATE TABLE transportadora (");
                sql.append(" id SERIAL NOT NULL,");
                sql.append(" id_transportadora INTEGER NOT NULL,");
                sql.append(" descricao CHARACTER VARYING(30),");
                sql.append(" id_tipotransporte INTEGER NOT NULL,");
                sql.append(" tempomedio INTEGER NOT NULL,");
                sql.append(" valor NUMERIC (11,2) NOT NULL,");
                sql.append(" CONSTRAINT pk_transportadora PRIMARY KEY (id),");
                sql.append(" CONSTRAINT fk_tipotransporte FOREIGN KEY (id_tipotransporte) REFERENCES tipotransporte (id)");
                sql.append(");");

                stm.execute(sql.toString());

                sql = new StringBuilder();
                sql.append("INSERT INTO transportadora (id_transportadora, descricao, id_tipotransporte, tempomedio, valor) VALUES (");
                sql.append(Transportadora.TRANSPORTADORA1.getId() + ", '");
                sql.append(Transportadora.TRANSPORTADORA1.getDescricao() + "', ");
                sql.append(TipoTransporte.TERRESTRE.getId() + ", ");
                sql.append("60, ");
                sql.append("50.00);");

                stm.execute(sql.toString());

                sql = new StringBuilder();
                sql.append("INSERT INTO transportadora (id_transportadora, descricao, id_tipotransporte, tempomedio, valor) VALUES (");
                sql.append(Transportadora.TRANSPORTADORA2.getId() + ", '");
                sql.append(Transportadora.TRANSPORTADORA2.getDescricao() + "', ");
                sql.append(TipoTransporte.TERRESTRE.getId() + ", ");
                sql.append("59, ");
                sql.append("75.00);");

                stm.execute(sql.toString());

                sql = new StringBuilder();
                sql.append("INSERT INTO transportadora (id_transportadora, descricao, id_tipotransporte, tempomedio, valor) VALUES (");
                sql.append(Transportadora.TRANSPORTADORA2.getId() + ", '");
                sql.append(Transportadora.TRANSPORTADORA2.getDescricao() + "', ");
                sql.append(TipoTransporte.AEREO.getId() + ", ");
                sql.append("30, ");
                sql.append("200.00);");

                stm.execute(sql.toString());

                sql = new StringBuilder();
                sql.append("INSERT INTO transportadora (id_transportadora, descricao, id_tipotransporte, tempomedio, valor) VALUES (");
                sql.append(Transportadora.TRANSPORTADORA3.getId() + ", '");
                sql.append(Transportadora.TRANSPORTADORA3.getDescricao() + "', ");
                sql.append(TipoTransporte.TERRESTRE.getId() + ", ");
                sql.append("65, ");
                sql.append("55.00);");

                stm.execute(sql.toString());

                sql = new StringBuilder();
                sql.append("INSERT INTO transportadora (id_transportadora, descricao, id_tipotransporte, tempomedio, valor) VALUES (");
                sql.append(Transportadora.TRANSPORTADORA3.getId() + ", '");
                sql.append(Transportadora.TRANSPORTADORA3.getDescricao() + "', ");
                sql.append(TipoTransporte.AEREO.getId() + ", ");
                sql.append("33, ");
                sql.append("180.00);");

                stm.execute(sql.toString());

                sql = new StringBuilder();
                sql.append("INSERT INTO transportadora (id_transportadora, descricao, id_tipotransporte, tempomedio, valor) VALUES (");
                sql.append(Transportadora.TRANSPORTADORA4.getId() + ", '");
                sql.append(Transportadora.TRANSPORTADORA4.getDescricao() + "', ");
                sql.append(TipoTransporte.AEREO.getId() + ", ");
                sql.append("30, ");
                sql.append("175.00);");

                stm.execute(sql.toString());

            }

            Conexao.commit();
        } catch (Exception ex) {
            Conexao.rollback();

            throw ex;
        } finally {
            stm.close();
        }
    }

}
