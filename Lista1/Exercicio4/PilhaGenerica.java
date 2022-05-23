package Exercicio4;

import java.util.Vector;

public class PilhaGenerica<T>
{
	private int n;
	private Vector<T> vetor;
	private int topo;
	
	public PilhaGenerica(int tamanho)
	{		
		n = tamanho;
		vetor = new Vector<T>(tamanho);
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
	
	public T pop()
	{
		T elemento;
		
		if (!this.vazia())
		{
			elemento = vetor.get(topo--);
			return elemento;
		}
		else
		{
			return null;
		}
	}
	
	public boolean push(T elemento)
	{
		if (!this.cheia())
		{
			vetor.add(++topo, elemento);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean retornaTopo(T elemento)
	{
	     if(!this.vazia()){
	        elemento = vetor.get(topo);         
	        return true;
	     }
	     else
	    	 return false;
	}

	//Exercicio4
	public void Remover(String item, Character remover){

		PilhaGenerica<Character> pilha1 = new PilhaGenerica<>(item.length());
		PilhaGenerica<Character> pilhaAux = new PilhaGenerica<>(item.length());

		Character c;
		//Formando uma pilha com o caractere removido
		for(int x = 0; x < item.length(); x++){
			c = item.charAt(x);
			
			if(!remover.equals(c)){
				pilhaAux.push(c);
			}
		}
		for(int x = 0; x < item.length(); x++){
			
			pilha1.push(pilhaAux.pop());
		}
		pilha1.pop();
		System.out.print("Caractere T removido: ");
		while(!pilha1.vazia()){
			System.out.print(pilha1.pop());
		}
	}
}