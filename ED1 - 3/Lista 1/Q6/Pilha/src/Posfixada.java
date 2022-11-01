import java.util.Scanner;

public class Posfixada
{
	private Integer resposta; // Armazena a resposta final
	private PilhaGenerica<Integer> pilha; // Pilha para armazenar os operandos
	private String expressao; // Expressao posfixada
	private Scanner scan; // Para ler da entrada padrão
	
	public Posfixada(int tamanhoPilha)
	{
		pilha = new PilhaGenerica<>(tamanhoPilha);
		expressao = new String();
		scan = new Scanner(System.in);
	}
	
	// Lê expressão para ser avaliada
	public void leExpressao()
	{
		System.out.println("Entre com expressao posfixada: ");
		
		expressao = scan.next();
	}
	
	// Testa se simbolo corrente é um operador
	private boolean eOperador(char simbolo)
	{
		if (simbolo == '*' || simbolo == '+' || 
			simbolo == '-' || simbolo == '/')
			return true;

		return false;
	}

	// Aplica operador aos dois símbolos do topo da pilha
	// Retorna verdadeiro se operação realizada com sucesso, 
	// falso caso contrário
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
					System.out.println("Erro: a expressão está incorreta.");
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
	
	public void imprimeResposta()
	{
		System.out.println("Resposta = " + resposta);
	}
}