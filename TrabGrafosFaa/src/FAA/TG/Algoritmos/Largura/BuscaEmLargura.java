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
        int n = this.grafo.getNumVertices();
        this.d = new int[n];
        this.antecessor = new int[n];
    }

    private void visitaBfs(int u, int cor[]) throws Exception {
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

    public void buscaEmLargura() throws Exception {
        int cor[] = new int[this.grafo.getNumVertices()];
        for (int u = 0; u < grafo.getNumVertices(); u++) {
            cor[u] = branco;
            this.d[u] = Integer.MAX_VALUE;
            this.antecessor[u] = -1;
        }
        for (int u = 0; u < grafo.getNumVertices(); u++) {
            if (cor[u] == branco) {
                this.visitaBfs(u, cor);
            }
        }
    }

    public int[] getD() {
        return d;
    }

    public void setD(int[] d) {
        this.d = d;
    }

    public int[] getAntecessor() {
        return antecessor;
    }

    public void setAntecessor(int[] antecessor) {
        this.antecessor = antecessor;
    }

    public void imprimeCaminho(int origem, int v) {
        if (origem == v) {
            System.out.println(origem);
        } else if (this.antecessor[v] == -1) {
            System.out.println("Nao existe caminho de " + origem + " ate " + v);
        } else {
            imprimeCaminho(origem, this.antecessor[v]);
            System.out.println(v);
        }
    }
}
