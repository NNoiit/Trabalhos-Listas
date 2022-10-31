package Exercicio6;

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

	//Exercicio6
    public void Inversor(){
        Pilha pilhaInvertida = new Pilha(30);
        int x = this.topo + 1, y = 0;
		int tamanho = this.topo;
        
        while(!this.vazia()){

			//Pegar as ultimas letra antes do espaço em branco que da inicio ao IF
            if(this.pop() == ' '){
				for(int i = x; i <= tamanho+1 && this.vetor[i] != ' '; i++){
                pilhaInvertida.push(this.vetor[i]);
				}
				pilhaInvertida.push(' ');
				tamanho = x-1;
            }

			//Verificar se existe mais de um espaço em branco
			y = 0;
			if(this.vetor[x -1] == ' '){
				for(int i = x; i!= -1; i--){
					if(this.vetor[i] == ' '){
						y++;
					}
				}
			}
			//escrever a ultima palavra depois do ultimo espaço em pranco
			if(y == 1){
				for(int i = 0; this.vetor[i] != ' '; i++){
					pilhaInvertida.push(this.vetor[i]);
				}
			}
            x--;
        }
		//Printar na tela a frase invertida
		while(y <= pilhaInvertida.topo ){
			System.out.print(pilhaInvertida.vetor[y]);
				y++;
		}
    }
}
