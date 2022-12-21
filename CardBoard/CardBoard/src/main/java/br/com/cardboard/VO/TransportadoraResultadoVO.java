package br.com.cardboard.VO;

import java.math.BigDecimal;

public class TransportadoraResultadoVO {

    private int distancia = 0;
    private int tempoTotal = 0;
    private BigDecimal valorTotal;
    private int idTipoTransporte = 0;
    private int idTransportadora = 0;

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public int getTempoTotal() {
        return tempoTotal;
    }

    public void setTempoTotal(int tempoTotal) {
        this.tempoTotal = tempoTotal;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getIdTipoTransporte() {
        return idTipoTransporte;
    }

    public void setIdTipoTransporte(int idTipoTransporte) {
        this.idTipoTransporte = idTipoTransporte;
    }

    public int getIdTransportadora() {
        return idTransportadora;
    }

    public void setIdTransportadora(int idTransportadora) {
        this.idTransportadora = idTransportadora;
    }
}
