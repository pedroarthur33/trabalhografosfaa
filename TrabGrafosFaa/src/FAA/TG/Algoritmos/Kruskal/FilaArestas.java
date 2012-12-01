package FAA.TG.Algoritmos.Kruskal;


import FAA.TG.Algoritmos.Grafos.Grafo.Aresta;
import java.util.LinkedList;
import java.util.Queue;

public class FilaArestas {

    Queue<Aresta> fila;

    // Operações 
    public FilaArestas() { // Cria uma fila vazia
        fila = new LinkedList<Aresta>();
    }

    public void enfileira(Aresta x) throws Exception {
        fila.add(x);
    }

    public Aresta desenfileira() throws Exception {
        return fila.poll();
    }

    public boolean vazia() {
        return fila.isEmpty();
    }

    public Integer tamanho() {
        return fila.size();
    }

    public void imprime() {

        System.out.println("Inicio da fila: ");
        while (!fila.isEmpty()) {
            Aresta temp = fila.poll();
            System.out.println("(" + temp.getV1() + " " + temp.getV2() + ")");
        }
        System.out.println("FIM da fila !!!!!!!!!!! ");


    }
}