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
		System.out.println("Entre com expressao posfixada: ");
		
		expressao = "(1+((2+3)*(4*5)))";

		//Covertendo em pilha
		Pilha pilha = new Pilha(20);
		char c;
		
		int i = 0;
		
		while ( i < expressao.length() )
		{
			c = expressao.charAt(i);
			pilha.push(c);
			i++;
		}

		convert_posfixa(pilha);
	}
	
	// Testa se simbolo corrente � um operador
	private boolean eOperador(char simbolo)
	{
		if (simbolo == '*' || simbolo == '+' || 
			simbolo == '-' || simbolo == '/')
			return true;

		return false;
	}

	// Aplica operador aos dois s�mbolos do topo da pilha
	// Retorna verdadeiro se opera��o realizada com sucesso, 
	// falso caso contr�rio
	private boolean aplicaOperador(char operador)
	{
		Integer operando1 = 0, operando2 = 0;

		// Desempilha dois operandos
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

	public static String convert_posfixa(Pilha pilha){
		Pilha pilha1 = new Pilha(20);
		Pilha pilha2 = new Pilha(20);
		String infixa = "";
		char c;
		int cont = 0;
		while(!pilha.vazia()){
			c = pilha.pop();
			if(c == ')'){
				continue;
			} else if(c != '+' || c != '*' || c != '-'){
				cont++;
				pilha1.push(c);
				c = pilha.pop();
			} 
			
			if (c == '+' || c == '*' || c == '-'){
				pilha2.push(c);
				c = pilha.pop();
			}

			if(cont == 2){
				infixa += pilha1.pop();
				infixa += pilha1.pop();
				infixa += pilha2.pop();
				cont = 0;
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