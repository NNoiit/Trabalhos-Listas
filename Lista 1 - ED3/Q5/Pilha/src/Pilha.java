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


	//Q5 -------------------------
	public boolean verifica_balanceamento(Pilha pilha){

		Pilha pilha_aux = new Pilha(20);

		char c, memoria = '';
		//boolean resul = false, ordem = false;
		//int conchetes = 0, chaves = 0, parenteses = 0;
		while(!pilha.vazia()){
			c = pilha.pop();

			if(c == '[' || c == ']'){
				conchetes++;

				if(memoria == ''){
					pilha_aux.push(c);
					memoria = pilha_aux.pop();
				} else if(memoria == '(' || memoria == '[' || memoria == '{'){
					if(c == '(' || c == '[' || c == '{'){
						pilha_aux.push(memoria);
						pilha_aux.push(c);
					} else if (c == ']' && memoria == '['){
						continue;
					} else {
						return false;
					}
				}
			}

			if(c == '{' || c == '}'){
				chaves++;

				if(memoria == ''){
					pilha_aux.push(c);
					memoria = pilha_aux.pop();
				} else if( memoria == '(' || memoria == '[' || memoria == '{'){
					if(c == '(' || c == '[' || c == '{'){
						pilha_aux.push(memoria);
						pilha_aux.push(c);
					} else if (c == '}' && memoria == '{'){
						continue;
					} else {
						return false;
					}
				}
			}

			if(c == '(' || c == ')'){
				parenteses++;

				if(memoria == ''){
					pilha_aux.push(c);
					memoria = pilha_aux.pop();
				} else if( memoria == '(' || memoria == '[' || memoria == '{'){
					if(c == '(' || c == '[' || c == '{'){
						pilha_aux.push(memoria);
						pilha_aux.push(c);
					} else if (c == ')' && memoria == '('){
						continue;
					} else {
						return false;
					}
				}
			}
		}

		/*if(conchetes%2 == 0 && chaves%2 == 0 && parenteses%2 == 0){
			return true;
		}
		
		else if(conchetes == 0 || chaves == 0 || parenteses == 0){

			return true;
		}
		
		else if(conchetes != 0 && conchetes%2 != 0){
			resul = false
		}

		else if(parenteses != 0 && parenteses%2 != 0){
			resul = false
		}

		else if(chaves != 0 && chaves%2 != 0){
			resul = false
		}

		if(resul == true){
			return true;
		} else {
			return false;
		}*/
	}
}