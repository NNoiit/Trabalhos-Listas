import java.util.Scanner;

public class MainPilha
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		int opc = scanner.next();

		switch(opc){
			case 1:
			
				Pilha pilha_q1 = new Pilha(20);
				String s;
				char c;
				
						
				System.out.println("Entre com uma frase: ");
				s = scanner.nextLine();
				
				int i = 0;
				
				while (i < s.length())
				{
					c = s.charAt(i);
					pilha_q1.push(c);
					i++;

				}
				
				if(verifica_inverso(pilha_q1)){
					Sistem.out.println("Correto");
				} else{
					Sistem.out.println("Incorreto");
				}
				break;

			case 2:

				Pilha pilha_q2 = new Pilha(20);

				int i = 0;
				while (i < s.length())
				{
					c = s.charAt(i);
					pilha_q2.push(c);
					i++;
				}

				if(verifica_cadeia(pilha_q2)){
					Sistem.out.println("Correto");
				} else {
					Sistem.out.println("Incorreto");
				}

			}

			scanner.close();
			
		}

	
	
	//Q - 1 Verificação de contrario
	public static boolean verifica_inverso(Pilha pilha){

		Pilha pilha_aux = new Pilha(20);
		char x, y;
		boolean controler = true;

		
		while(!pilha.vazia()){

			x = pilha.pop();

			if((x == 'A'|| x == 'B') && controler){
				pilha_aux.pop(x);
			} else {
				controler = false;
			}

			if(!controler){
				x = pilha.pop();
				y = pilha_aux.pop();

				if(x != y){
					return false;
				}
			}
		}

		return true;
	}

	//Q - 2 Verificação formato aDbDc
	public boolean verifica_cadeia(Pilha pilha){

		Pilha pilha_aux = new Pilha(20);

		while(!pilha.vazia()){
			
			char c = pilha.pop();
			

			if(c == 'D'){
				
				if(verifica_inverso(pilha_aux)){
					pilha.esvazia_pilha(pilha_aux);
					continue;
				} else {
					Sistem.out.println("Uma das varieveis não está no formato xCy. Incorreto!!!");
					break;
				}
			} else {
				pilha_aux.push(c);
			}
			
		}

		if(pilha.vazia()){
			return true;
		}

		return false;
	}

}
