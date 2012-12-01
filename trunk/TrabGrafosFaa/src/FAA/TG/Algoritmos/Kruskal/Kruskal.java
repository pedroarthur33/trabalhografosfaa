package FAA.TG.Algoritmos.Kruskal;


import FAA.TG.Algoritmos.Kruskal.FibonacciHeap;
import FAA.TG.Algoritmos.Kruskal.GeradorArvoreMinima;
import FAA.TG.Algoritmos.Kruskal.Grafo;
import FAA.TG.Algoritmos.Kruskal.Heap;
import FAA.TG.Algoritmos.Kruskal.RelacaoEquivalencia;
import java.util.LinkedList;
import java.util.List;


public class Kruskal extends GeradorArvoreMinima{

        public Kruskal(Grafo g) {
                super(g);
        }

        @Override
        protected Grafo gerar(Grafo g, int grauMaximo, double custoMaximo) {
                Aresta[] arranjo = g.gerarArestas();
                Heap<Aresta> heap = new FibonacciHeap<Aresta>(Heap.Priority.MAX,
                                arranjo);

                List<List<Aresta>> florestas = new LinkedList<List<Aresta>>();
                Aresta aresta;

                while (heap.hasNext()) {
                        aresta = heap.extractMorePriority();
                        if (!formaCiclo(florestas, aresta)
                                        && !quebrarRestricaoGrauMaximo(florestas, aresta,
                                                        grauMaximo)) {
                                if(aresta.getCusto() == Double.MAX_VALUE) {
                                        return null;
                                }
                                adicionarAresta(florestas, aresta);
                        }
                }

                return g.extrairArvore(florestas.get(0));
        }

        private boolean quebrarRestricaoGrauMaximo(List<List<Aresta>> florestas,
                        Aresta aresta, int grauMaximo) {
                int qtdV1 = 0, qtdV2 = 0;

                for (List<Aresta> arvore : florestas) {
                        for (Aresta a : arvore) {
                                if (RelacaoEquivalencia.hasVertice1Equivalente(aresta, a)) {
                                        qtdV1++;
                                }

                                if (RelacaoEquivalencia.hasVertice2Equivalente(aresta, a)) {
                                        qtdV2++;
                                }
                        }
                        if (qtdV1 >= grauMaximo || qtdV2 >= grauMaximo) {
                                return true;
                        } else {
                                qtdV1 = 0;
                                qtdV2 = 0;
                        }
                }
                return false;
        }

        private boolean formaCiclo(List<List<Aresta>> florestas, Aresta aresta) {
                boolean v1, v2, resultado;
                v1 = v2 = resultado = false;

                for (List<Aresta> arvore : florestas) {
                        for (Aresta a : arvore) {

                                if (RelacaoEquivalencia.hasVertice1Equivalente(aresta, a)) {
                                        v1 = true;
                                }
                                if (RelacaoEquivalencia.hasVertice2Equivalente(aresta, a)) {
                                        v2 = true;
                                }
                        }

                        if (v1 && v2) {
                                resultado = true;
                                break;
                        } else {
                                v1 = v2 = false;
                        }
                }
                return resultado;
        }

        private void adicionarAresta(List<List<Aresta>> florestas, Aresta aresta) {
                List<Aresta> arvoreNova = new LinkedList<Aresta>();
                List<List<Aresta>> remover = new LinkedList<List<Aresta>>();

                arvoreNova.add(aresta);

                for (List<Aresta> arvore : florestas) {
                        for (Aresta a : arvore) {

                                if (RelacaoEquivalencia.hasPeloMenosUmVerticeEquivalente(
                                                aresta, a)) {
                                        remover.add(arvore);
                                        break;
                                }
                        }
                }

                List<Aresta> arvore;
                for (int i = 0; i < remover.size(); i++) {
                        arvore = remover.get(i);
                        arvoreNova.addAll(arvore);
                        florestas.remove(arvore);
                }

                florestas.add(arvoreNova);
        }
}