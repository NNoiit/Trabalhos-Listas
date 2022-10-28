public class Pilha
{
	private int n;
	private char vetor[];
	private int topo;
	
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

	//Q6
	public static String inverte_palavra(Pilha pilha, String resp){
		Pilha pilha_aux = new Pilha();
		char c, b;
		String resp1 = "";

		/*while(!pilha.vazia()){
			c = pilha.pop()

			if(c == ' '){
				while(!pilha_aux.vazia()){
					b = pilha_aux.pop();
					if(resp != " "){
						resp = resp + " " + b;	
					} else {
						resp = +b;
					}
				}
			}

			pilha_aux.push(c);
		}*/

		while(!pilha.vazia()){
			c = pilha.pop()

			if(c == ' '){
				b = pilha_aux.pop();
				resp1 += resp + " " + b;
				break;
			}

			pilha_aux.push(c);
		}

		if(!pilha.vazia()){
			inverte_palavra(pilha, resp1);
		}

		return resp;
		
	}
}