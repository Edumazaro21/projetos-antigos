package br.com.cardboard.VO;

public enum Transportadora {
    TRANSPORTADORA1(1, "Transportadora 1"),
    TRANSPORTADORA2(2, "Transportadora 2"),
    TRANSPORTADORA3(3, "Transportadora 3"),
    TRANSPORTADORA4(4, "Transportadora 4");

    private int id = 0;
    private String descricao = "";

    private Transportadora(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Transportadora get(int id){
        for(Transportadora tipo : Transportadora.values()){
            if(tipo.getId() == id){
                return tipo;
            }
        }
        
        return null;
    }
    
}
