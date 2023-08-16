package model.bean;

public class Curso {
    private int codigo;
    private String descricao;
    private String ementa;

    public Curso() {
    }

    public Curso(String descricao, String ementa) {
        this.descricao = descricao;
        this.ementa = ementa;
    }

    
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    
}
