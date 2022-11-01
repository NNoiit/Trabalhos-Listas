package Exercicio1;
import java.util.Scanner;

public class Sistema extends Fila {
    public Sistema (int tam) {
		super(tam);
	}
	
        public void imprimeProcesso() {
		int i, j;
		
		if (vazia()) {
			System.out.println("Fila está vazia.");
                }
                else {
                    System.out.println("Fila de processos: ");
			for (i = ini, j = 1; j <= n; j++, (i++)% tamanho)
				System.out.println(j + " " + vetor[i]);
                }
	}
	
        public int menuProcesso() {
		Scanner scanner = new Scanner(System.in);
		int Opção;

		System.out.println("1 - Adicionar novos processos na fila");
		System.out.println("2 - Remover processo da fila");
		System.out.println("3 - Imprimir fila de processos");
		System.out.println("0 - Esc");
		System.out.print("Digite uma das opções: ");
		Opção = scanner.nextInt();
        if(Opção == 0){
            scanner.close();
        }

		return Opção;
	}
}
