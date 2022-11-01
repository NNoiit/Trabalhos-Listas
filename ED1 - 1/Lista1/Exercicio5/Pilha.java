package Exercicio5;

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
			
			//Decrementando o topo, o elemento "removido"
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

	//Exercicio5
    public String Balanceada(String resul){
        resul = "Balanceado";
		int i = this.topo;

        while(i != -1){

			//Buscando o parde ()
            if(this.vetor[i] == ')'){

                for(int x = 0; x <= this.topo; x++){
					
					if(this.vetor[x] == '('){
					
						resul = "Balanceado";
						x = 666;
					
					}else if(x==this.topo){
						resul = "Não balanceado";
					}
				}
            }
			//Buscando o parde []
			else if(this.vetor[i] == ']'){

                for(int x = 0; x <= this.topo; x++){
					
					if(this.vetor[x] == '['){
					
						resul = "Balanceado";
						x = 666;
					
					}else if(x==this.topo){
						resul = "Não balanceado";
					}
				}
            }
			//Buscando o parde {}
			else if(this.vetor[i] == '}'){

                for(int x = 0; x <= this.topo; x++){
					
					if(this.vetor[x] == '{'){
					
						resul = "Balanceado";
						x = 666;
					
					}else if(x==this.topo){
						resul = "Não balanceado";
					}
				}
            }

			/*
            pilhaAux.push(this.pop());

            switch(this.pop()){
                
                case ')':
                while(!this.vazia()){
                    pilhaAux.push(this.pop());
                if(this.pop() == '('){
                    resul = "Balanceado";
                }
            }
                case ']':
                while(!this.vazia()){
                    pilhaAux.push(this.pop());
                if(this.pop() == '['){
                    resul = "Balanceado";
                }
            }
                case '}':
                while(!this.vazia()){
                    pilhaAux.push(this.pop());
                if(this.pop() == '{'){
                    resul = "Balanceado";
                }
            }
            }*/

			i--;       
        }
        return resul;
    }
}