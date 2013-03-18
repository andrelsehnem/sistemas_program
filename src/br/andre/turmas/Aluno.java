
package br.andre.turmas;

import java.io.Serializable;

public class Aluno implements Serializable{
    private int ra;
    private String nome;
    private float g1, g2;
    private Turma turma;
    
    
    public Aluno(int ra, String nome){
        this.ra = ra;
        this.nome = nome;
    }
    
    public float media(){
        return (g1+(g2*2))/3;
    }

    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getG1() {
        return g1;
    }

    public void setG1(float g1) {
        this.g1 = g1;
    }

    public float getG2() {
        return g2;
    }

    public void setG2(float g2) {
        this.g2 = g2;
    }    

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.ra;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aluno other = (Aluno) obj;
        if (this.ra != other.ra) {
            return false;
        }
        return true;
    }
    
} 
