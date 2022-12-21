package br.com.cardboard.VO;

import java.math.BigDecimal;

public class TransportadoraVO {
    private int idTransportadora = 0;
    private int idTipoTransporte = 0;
    private BigDecimal valor;
    private int tempoMedio = 0;
    private String descricaoTransportadora = "";

    public int getIdTransportadora() {
        return idTransportadora;
    }

    public void setIdTransportadora(int idTransportadora) {
        this.idTransportadora = idTransportadora;
    }

    public int getIdTipoTransporte() {
        return idTipoTransporte;
    }

    public void setIdTipoTransporte(int idTipoTransporte) {
        this.idTipoTransporte = idTipoTransporte;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public int getTempoMedio() {
        return tempoMedio;
    }

    public void setTempoMedio(int tempoMedio) {
        this.tempoMedio = tempoMedio;
    }

    public String getDescricaoTransportadora() {
        return descricaoTransportadora;
    }

    public void setDescricaoTransportadora(String descricaoTransportadora) {
        this.descricaoTransportadora = descricaoTransportadora;
    }
}
