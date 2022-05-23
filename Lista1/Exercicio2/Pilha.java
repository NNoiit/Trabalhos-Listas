package Exercicio2;

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


	//Exercicio2
    public static String Alfabeto(Pilha pilha1, String resultado){

		//Verificando se o proximo item retirado da pilha é um D, percorrendo toda a pilha
		while(!pilha1.vazia()){
			pilha1.pop();
			if(pilha1.pop() == 'D'){
				resultado = "True";
			}
			else if(pilha1.vazia()){
				resultado = "True";
			}else{
				resultado = "false";
			}
		}
        
        return resultado;
    }
}