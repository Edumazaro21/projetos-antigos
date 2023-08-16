package model.bean;

public class CursoAluno {
    private int codigo;
    private int codigo_aluno;
    private String nome_aluno;
    private int codigo_curso;
    private String descricao_curso;
    
    public CursoAluno() {
    }

    public CursoAluno(int codigo_aluno, String nome_aluno, int codigo_curso, String descricao_curso) {
        this.codigo_aluno = codigo_aluno;
        this.nome_aluno = nome_aluno;
        this.codigo_curso = codigo_curso;
        this.descricao_curso = descricao_curso;
    }
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo_aluno() {
        return codigo_aluno;
    }

    public void setCodigo_aluno(int codigo_aluno) {
        this.codigo_aluno = codigo_aluno;
    }

    public String getNome_aluno() {
        return nome_aluno;
    }

    public void setNome_aluno(String nome_aluno) {
        this.nome_aluno = nome_aluno;
    }

    public int getCodigo_curso() {
        return codigo_curso;
    }

    public void setCodigo_curso(int codigo_curso) {
        this.codigo_curso = codigo_curso;
    }

    public String getDescricao_curso() {
        return descricao_curso;
    }

    public void setDescricao_curso(String descricao_curso) {
        this.descricao_curso = descricao_curso;
    }

    
    
}
