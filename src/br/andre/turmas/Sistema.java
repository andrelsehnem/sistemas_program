/*
Desenvolver um aplicativo para gerenciar alunos e turmas

Aluno (RA, nome, turma, controlar notas[g1 e g2]
Turma (codigo, descrição, suportar vários aluno - quantidade de aprovados e reprovados, percentual de aprovação e
 reprovação, media geral, cadastrar alunos e turmas, quantidade de alunos)
 Sistema (cadastrar alunos e turmas)
*/
package br.andre.turmas;

import java.util.Scanner;

public class Sistema {
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        int x=0;
        Instituição instituicao;
        sistema:while (x==0){
            System.out.println("1-Gerenciar alunos; 2-Gerenciar turmas; 3-Nova instituição; 4-Informalções; 0-Fim;");
            int y = sc.nextInt();
            prim:if (y == 1){
                System.out.println("1-Matricular Aluno; 2-Cancelar matricula; 3-Voltar");
            }else if(y==2){
                System.out.println("1-Nova Turma; 2-Remover turma; 3-Voltar");
            }else if(y==3){
                System.out.println("Digite o nome da instituição: ");
                String descr = sc.nextLine();
                instituicao = new Instituição(descr);
            }else if(y==4){
                System.out.println("1-Aluno; 2-Turma");
                y = sc.nextInt();
                if(y==1){
                    
                }else if(y==2){
                    
                }
            }else if(y==0){
                break sistema;
            }
        }
    }
    
}
