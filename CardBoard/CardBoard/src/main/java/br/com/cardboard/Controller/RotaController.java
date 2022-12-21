package br.com.cardboard.Controller;

import br.com.cardboard.DAO.TransportadoraDAO;
import br.com.cardboard.VO.TipoTransporte;
import br.com.cardboard.VO.Transportadora;
import br.com.cardboard.VO.TransportadoraResultadoVO;
import br.com.cardboard.VO.TransportadoraVO;
import br.com.cardboard.Framework.ConexaoWS;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONObject;

public class RotaController {

    public List<TransportadoraResultadoVO> calcularRota(int idOrigem, int idDestino, int idTipoTransporte, int preferencia, int distancia) throws Exception {
        List<TransportadoraResultadoVO> vTransportadoraOrdenado = new ArrayList();
        List<TransportadoraResultadoVO> vTransportadoraOrdenadoAux = new ArrayList();

        if (preferencia == 1) {
            List<TransportadoraVO> vTransportadora = carregarTransportadoras();

            vTransportadoraOrdenado = calcularValor(vTransportadora, distancia, idTipoTransporte);

            Collections.sort(vTransportadoraOrdenado, new OrdenaMenorTempo());
            
            if(vTransportadoraOrdenado.get(0).getTempoTotal() == vTransportadoraOrdenado.get(1).getTempoTotal()){
                vTransportadoraOrdenadoAux.add(vTransportadoraOrdenado.get(0));
                vTransportadoraOrdenadoAux.add(vTransportadoraOrdenado.get(1));
                
                Collections.sort(vTransportadoraOrdenadoAux, new OrdenaMenorValor());
                
                for(int i = 2; i < vTransportadoraOrdenado.size(); i++) {
                    vTransportadoraOrdenadoAux.add(vTransportadoraOrdenado.get(i));
                }
                
                vTransportadoraOrdenado = vTransportadoraOrdenadoAux;
            }
            
        } else{
            List<TransportadoraVO> vTransportadora = carregarTransportadoras();

            vTransportadoraOrdenado = calcularValor(vTransportadora, distancia, idTipoTransporte);

            Collections.sort(vTransportadoraOrdenado, new OrdenaMenorValor());
            
            if(vTransportadoraOrdenado.get(0).getValorTotal().floatValue() == vTransportadoraOrdenado.get(1).getValorTotal().floatValue()){
                vTransportadoraOrdenadoAux.add(vTransportadoraOrdenado.get(0));
                vTransportadoraOrdenadoAux.add(vTransportadoraOrdenado.get(1));
                
                Collections.sort(vTransportadoraOrdenadoAux, new OrdenaMenorTempo());
                
                for(int i = 2; i < vTransportadoraOrdenado.size(); i++) {
                    vTransportadoraOrdenadoAux.add(vTransportadoraOrdenado.get(i));
                }
                
                vTransportadoraOrdenado = vTransportadoraOrdenadoAux;
            }
        }

        return vTransportadoraOrdenado;
    }

    public List<TransportadoraVO> carregarTransportadoras() throws Exception {
        List<TransportadoraVO> vTransportadora = new ArrayList();

        vTransportadora = new TransportadoraDAO().carregar(Transportadora.TRANSPORTADORA1.getId());
        vTransportadora.add(carregarTransportadorasWS(Transportadora.TRANSPORTADORA2.getId(), TipoTransporte.AEREO.getId()));
        vTransportadora.add(carregarTransportadorasWS(Transportadora.TRANSPORTADORA2.getId(), TipoTransporte.TERRESTRE.getId()));
        vTransportadora.add(carregarTransportadorasWS(Transportadora.TRANSPORTADORA3.getId(), TipoTransporte.AEREO.getId()));
        vTransportadora.add(carregarTransportadorasWS(Transportadora.TRANSPORTADORA3.getId(), TipoTransporte.TERRESTRE.getId()));
        vTransportadora.add(carregarTransportadorasWS(Transportadora.TRANSPORTADORA4.getId(), TipoTransporte.AEREO.getId()));

        return vTransportadora;
    }

