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

	//Q2 -  metodo criado para solucionar o problema da pilha_aux permanecer cheia
	public static esvazia_pilha(Pilha pilha){
		if(!pilha.vazia()){
			pilha.pop();
		} else{
			esvazia_pilha(pilha);
		}
	}

	//Q3
	public static Cahr[] vetor_pilhas(Pilha entrada1, Pilha entrada2, int tamanho){

		Char array[] = new char[tamanho];
		Char c;
		int contador = 0, contador2 = tamanho;

		while(contador < tamanho){
			//checa se a primeira pilha ainda possui elementos, pega um elemento dela, checa se pode ser adicionado no "topo" inferior do array e adiciona
			if(!entrada1.vazia()){
				c = entrada1.pop();
				
				if(contador != contador2 && contador < contador2){
					array[contador] = c;
				}
			}

			//checa se a primeira pilha ainda possui elementos, pega um elemento dela, checa se pode ser adicionado no "topo" superior do array e adiciona
			if(!entrada2.vazia()){
				c = entrada2.pop();

				if(contador != contador2 && contador2 > contador){
					array[contador2-1] = c;
				}
				
			}

			//checa se o "topo" superior e igual ao inferior
			if(contador == contador2){
				break;
			}

			contador++;
			contador2--;
		}

		//retorna o array com as duas pilhas
		return array;
	}
}