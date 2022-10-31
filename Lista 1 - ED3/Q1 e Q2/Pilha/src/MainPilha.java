import java.util.Scanner;

public class MainPilha
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Escolha entre a questão (1) ou (2)");
		int opc = scanner.nextInt();
		String s = "ABBCBBA", s2 = "ABBCBBADABACABA";
		char c;
		

		switch(opc){
			case 1:

			
				Pilha pilha_q1 = new Pilha(20);
				
				
				int i = 0;
				
				while (i < s.length())
				{
					c = s.charAt(i);
					pilha_q1.push(c);
					i++;

				}
				
				if(verifica_inverso(pilha_q1)){
					System.out.println("Correto");
				} else{
					System.out.println("Incorreto");
				}
			break;
			
			case 2:

				Pilha pilha_q2 = new Pilha(20);

				i = 0;
				while (i < s2.length())
				{
					c = s2.charAt(i);
					pilha_q2.push(c);
					i++;
				}

				if(verifica_cadeia(pilha_q2) && s != ""){
					System.out.println("Correto");
				} else {
					System.out.println("Incorreto");
				}
			break;
			}
			scanner.close();
		}

	
	
	//Q - 1 Verificação de contrario
	public static boolean verifica_inverso(Pilha pilha){

		Pilha pilha_aux = new Pilha(20);
		char x = ' ', y;
		boolean controler = true;

		
		while(!pilha.vazia()){

			if(controler){
				x = pilha.pop();
			}
				

			if((x == 'A'|| x == 'B') && controler){
				pilha_aux.push(x);
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
	public static boolean verifica_cadeia(Pilha pilha){

		Pilha pilha_aux = new Pilha(20);

		while(!pilha.vazia()){
			
			char c = pilha.pop();
			

			if(c == 'D'){
				
				if(verifica_inverso(pilha_aux)){
					pilha.esvazia_pilha(pilha_aux);
					continue;
				} else {
					System.out.println("Uma das varieveis não está no formato xCy. Incorreto!!!");
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
