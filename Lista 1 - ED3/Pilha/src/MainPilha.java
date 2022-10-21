import java.util.Scanner;

public class MainPilha
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		
		Pilha pilha1 = new Pilha(20);
		Pilha pilha2 = new Pilha(20);
		String s;
		char c;
		
				
		System.out.println("Entre com uma frase: ");
		s = scanner.nextLine();
		
		int i = 0, x = 0;
		
		while (i < s.length())
		{
			c = s.charAt(i);
			if(i < (s.length()-1)/2){
				pilha1.push(c);
				i++;
			}
			if(i > (s.length()-1)/2){
				pilha2.push(c);
				i--;
			}

			if((c != 'A' || c != 'B')){
				if(x==1 && (c != 'A' || c != 'B')){
					break;
				}
				x = 1;
				i = s.length()-1;
			}

		}
		
		verifica_inverso(pilha1, pilha2);
		
		scanner.close();
	}

	//Q - 1 Verificação de contrario
	public static boolean verifica_inverso(Pilha pilha1, Pilha pilha2){
		char x, y;
		
		while((!pilha1.vazia())){

			x = pilha1.pop();
			y = pilha2.pop();

			if(x != y){
				return false;
			}

			if(x != 'A'|| x != 'B'|| y != 'A'|| y != 'B'){
				break;
			}
		}

		return true;
	}

	public boolean verifica_cadeia(Pilha pilha){

		while(pilha.vazia()){
			
			char x = pilha.pop();

			
			if(x == 'D'){

			}
		}
		return false;
	}

}
