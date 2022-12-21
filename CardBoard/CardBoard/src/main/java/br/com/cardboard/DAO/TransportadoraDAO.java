package br.com.cardboard.DAO;

import br.com.cardboard.VO.TransportadoraVO;
import br.com.cardboard.Framework.Conexao;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TransportadoraDAO {

    public List<TransportadoraVO> carregar(int idTransportadora) throws Exception {
        List<TransportadoraVO> vTransportadora = new ArrayList();

        Statement stm = null;
        ResultSet rst = null;

        try {
            stm = Conexao.createStatement();

            rst = stm.executeQuery("SELECT id_tipotransporte, tempomedio, valor FROM transportadora WHERE id_transportadora = " + idTransportadora);

            while (rst.next()) {
                TransportadoraVO oTransportadora = new TransportadoraVO();

                oTransportadora.setIdTransportadora(idTransportadora);
                oTransportadora.setIdTipoTransporte(rst.getInt("id_tipotransporte"));
                oTransportadora.setTempoMedio(rst.getInt("tempomedio"));
                oTransportadora.setValor(rst.getBigDecimal("valor"));

                vTransportadora.add(oTransportadora);
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            stm.close();

            return vTransportadora;
        }

    }

}
