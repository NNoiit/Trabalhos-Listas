package Exercicio2;

public class Exercicio2 {

    public static void main(String[] args) {
        ListaOrdenada lista1 = new ListaOrdenada();
        ListaOrdenada lista2 = new ListaOrdenada();
        ListaOrdenada listaIntercalada = new ListaOrdenada();


        lista1.insere(9);
        lista1.insere(3);
        lista1.insere(5);
        System.out.println("Lista 1: ");
        lista1.imprime();
                
        lista2.insere(8);
        lista2.insere(4);
        System.out.println("Lista 2: ");
        lista2.imprime();
	
        System.out.println("Lista intercalada ordenada: ");
        listaIntercalada = ListaOrdenada.intercalaListas(lista1.prim,lista2.prim, listaIntercalada);
        listaIntercalada.imprime();       
        
    }
}