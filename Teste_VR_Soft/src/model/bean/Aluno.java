package model.bean;

public class Aluno {
    private int codigo;
    private String nome;

    public Aluno() {
    }

    public Aluno(String nome) {
        this.nome = nome;
    }
    
     
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
