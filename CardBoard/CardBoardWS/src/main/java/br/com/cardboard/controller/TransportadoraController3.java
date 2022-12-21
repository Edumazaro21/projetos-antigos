package br.com.cardboard.controller;

import br.com.cardboard.framework.Conexao;
import java.sql.ResultSet;
import java.sql.Statement;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultartransportadora3")
public class TransportadoraController3 {

    @GetMapping("/{id}")
    public String detalhar(@PathVariable Long id) throws Exception {

        return getTransportadora(id);
    }

    private String getTransportadora(Long id) throws Exception {
        Statement stm = null;
        ResultSet rst = null;

        JSONObject oJson = new JSONObject();

        try {
            stm = Conexao.createStatement();

            rst = stm.executeQuery("SELECT tempomedio, valor FROM transportadora WHERE id_transportadora = 3 AND id_tipotransporte = " + id);

            if (rst.next()) {
                oJson.put("tempo", rst.getInt("tempomedio"));
                oJson.put("valor", rst.getBigDecimal("valor"));
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            stm.close();
        }

        if (id > 2 || id < 1) {
            return "Tipo de transporte inválido";
        } else {
            return oJson.toJSONString();
        }
    }
}
