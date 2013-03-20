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
        Instituição instituicao = new Instituição("Colegio");
        
        //variaveis auxiliares
        float nota;
        String nome;
        int cod;
        Aluno aluno = null;
        
        sistema:while (x==0){
            sc = new Scanner(System.in);
            System.out.println("1-Gerenciar alunos; 2-Gerenciar turmas; 3-Informalções; 0-Fim;");
            int y = sc.nextInt();
            
            if (y == 1){ //gerenciar aluno
                System.out.println("1-Matricular Aluno; 2-Cancelar matricula; 3-Alterar nota; 5-Voltar");
                y = sc.nextInt();
                if (y==1){//matricular aluno
                    System.out.println("Para prosseguir com a matricula do aluno você deve ter ao menos 1(uma) turma cadastrada");
                    System.out.println("Voce tem " + instituicao.numeroTurmas() + " turmas cadastradas");
                    if (instituicao.numeroTurmas() > 0 ){
                        System.out.println("Digite o nome do aluno: ");
                        nome = sc.nextLine();
                        System.out.println("Digite o RA do aluno: ");
                        cod = sc.nextInt();
                        aluno = new Aluno(cod, nome);
                        System.out.println("Nota da G1: ");
                        nota = sc.nextInt();
                        aluno.setG1(nota);
                        System.out.println("Nota da G2: ");
                        nota = sc.nextInt();
                        aluno.setG2(nota);
                        instituicao.turmasCadastradas();
                        System.out.println("Em qual turma voce deseja cadastrar o aluno? ( digite o cod) ");
                        cod = sc.nextInt();
                        for(Turma tur: instituicao.getTurmas()){
                            if (tur.getCodigo() == cod){
                                tur.matricula(aluno);
                            }
                        }
                    }
                }else if (y==2){ //cancelar matricula
                    instituicao.turmasCadastradas();
                    System.out.println("Em qual turma voce deseja procurar o aluno? ( digite o cod) ");
                    cod = sc.nextInt();
                    for(Turma tur: instituicao.getTurmas()){
                        if (tur.getCodigo() == cod){
                            tur.alunosMatriculados();
                            System.out.println("Qual aluno deseja cancelar matricula? ( digite o cod) ");
                            cod = sc.nextInt();
                            for(Aluno alu: tur.getAlunos()){
                                if (alu.getRa() == cod){
                                    tur.cancelarMatricula(alu);
                                }
                            }
                        }
                    }
                }//termina de cancelar matricula
                else if(y==3){//alterar nota 
                    instituicao.turmasCadastradas();
                    System.out.println("Em qual turma voce deseja procurar o aluno? ( digite o cod) ");
                    cod = sc.nextInt();
                    for(Turma tur: instituicao.getTurmas()){
                        if (tur.getCodigo() == cod){
                            tur.alunosMatriculados();
                            System.out.println("Qual aluno deseja mudar a nota ( digite o cod) ");
                            cod = sc.nextInt();
                            for(Aluno alu: tur.getAlunos()){
                                if (alu.getRa() == cod){
                                    System.out.println("Qual nota deseja alterar (G1 = 1; G2 = 2");
                                    cod = sc.nextInt();
                                    if(cod == 1){
                                        System.out.println("Digite a nota");
                                        nota = sc.nextFloat();
                                        alu.setG1(nota);
                                    }
                                    if(cod == 2){
                                        System.out.println("Digite a nota");
                                        nota = sc.nextFloat();
                                        alu.setG2(nota);
                                    }
                                }
                            }
                        }
                    }
                }//fim do alteração da nota
             }//fim do gerenciamento de aluno
         }//fim do sistema
    }
}
