/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FAA.TG.Algoritmos.Kruskal;

import java.util.LinkedList;
import java.util.List;

/**
 * Esta classe dever� ser usada com classe pai de todos os m�todos que se prop�e
 * solucionar o problema da �rvore Geradora M�nima.
 * 
 */
public abstract class GeradorArvoreMinima {

        /**
         * Grafo ao qual se deseja obter a sua arvore geradora m�nima.
         */
        private Grafo grafo;

        /**
         * Constante que define o par�metro de valor Ilimitado para o m�todo de
         * gera��o (gerar). Pode ser aplicado em qualquer um dos par�metros:
         * -grauMaximo: A �rvore pode conter vertices com qualquer grau;
         * -qtdArvores: Ser�o geradas tantas arvores quando poss�veis de acordo com
         * os outros par�metros; -custoMaximo: N�o haver� limite superior de custo
         * da arvore gerada.
         */
        public static final int ILIMITADO = Integer.MAX_VALUE;

        /**
         * Constroi uma inst�ncia do gerador de arvore que ir� executar sobre o
         * grafo passado.
         * 
         * @param g
         *            Grafo onde ser� aplicado o algoritmo.
         */
        public GeradorArvoreMinima(Grafo g) {
                this.grafo = g;
        }

        /**
         * Controi uma lista com as árvores geradoras mínimas de todos os grafos que
         * atendem aos critérios de busca.
         * 
         * @param grauMaximo
         *            Número máximo que um vértice pode possuir;
         * @param qtdArvores
         *            Quantidade de árvores máximas a ser gerada.
         * @param custoMaximo
         *            Custo máximo que a árvore pode ter.
         * @return Uma lista contendo as arvores geradas.
         */

        public final List<Retorno> gerar(int grauMaximo, int qtdArvores, double custoMaximo) {
                List<Retorno> lista = new LinkedList<Retorno>();

                Grafo g = (Grafo) grafo.clone();
                Grafo agm;
                Resultado r;
                double inicio, fim;

                for (int i = 0; i < qtdArvores; i++) {
                        inicio = System.currentTimeMillis();
                        agm = gerar(g, grauMaximo, custoMaximo);
                        if(agm == null) {
                                break;
                        }
                        fim = System.currentTimeMillis();

                        r = new Resultado((fim - inicio), agm.getCustoTotal());
                        lista.add(new Retorno(agm, r));

                        if ((i + 1) < qtdArvores) {
                                Aresta a = agm.getArestaMaiorCusto();
                                g.removerAresta(a);

                                if (g.isDesconexo()) {
                                        break;
                                }
                        }
                }

                return lista;
        }

        /**
         * Escrever a implementação específica de cada gerador.
         * 
         * @param g
         * @param grauMaximo
         * @param custoMaximo
         * @return
         */
        protected abstract Grafo gerar(Grafo g, int grauMaximo, double custoMaximo);

        /**
         * Forma simplificada de gerar uma árvore. Por aqui será obtida a melhor
         * arvore geradora mínima dada pelo algoritmo.
         * 
         * @return melhor arvore geradora mínima do algoritmo.
         */
        public final Retorno gerar() {
                return gerar(ILIMITADO, 1, ILIMITADO).get(0);
        }

        public static Aresta[] gerarArranjo(Double[][] matriz) {
                Aresta[] arranjo = new Aresta[matriz.length * matriz.length];

                for (int i = 0; i < matriz.length; i++) {
                        for (int j = 0; j < matriz.length; j++) {
                                arranjo[i * matriz.length + j] = new Aresta(i, j, matriz[i][j]);
                        }
                }
                return arranjo;
        }

        protected Grafo getGrafo() {
                return this.grafo;
        }
}