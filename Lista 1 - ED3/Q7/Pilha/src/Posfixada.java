import java.util.Scanner;

public class Posfixada
{
	private Integer resposta; // Armazena a resposta final
	private PilhaGenerica<Integer> pilha; // Pilha para armazenar os operandos
	private String expressao; // Expressao posfixada
	private Scanner scan; // Para ler da entrada padr�o
	
	public Posfixada(int tamanhoPilha)
	{
		pilha = new PilhaGenerica<>(tamanhoPilha);
		expressao = new String();
		scan = new Scanner(System.in);
	}
	
	// L� express�o para ser avaliada
	public void leExpressao()
	{
		System.out.println("Resultado da entrada ");
		
		//Entrada do enunciado
		expressao = "(1+((2+3)*(4*5)))";

		//Covertendo a entrada em pilha
		Pilha pilha = new Pilha(20);
		char c;
		
		int i = 0;
		
		while ( i < expressao.length() )
		{
			c = expressao.charAt(i);
			pilha.push(c);
			i++;
		}
		///////////////////////////////////
	 //////retornando a entrada no formato de pos fixada
		expressao = convert_posfixa(pilha);
	}
	
	
	private boolean eOperador(char simbolo)
	{
		if (simbolo == '*' || simbolo == '+' || 
			simbolo == '-' || simbolo == '/')
			return true;

		return false;
	}


	private boolean aplicaOperador(char operador)
	{
		Integer operando1 = 0, operando2 = 0;

		
		operando1 = pilha.pop();
		operando2 = pilha.pop();
		
		if (operando1 == null) return false;
		if (operando2 == null) return false;
		
		switch (operador) {
		case '*':
			pilha.push(operando1 * operando2);  break;
		case '+':
			pilha.push(operando1 + operando2); break;
		case '/':
			pilha.push(operando2 / operando1);  break;
		case '-':
			pilha.push(operando2 - operando1);  break;
		default:
			return false;
		}
		return true;
	}
	
	public boolean avaliaExpressao()
	{
		int simbolo = 0;
	
		while(simbolo < expressao.length()) {
			if (eOperador( expressao.charAt(simbolo) )) {
				if (!aplicaOperador( expressao.charAt(simbolo) )) {
					System.out.println("Erro: a express�o est� incorreta.");
					return false;
				}
			} else if ((expressao.charAt(simbolo) >= '0')
					&& (expressao.charAt(simbolo) <= '9'))
			{				
				pilha.push(Character.getNumericValue( expressao.charAt(simbolo) ));
			}
			simbolo++;
		}
		
		resposta = pilha.pop();
		
		if (resposta == null) {
			System.out.println("Erro desempilhando resposta.");
			return false;
		}
		else if (!pilha.vazia()) {
			System.out.println("Erro: muitos operandos.\n");
			return false;
		}
		
		return true;
	}


	//Q7 ---- transformando em posfixada para assim realizar a resolução
	public static String convert_posfixa(Pilha pilha){
		Pilha pilha1 = new Pilha(20);
		Pilha pilha2 = new Pilha(20);
		String infixa = "";
		char c, s = ' ';
		int cont = 0, cont_simbolo = 0;
		while(!pilha.vazia()){
			c = pilha.pop();

			if(c == ')' || c == '('){
				continue;
			} else if(c >= '0' && c <= '9'){
				cont++;
				pilha1.push(c);
				c = pilha.pop();

				if(s != ' ' && cont_simbolo == 1 && cont == 1){
					pilha2.push(s);
				}
			} 

			if (c == '+' || c == '*' || c == '-'){
				pilha2.push(c);
				cont_simbolo = 1;
			}

			if(cont == 0 && cont_simbolo == 1 && !pilha2.vazia()){
				s = pilha2.pop();
			}

			if(cont == 2){
				infixa += pilha1.pop();
				infixa += pilha1.pop();
				infixa += pilha2.pop();

				if(s != ' '){
					infixa+= s;
				}

				cont = 0;
				cont_simbolo = 0;
			}
			
		}

		if(pilha.vazia() && !pilha1.vazia() && !pilha2.vazia()){
			infixa += pilha1.pop();
			if(!pilha1.vazia()){
				infixa += pilha1.pop();
			}
			infixa += pilha2.pop();

		}

		return infixa;
	}
	
	public void imprimeResposta()
	{
		System.out.println("Resposta = " + resposta);
	}
}