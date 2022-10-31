public class MainPilha
{
	public static void main(String args[])
	{

		Pilha pilha1_q3 = new Pilha(20); 
		Pilha pilha2_q3 = new Pilha(20);

		int i = 0;

		//entradas de teste
		String s_q3 = "chocolate", s2_q3 = "puala";
		int tamanho = s_q3.length() + s2_q3.length();
		char c, c2;
		char[] resul;

		while (i < s_q3.length() || i < s2_q3.length())
		{
			if(i < s_q3.length()){
				c = s_q3.charAt(i);
				pilha1_q3.push(c);
			}
			
			if(i < s2_q3.length()){
				c2 = s2_q3.charAt(i);
				pilha2_q3.push(c2);
			}
			i++;
		
		}
		resul = Pilha.vetor_pilhas(pilha1_q3, pilha2_q3, tamanho);

		i=0;
		while(i<100){
			i++;
		}
		System.out.print(resul);
			
	}
}
