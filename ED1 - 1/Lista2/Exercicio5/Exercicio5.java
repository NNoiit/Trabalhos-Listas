package Exercicio5;

import java.util.Scanner;

public class Exercicio5 {

    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        Fila idosos = new Fila(5);
        Fila adultos = new Fila(5);
        int Opcao = Integer.MIN_VALUE;
        String item;
        
        while(Opcao != 0){
            System.out.println("1 - Adcione um idoso na fila. ");
            System.out.println("2 - Adicione um adulto na fila. ");
            System.out.println("3 - Imprime a fila.");
            System.out.println("0 - Esc.");
            System.out.print("Opção: ");
            Opcao = scan.nextInt();
			
            switch(Opcao) {
		        case 0:
                break;

		        case 1:
                    System.out.println("Insira o idoso na fila: ");
                    item = scan.next();
                    if ( !idosos.insere(item) ){
			            System.out.println("Fila cheia.");
                    }
                break;

		        case 2:
                    System.out.println("Insira o adulto na fila: ");
                    item = scan.next();
                    if ( !adultos.insere(item) ){
                        System.out.println("Fila cheia.");
                    }
                break;

                case 3:
                    System.out.println("Fila com prioridade: ");
                    Exercicio5.imprimeFilas(idosos,adultos);
                    System.out.print("\n");
                    System.exit(0);

                default: 
                    System.out.println("Opção Inválida");
            }
		}
        scan.close();
    }   
    
    public static void imprimeFilas(Fila idosos, Fila adultos) {
        Fila idosoAdulto = new Fila(idosos.tamanho + adultos.tamanho);
          
        while(!idosos.vazia() || !adultos.vazia()) {
            if(!idosos.vazia()) { 
                idosoAdulto.insere(idosos.remove());
            } else if(!adultos.vazia()) { 
                idosoAdulto.insere(adultos.remove());
            }
        }
        idosoAdulto.imprime();
    }
}
