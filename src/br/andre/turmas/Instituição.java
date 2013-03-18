
package br.andre.turmas;

import java.util.ArrayList;

public class Instituição {
    
    private ArrayList <Turma> turmas = new ArrayList<Turma>();
    private String descricao;
    
    public void novaTurma(Turma turma){
        turmas.add(turma);
    }
    
    public Instituição(String descricao){
        this.descricao = descricao;
                
    }
}
