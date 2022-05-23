package Exercicio7;


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
			topo--;
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


	//Exercicio7
    public void VerificarPrioridade(){
		Pilha novaExpreção1 = new Pilha(30);
		Pilha novaExpreção2 = new Pilha(30);
		int operador1 = 666, operador2 = 666;
		String digitoDuplo = "";
		char sinal = '\0';

		//passando os valores da pilha digitada e contando as vezes para o reultado
		while(!this.vazia()){
			sinal = this.pop();
			novaExpreção2.push(sinal);
			
		}
		sinal = '\0';

		while(novaExpreção2.topo>3){
			while(!novaExpreção2.vazia()){
				digitoDuplo = "";
				sinal = '\0';
				char carat = novaExpreção2.pop();

				//Pondo os conchetes na nova expreção, da direita para esquerda
				while(carat == '(' 
				|| carat ==')'
				|| carat == '+'
				|| carat == '-'
				|| carat == '*'
				|| carat == '/'){
					novaExpreção1.push(carat);
					carat = novaExpreção2.pop();
				}

				//Pegando o valor do primeiro operador a ser feito
				for(int x = 0; x<10; x++){
					if(Character.getNumericValue(carat) == x){
						operador1 = Character.getNumericValue(carat);
						break;
					}
				}

				//Checando se é um sinal
				carat = novaExpreção2.pop();
				if(carat == '+' || carat == '-' || carat == '/' || carat == '*'){
					sinal = carat;
					carat = novaExpreção2.pop();
				}
				//armazenando um numero com mais de um digito no operador1
				else if(carat != '(' || carat != ')' && operador2 == 666 && sinal != '\0'){
					digitoDuplo =carat + Integer.toString(operador1);
					carat = novaExpreção2.pop();

					if(digitoDuplo.equals("00")){
						digitoDuplo = carat + digitoDuplo;
						carat = novaExpreção2.pop();
					}
					operador1 = Integer.parseInt(digitoDuplo);
					digitoDuplo = "";
				}

				//Checando se é um sinal
				if(carat == '+' || carat == '-' || carat == '/' || carat == '*'){
					sinal = carat;
					carat = novaExpreção2.pop();
				}
				if(carat == ')' || carat == '('){
					digitoDuplo = Integer.toString(operador1);
					for(int i = 0; i< digitoDuplo.length(); i++){
					novaExpreção1.push(digitoDuplo.charAt(i));
					}
				if(sinal!='\0'){
					novaExpreção1.push(sinal);
				}
				else if(sinal == '\0'){
					novaExpreção1.push(carat);
				}
				digitoDuplo = "";
				}

				//pegando o segundo operador
				if(carat != '(' && carat !=')' && sinal!= '\0'){
					for(int i = 0; i<10; i++){
						if(Character.getNumericValue(carat) == i){
							operador2 = Character.getNumericValue(carat);
							break;
						}
					}
				}
				

				carat = novaExpreção2.pop();
				//calculando os dois operadores
				if(carat == '(' && operador1 != 666 && operador2 !=666){
					switch(sinal){
						case '+':
					
						novaExpreção1.pop();
						operador1 = operador1 + operador2;
						digitoDuplo = Integer.toString(operador1);
							for(int i = digitoDuplo.length() - 1; i!=-1; i--){
								sinal = digitoDuplo.charAt(i);
								novaExpreção1.push(sinal);
							}
						operador1 = operador2 = 666;
						break;

						case '-':
					
						novaExpreção1.pop();
						operador1 = operador1 - operador2;
						digitoDuplo = Integer.toString(operador1);
							for(int i = digitoDuplo.length()-1;i!=-1; i--){
								sinal = digitoDuplo.charAt(i);
								novaExpreção1.push(sinal);
							}
						operador1 = operador2 = 666;
						break;

						case '*':
					
						novaExpreção1.pop();
						operador1 = operador1 * operador2;
						digitoDuplo = Integer.toString(operador1);
							for(int i = digitoDuplo.length() -1 ; i!=-1; i--){
								sinal = digitoDuplo.charAt(i);
								novaExpreção1.push(sinal);
							}
						operador1 = operador2 = 666;
						break;

						case '/':
					
						novaExpreção1.pop();
						operador1 = operador1 / operador2;
						digitoDuplo = Integer.toString(operador1);
							for(int i=digitoDuplo.length() - 1; i != -1; i--){
								sinal = digitoDuplo.charAt(i);
								novaExpreção1.push(sinal);
							}
						operador1 = operador2 = 666;
						break;
					}
				}
			}
			//reiniciando a pilha
			novaExpreção2 = new Pilha(30);
			while(!novaExpreção1.vazia()){
				novaExpreção2.push(novaExpreção1.pop());
			}
			novaExpreção1 = new Pilha(30);

			while(novaExpreção2.topo < 3){
				System.out.print(novaExpreção2.pop());
			}
		}
	}

}