package Exercicio4;

import java.util.Scanner;

public class Exercicio4 {

    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        Fila fila1 = new Fila(5);
        FilaDupla filaConvertida = new FilaDupla(5);
		int Opcao = Integer.MIN_VALUE, item;

        while(Opcao != 0) {

            //Menu
		    System.out.println("1 - Adicionar elemento na fila.");
		    System.out.println("2 - Converte em fila circular dupla.");                
		    System.out.println("0 - Esc.");
		    System.out.print("Digite uma das opções: ");
		    Opcao = scan.nextInt();

            switch(Opcao) {
                case 0:
                break;

                case 1:
                    System.out.println("Adicione um item a fila: ");
                    item = scan.nextInt();
                    if (!fila1.insere(item)){
                        System.out.println("Fila cheia.");
                    }
                break;

                case 2:
                    filaConvertida = Fila.filaCircularConverteDupla(fila1);
                break;

                default: 
                    System.out.println("Opção Inválida");
                }
            }
        System.out.println(filaConvertida);
        scan.close();
    }
}