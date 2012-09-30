package FAA.TG.Algoritmos.Profundidade;

import FAA.TG.Algoritmos.Grafos.Grafo;

/**
 * Todos os vértices sao iniciados branco
 * Quando for descoberto pela primeira vez se torna cinza
 * E Preto qdo sua lista de adjacentes forem todos visitados
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
        int n = this.grafo.numVertices();
        d = new int[n];
        t = new int[n];
        antecessor = new int[n];
    }

    private int visitaDfs(int u, int tempo, int cor[]) {
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
}