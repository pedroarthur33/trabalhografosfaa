package FAA.TG.Algoritmos.Profundidade;

import FAA.TG.Algoritmos.Grafos.Grafo;

/**
 * Todos os vértices sao iniciados branco Quando for descoberto pela primeira
 * vez se torna cinza E Preto qdo sua lista de adjacentes forem todos visitados
 *
 * @author Diego, Eduardo e Susan
 */
public class BuscaEmProfundidade {

    public static final byte branco = 0;
    public static byte cinza = 1;
    public static byte preto = 2;
    private int d[], t[], antecessor[];
    private Grafo grafo;

    public BuscaEmProfundidade(Grafo grafo) {
        this.grafo = grafo;
        int n = this.grafo.getNumVertices();
        d = new int[n];
        t = new int[n];
        antecessor = new int[n];
    }

    public int visitaDfs(int u, int tempo, int cor[]) {
        cor[u] = cinza;
        this.d[u] = ++tempo;
        if (!this.grafo.listaAdjVazia(u)) {
            Grafo.Aresta a = this.grafo.primeiroListaAdj(u);
            while (a != null) {
                int v = a.getV2();
                if (cor[v] == branco) {
                    this.antecessor[v] = u;
                    tempo = this.visitaDfs(v, tempo, cor);
                }
                a = this.grafo.proxAdj(u);
            }
        }
        cor[u] = preto;
        this.t[u] = ++tempo;
        return tempo;
    }

    public void buscaEmProfundidade() {
        int tempo = 0;
        int cor[] = new int[this.grafo.getNumVertices()];
        for (int u = 0; u < grafo.getNumVertices(); u++) {
            cor[u] = branco;
            this.antecessor[u] = -1;
        }
        for (int u = 0; u < grafo.getNumVertices(); u++) {
            if (cor[u] == branco) {
                tempo = this.visitaDfs(u, tempo, cor);
            }
        }
    }

    public int[] getD() {
        return d;
    }

    public void setD(int[] d) {
        this.d = d;
    }

    public int[] getT() {
        return t;
    }

    public void setT(int[] t) {
        this.t = t;
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