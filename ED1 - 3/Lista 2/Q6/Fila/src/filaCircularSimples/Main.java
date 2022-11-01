package filaCircularSimples;
import java.util.Scanner;

public class Main
{
	public static void main(String args[])
	{
		FilaDupla fila = new FilaDupla(5);
		Scanner scanner = new Scanner(System.in);
		int i,N;
		
		while(i < N){
			fila.insere(i);
		}

		convert_binari(fila);
		scanner.close();
	}
}
