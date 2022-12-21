package br.com.cardboard.VO;

import static br.com.cardboard.VO.Local.TipoLocal.DESTINO;
import static br.com.cardboard.VO.Local.TipoLocal.ORIGEM;
import java.util.ArrayList;
import java.util.List;

public enum Local {

    SAOPAULO(1, "São Paulo", ORIGEM),
    FLORIANOPOLIS(2, "Florianópolis", ORIGEM),
    SALVADOR(3, "Salvador", ORIGEM),
    MANAUS(4, "Manaus", DESTINO),
    CAMPINAS(5, "Campinas", DESTINO),
    BELEM(6, "Belém", DESTINO),
    ASSUNCAO(7, "Assunção", DESTINO),
    BRASILIA(8, "Brasilia", DESTINO);

    private int id = 0;
    private String descricao = "";
    private TipoLocal tipoLocal = null;

    private Local(int id, String descricao, TipoLocal tipoLocal) {
        this.id = id;
        this.descricao = descricao;
        this.tipoLocal = tipoLocal;
    }

    public static List<Local> getLocais(TipoLocal tipoLocal) {
        List<Local> vLocais = new ArrayList();

        for (Local local : values()) {
            if (local.getTipoLocal() == tipoLocal) {
                vLocais.add(local);
            }
        }

        return vLocais;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public TipoLocal getTipoLocal() {
        return tipoLocal;
    }

    public enum TipoLocal {

        ORIGEM(1),
        DESTINO(2);

        private int id = 0;

        private TipoLocal(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }

}
