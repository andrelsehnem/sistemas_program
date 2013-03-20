
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
    
    public int numeroTurmas(){
        return turmas.size();
    }

    public ArrayList<Turma> getTurmas() {
        return turmas;
    }

    public String getDescricao() {
        return descricao;
    }
    
    
    
    public void turmasCadastradas(){
        System.out.println("Turms cadastradas: ");
        int x = 0;
        for (Turma tur: turmas){
            System.out.println(tur.getCodigo() + " - " + tur.getDescricao());
        }
    }
}
