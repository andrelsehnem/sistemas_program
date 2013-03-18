package br.andre.turmas;

import java.util.ArrayList;

public class Turma {

    private int codigo;
    private String descricao;
    private ArrayList<Aluno> alunos = new ArrayList<Aluno>();

    public Turma(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
        
    }

    public int quantidadeAlunos() {
        return alunos.size();
    }

    public int quantidadeAprovados() {
        int total = 0;
        int cont;

        for (cont = 0; cont < alunos.size(); total++) {
            if (alunos.get(cont).media() >= 7) {
                total++;
            }
        }

        return total;
    }

    public int quantidadeReprovados() {
        return alunos.size() - quantidadeAprovados();

    }

    public float porcentagemAprovados() {
        return alunos.size() / 100 * quantidadeAprovados();
    }

    public float porcentagemReprovados() {
        return 100 - porcentagemAprovados();
    }

    public float mediaGeral() {
        float media = 0;
        if (alunos.size() > 0) {
            for (Aluno al : alunos) {
                media += al.media();
            }

            return media / alunos.size();
        }
        return 0;
    }
    
    public void matricula(Aluno aluno){
        alunos.add(aluno);
        aluno.setTurma(this);
    }
    
    public void cancelarMatricula(Aluno aluno){
        alunos.remove(aluno);
        aluno.setTurma(null);
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
}
