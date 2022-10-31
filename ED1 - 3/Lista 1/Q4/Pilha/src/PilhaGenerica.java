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
			//Impress�o para fins did�ticos
			System.out.println("Pilha vazia: pop nao funcionou.");
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
			//Impress�o para fins did�ticos
			System.out.println("Pilha cheia: push nao funcionou.\n");
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

	public static PilhaGenerica<Integer> retira_elem(PilhaGenerica<Integer> pilha,Object resul){
		PilhaGenerica<Integer> pilha_aux = new PilhaGenerica<>(20);
		Integer comparador;

		while(!pilha.vazia()){
			comparador = pilha.pop();

			if(!comparador.equals(resul)){
				pilha_aux.push(comparador);
			}
		}

		devolve_pilha(pilha_aux);
		
		return pilha_aux;
	}

	public static void devolve_pilha(PilhaGenerica<Integer> pilha){

		Integer c;

		if(!pilha.vazia()){
			c = pilha.pop();

			System.out.println(c);
			devolve_pilha(pilha);
		}
	}
}