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
		
		int i = 0;
		
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

			if(c != "A" || c != "B"){
				i = s.length()-1;
			}

		}

		verifica_inverso(pilha, s)? System.out.println("Está correto"): System.out.println("Está incorreto");
		
		scanner.close();
	}

	//Q - 1 Verificação de contrario
	public boolean verifica_inverso(Pilha pilha1, Pilha pilha2){
		char x, y;
		int cont = 0;
		
		while(pilha1.vazia()!){

			x = pilha1.pop();
			y = pilha2.pop();

			if(x != y){
				return false;
			}

			if(x != "A"|| x != "B"|| y != "A"|| y != "B"){
				break;
			}
		}

		return true;
	}

	public boolean verifica_cadeia(){

		while(pilha.vazia()){
			
			Pilha x = pilha.pop();

			
			if(x == "D"){

			}
		}
	}

}
