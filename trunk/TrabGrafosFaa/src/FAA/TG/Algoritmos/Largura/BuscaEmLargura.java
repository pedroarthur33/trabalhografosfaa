/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FAA.TG.Algoritmos.Largura;

import FAA.TG.Algoritmos.Fila.Fila;
import FAA.TG.Algoritmos.Grafos.Grafo;

/**
 * 
 * @author diego
 */
public class BuscaEmLargura {

    public static final byte branco = 0;
    public static byte cinza = 1;
    public static byte preto = 2;
    private int d[], antecessor[];
    private Grafo grafo;

    public BuscaEmLargura(Grafo grafo) {
        this.grafo = grafo;
        int n = this.grafo.numVertices();
        this.d = new int[n];
        this.antecessor = new int[n];
    }

    public void visitaBfs(int u, int cor[]) throws Exception {
        cor[u] = cinza;
        this.d[u] = 0;
        Fila fila = new Fila();
        fila.enfileira(new Integer(u));
        while (!fila.vazia()) {
            Integer aux = (Integer) fila.desenfileira();
            u = aux.intValue();
            if (!this.grafo.listaAdjVazia(u)) {
                Grafo.Aresta a = this.grafo.primeiroListaAdj(u);
                while (a != null) {
                    int v = a.getV2();
                    if (cor[v] == branco) {
                        cor[v] = cinza;
                    }
                    this.d[v] = this.d[u] + 1;
                    this.antecessor[v] = u;
                    fila.enfileira(new Integer(v));
                }
                a = this.grafo.proxAdj(u);
            }
        }
        cor[u] = preto;
    }
}
