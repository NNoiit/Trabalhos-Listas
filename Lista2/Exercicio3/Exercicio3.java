package Exercicio3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Exercicio3 {
      
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int OpcaoU = Integer.MIN_VALUE;
        int entrada = Integer.MIN_VALUE;
        char continuar = 'Y';


        while(OpcaoU != 0) {

            System.out.println("1 - Para criar uma fila de pilhas");
		    System.out.println("2 - Para criar uma pilha de filas");
		    System.out.println("3 - Para criar uma fila de filas");
		    System.out.println("0 - Esc");
		    System.out.print("Digite uma das opções: ");
            OpcaoU = scan.nextInt();

            switch(OpcaoU) {
		        case 0:
                break;

		        case 1:

                    Stack<Integer> Fpilha1 = new Stack<>();
	                Stack<Integer> Fpilha2 = new Stack<>();
                    Queue<Stack<Integer>> filaPilha = new LinkedList<>();
        

                    while(continuar != 'N'){
                        System.out.println("Digite o inteiros desejá adicionar a priemeira pilha?");
                        entrada = scan.nextInt();
                        Fpilha1.push(entrada);
                        System.out.println("Digite o inteiros desejá adicionar a segunda pilha?");
                        entrada = scan.nextInt();
                        Fpilha2.push(entrada);
                        System.out.println("Antes de por em fila, desejá adicionar mais as pilhas? Y/N");
                        continuar = scan.next().charAt(0);
                    }

                    filaPilha.add(Fpilha1);
                    filaPilha.add(Fpilha2);

                    System.out.println("Fila de pilhas: " + filaPilha);
                    continuar = 'Y';
                break;

		        case 2:

                    Queue<Integer> Pfila1 = new LinkedList<>();
                    Queue<Integer> Pfila2 = new LinkedList<>();
                    Stack<Queue<Integer>> pilhaFila = new Stack<>(); 

                    while(continuar != 'N'){
                        System.out.println("Digite o inteiros desejá adicionar a priemeira Fila?");
                        entrada = scan.nextInt();
                        Pfila1.add(entrada);
                        System.out.println("Digite o inteiros desejá adicionar a segunda Fila?");
                        entrada = scan.nextInt();
                        Pfila2.add(entrada);
                        System.out.println("Antes de por na pilha, desejá adicionar mais as filas? Y/N");
                        continuar = scan.next().charAt(0);
                    }

                    pilhaFila.push(Pfila1);
                    pilhaFila.push(Pfila2);

                    System.out.println("Pilha de filas: " + pilhaFila);
                    continuar = 'Y';
                break;

                case 3:

                    Queue<Integer> Ffila1 = new LinkedList<>();
                    Queue<Integer> Ffila2 = new LinkedList<>();
                    Queue<Queue<Integer>> filaFila = new LinkedList<>(); 

                    while(continuar != 'N'){
                        System.out.println("Digite o inteiros desejá adicionar a priemeira Fila?");
                        entrada = scan.nextInt();
                        Ffila1.add(entrada);
                        System.out.println("Digite o inteiros desejá adicionar a segunda Fila?");
                        entrada = scan.nextInt();
                        Ffila2.add(entrada);
                        System.out.println("Antes de por na fila, desejá adicionar mais as filas? Y/N");
                        continuar = scan.next().charAt(0);
                    }

                    filaFila.add(Ffila1);
                    filaFila.add(Ffila2);

                    System.out.println("Fila de fila: " + filaFila);
                    continuar = 'Y';
                break;

                default: 
                    System.out.println("Opção Inválida");
            }		
        }
	scan.close();
    }   
}  