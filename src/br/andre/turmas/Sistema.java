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
    public static void main(String[] args) throws InterruptedException{
        
        Scanner sc = new Scanner (System.in);
        int x=0;
        Instituição instituicao = new Instituição("Colegio");
        int codTurma = 0;
        int codAluno = 0;
        
        
        //variaveis auxiliares
        float nota;
        String nome;
        int cod;
        Aluno aluno = null;
        Turma turma = null;
       
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
                        sc = new Scanner(System.in);
                        System.out.println("Digite o nome do aluno: ");
                        nome = sc.nextLine();
                        System.out.println("RA do aluno = " + codAluno);                                
                        aluno = new Aluno(codAluno, nome);
                        codAluno++;
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
                        System.out.println("Aluno cadastrado.");
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
            
            else if (y==2){//gerenciar turmas
                
                sc = new Scanner(System.in);
                System.out.println("1- Nova turma; 2-Remover turma; 0-Sair");
                cod = sc.nextInt();
                if (cod == 1){//nova tuSrma
                    sc = new Scanner(System.in);
                    System.out.println("Digite o nome da turma: ");
                    nome = sc.nextLine();
                    System.out.println("Codigo turma = " + codTurma);
                    turma = new Turma(codTurma, nome);
                    codTurma++;
                    instituicao.novaTurma(turma);
                    System.out.println("Turma cadastrada.");           
                }//acaba inserção de nova turma
                else if(cod == 2){//remover turma
                    sc = new Scanner(System.in);
                    instituicao.turmasCadastradas();
                    System.out.println("Qual turma deseja remover? ( digite o cod) ");
                    cod = sc.nextInt();
                    for(Turma tur: instituicao.getTurmas()){
                        if (tur.getCodigo() == cod){
                            turma = tur;
                        }
                    }
                    instituicao.removeTurma(turma);
                    System.out.println("Turma removida");
                }//termina de remover turma
            }
            
            else if (y==3){//informações gerais
                sc = new Scanner(System.in);
                System.out.println("1-Informações de aluno; 2-Informações de turmas; 0- Voltar");
                y = sc.nextInt();
                if (y==1){ //info aluno
                    instituicao.turmasCadastradas();
                    System.out.println("Em qual turma voce deseja procurar o aluno? ( digite o cod) ");
                    cod = sc.nextInt();
                    busca:for(Turma tur: instituicao.getTurmas()){
                        if (tur.getCodigo() == cod){
                            tur.alunosMatriculados();
                            System.out.println("Qual aluno? ( digite o cod) ");
                            cod = sc.nextInt();
                            for(Aluno alu: tur.getAlunos()){
                                if (alu.getRa() == cod){
                                    System.out.println("1-Media; 2-Nota G1; 3-Nota G2; 4-Info Gerais; 0- Voltar");
                                    cod = sc.nextInt();
                                    if (cod == 1){
                                        System.out.println("Media = " + alu.media());
                                        break busca;
                                    }
                                    else if (cod == 2){
                                        System.out.println("Nota G1 = " + alu.media());
                                        break busca;
                                    }
                                    else if (cod == 3){
                                        System.out.println("Nota G2 = " + alu.media());
                                        break busca;
                                    }
                                    else if (cod == 4){
                                        System.out.println("Nome = " + alu.getNome());
                                        System.out.println("RA = " + alu.getRa());
                                        System.out.println("Turma = " + alu.getTurma());
                                        break busca;
                                    }
                                }
                            }
                        }
                    }
                }// fim info aluno
                else if(y==2){ //info turma
                    /*
                     * quantidade alunos
                     * quantidade aprovados + %
                     * quantidade reprovados + %
                     * media geral
                     * 
                     * info gerais (nome + cod)
                     * 
                     * alunos matriculados
                     * 
                     */
                }// fim info turma
                
            }
            
            else if (y==0){//encerrar sistema
                break sistema;
            }
         }//fim do sistema
    }
}