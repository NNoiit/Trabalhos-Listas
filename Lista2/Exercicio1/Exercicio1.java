package Exercicio1;
import java.util.Scanner;

public class Exercicio1 {
    public static void main(String args[]) {
            
		Sistema Sis = new Sistema(5); 
		Scanner scanner = new Scanner(System.in);
		int Opcao = Integer.MIN_VALUE, processo;
		
		while(Opcao != 0) {
			Opcao = Sis.menuProcesso();
			
			switch(Opcao) {
                case 0:
                break;

                case 1:
                    System.out.println("Inclur: ");
                        processo = scanner.nextInt();
                            if ( !Sis.insere(processo))
                                System.out.println("Fila está cheia.");
                break;

                case 2:
                    processo = Sis.remove();
                        if (processo != Integer.MIN_VALUE)
                            System.out.println(processo + "' foi removido.");
                        else
                            System.out.println("Fila está vazia.");
                break;

                case 3:
                    System.out.println("Fila:");
                        Sis.imprimeProcesso();
                break;    

                default: 
                    System.out.println("Opção Inválida");
                }
            }
                
		scanner.close();
	}  
    
}
