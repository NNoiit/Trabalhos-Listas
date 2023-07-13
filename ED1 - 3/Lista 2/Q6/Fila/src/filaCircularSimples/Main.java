package filaCircularSimples;
import java.util.Scanner;

import filaCircularDupla.FilaDupla;

public class Main
{
	public static void main(String args[])
	{
		FilaDupla fila = new FilaDupla(5);
		Scanner scanner = new Scanner(System.in);
		int i = 0,N = 0;
		N = scanner.nextInt();
		while(i < N){
			fila.insere(i);
		}

		Fila.convert_binari(fila, N);
		scanner.close();
	}
}
