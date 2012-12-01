/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FAA.TG.Algoritmos.Kruskal;

/**
 *
 * @author diego
 */

/**
 * Classe para tratar as relações de equivalências entre vertices e arestas.
 * 
 */
public abstract class RelacaoEquivalencia {

        public static boolean hasPeloMenosUmVerticeEquivalente(Aresta a, Aresta b) {
                return (b.getVertice1() == a.getVertice1()
                                || b.getVertice1() == a.getVertice2()
                                || b.getVertice2() == a.getVertice1() || b.getVertice2() == a
                                .getVertice2());
        }

        public static boolean hasVertice1Equivalente(Aresta a, Aresta b) {
                return (a.getVertice1() == b.getVertice1() || a.getVertice1() == b
                                .getVertice2());
        }

        public static boolean hasVertice2Equivalente(Aresta a, Aresta b) {
                return (a.getVertice2() == b.getVertice1() || a.getVertice2() == b
                                .getVertice2());
        }

        public static boolean ehArestaEquivalente(Aresta a, Aresta b) {
                return (a.getVertice1() == b.getVertice1() && a.getVertice2() == b
                                .getVertice2())
                                || (a.getVertice1() == b.getVertice2() && a.getVertice2() == b
                                                .getVertice1());
        }
}
