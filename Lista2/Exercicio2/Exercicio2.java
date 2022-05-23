package Exercicio2;
import java.util.Scanner;

public class Exercicio2 {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int OpcaoU = Integer.MIN_VALUE, item;
        
        Fila f1 = new Fila(3);
        Fila f2 = new Fila(3);
        Fila filaMista = new Fila(10);


        
        while(OpcaoU != 0) {

            System.out.println("1 - Adicionar na primeira fila");
		    System.out.println("2 - Adicionar na segunda fila");
		    System.out.println("3 - Imprimir fila combinada");
		    System.out.println("0 - Esc");
		    System.out.print("Digite uma das opções: ");
            OpcaoU = scanner.nextInt();

                switch(OpcaoU) {
		            case 0:
                    break;

		            case 1:
                        System.out.println("Adicione na primeira fila: ");
                        item = scanner.nextInt();
                        if ( !f1.insere(item))
			                System.out.println("Fila cheia.");
                    break;

		            case 2:
                        System.out.println("Adicione na segunda fila: ");
                        item = scanner.nextInt();
                        if ( !f2.insere(item) )
                            System.out.println("Fila cheia.");
                    break;

		            case 3:                   
                        filaMista.combinaFilas(f1, f2);
                        System.out.print("\n");
                        System.exit(0);
                    break;
                      
                    default: 
                    System.out.println("Opção Inválida");
            }		
        }
	
	scanner.close();
    }
}
