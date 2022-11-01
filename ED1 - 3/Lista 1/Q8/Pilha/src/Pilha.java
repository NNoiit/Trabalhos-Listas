public class Pilha
{
	private int n;
	private char vetor[];
	private static int topo;
	
	public Pilha()
	{
		n = 10;
		vetor = new char[n];
		topo = -1;
	}
	
	public Pilha(int tamanho)
	{
		n = tamanho;
		vetor = new char[tamanho];
		topo = -1;
	}
	
	public boolean vazia()
	{
		return topo == -1 ? true : false;
	}
	
	public boolean cheia()
	{
		return topo == n - 1 ? true : false;
	}
	
	public char pop()
	{
		char c = '\0';
		
		if (!this.vazia())
		{
			c = vetor[topo];
			
			//Decrementando o topo, o elemento � "removido"
			topo--;
		}
		else
		{
			//Impress�o para fins did�ticos
			System.out.println("Pilha vazia: pop n�o funcionou.");
		}
		
		return c;
	}
	
	public boolean push(char elemento)
	{
		if (!this.cheia())
		{
			vetor[++topo] = elemento;
			return true;
		}
		else
		{
			//Impress�o para fins did�ticos
			System.out.println("Pilha cheia: push n�o funcionou.\n");
			return false;
		}
	}
	
	public char retornaTopo()
	{
		char elemento = '\0';

		if(!this.vazia())
		{
			elemento = vetor[topo];         
		}
		else
		{
			System.out.println("Pilha vazia.");
		}

		return elemento;
	}

	//Q7 -  Recebe uma pilha convertida, inicia um loop parando quando "i" alcança o topo, x serve para alterar o tipo do dado retirado da pilha e concatenar ele na string resul, dentro do lop é verificado se resul é igual a 4 em tamanho para que seja comparado os valores da primeira pocisção e a terceira, uma vez a terceira sendo maior, é visto como um par e adicionado a string "pares". Ao final da pilha é retornado todos os pares e durante o processo é printado todos os sub conjuntos
	public static void subsequencias(Pilha pilha, String pares){
		
		char c;
		int  i = 0, x;
		String resul= "";

		
		c = pilha.pop();
	
		while(i < topo){
			x = Integer.parseInt(String.valueOf(c)) + i;
			resul +=(x) + " ";

			if(resul.length() == 4){
				if(resul.charAt(0) < resul.charAt(2)){
					pares += "("+ resul.charAt(2) + "," + resul.charAt(0) + ")";
				}
			}
			System.out.println(resul);
			i++;
		}

		if(!pilha.vazia()){
			subsequencias(pilha, pares);
		}

		if(pilha.vazia()){
			System.out.println(pares);
		}

	}
}