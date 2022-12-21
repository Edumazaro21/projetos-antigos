package br.com.cardboard.VO;

public enum TipoTransporte {
    
    AEREO(1, "Aéreo"),
    TERRESTRE(2, "Terrestre");
    
    private int id = 0;
    private String descricao = "";

    private TipoTransporte(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public static TipoTransporte get(int id){
        for(TipoTransporte tipo : TipoTransporte.values()){
            if(tipo.getId() == id){
                return tipo;
            }
        }
        
        return null;
    }
}