    private TransportadoraVO carregarTransportadorasWS(int idTransportadora, int idTipoTransporte) throws Exception {
        TransportadoraVO oTransportadora = new TransportadoraVO();

        String retorno = ConexaoWS.get("consultartransportadora" + idTransportadora + "/" + idTipoTransporte);

        JSONObject retornoJson = new JSONObject(retorno);

        oTransportadora.setIdTransportadora(idTransportadora);
        oTransportadora.setIdTipoTransporte(idTipoTransporte);
        oTransportadora.setTempoMedio(Integer.parseInt(retornoJson.get("tempo").toString()));
        oTransportadora.setValor(BigDecimal.valueOf(Double.parseDouble(retornoJson.get("valor").toString())));

        return oTransportadora;
    }

    private List<TransportadoraResultadoVO> calcularValor(List<TransportadoraVO> vTransportadora, int distancia, int idTipoTransporte) {
        List<TransportadoraResultadoVO> vTransportadoras = new ArrayList();

        float menorValor = 0;
        float menorTempo = 0;

        for (TransportadoraVO transportadora : vTransportadora) {
            if (idTipoTransporte == 0) {
                TransportadoraResultadoVO oTransportadoraResult = new TransportadoraResultadoVO();

                menorTempo = transportadora.getTempoMedio();
                menorValor = (distancia * Float.parseFloat(transportadora.getValor().toString())) / 10;

                oTransportadoraResult.setIdTipoTransporte(transportadora.getIdTipoTransporte());
                oTransportadoraResult.setIdTransportadora(transportadora.getIdTransportadora());
                oTransportadoraResult.setDistancia(distancia);
                oTransportadoraResult.setTempoTotal(Math.round((menorTempo / 60) * distancia));
                oTransportadoraResult.setValorTotal(BigDecimal.valueOf(Double.parseDouble(String.valueOf(menorValor))));

                vTransportadoras.add(oTransportadoraResult);
            } else if (idTipoTransporte == transportadora.getIdTipoTransporte()) {
                TransportadoraResultadoVO oTransportadoraResult = new TransportadoraResultadoVO();

                menorTempo = transportadora.getTempoMedio();
                menorValor = (distancia * Float.parseFloat(transportadora.getValor().toString())) / 10;

                oTransportadoraResult.setIdTipoTransporte(transportadora.getIdTipoTransporte());
                oTransportadoraResult.setIdTransportadora(transportadora.getIdTransportadora());
                oTransportadoraResult.setDistancia(distancia);
                oTransportadoraResult.setTempoTotal(Math.round((menorTempo / 60) * distancia));
                oTransportadoraResult.setValorTotal(BigDecimal.valueOf(Double.parseDouble(String.valueOf(menorValor))));

                vTransportadoras.add(oTransportadoraResult);
            }
        }

        return vTransportadoras;
    }

    class OrdenaMenorTempo implements Comparator<TransportadoraResultadoVO> {

        @Override
        public int compare(TransportadoraResultadoVO o1, TransportadoraResultadoVO o2) {
            try {
                int value = o1.getTempoTotal() - o2.getTempoTotal();
                if (value < 0) {
                    return -1;
                } else if (value > 0) {
                    return 1;
                } else {
                    return 0;
                }
            } catch (Exception ex) {
                return 0;
            }
        }
    }

    class OrdenaMenorValor implements Comparator<TransportadoraResultadoVO> {

        @Override
        public int compare(TransportadoraResultadoVO o1, TransportadoraResultadoVO o2) {
            try {
                return Float.compare(o1.getValorTotal().floatValue(), o2.getValorTotal().floatValue());
            } catch (Exception ex) {
                return 0;
            }
        }
    }
}
