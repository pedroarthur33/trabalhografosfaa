/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FAA.TG.Algoritmos.Prim;

/**
 *
 * @author Eduardo
 */
import FAA.TG.Algoritmos.Kruskal.GeradorArvoreMinima;
import FAA.TG.Algoritmos.Kruskal.Grafo;
import FAA.TG.Algoritmos.Kruskal.Vertice;
import java.util.LinkedList;
import java.util.List;

public class Prim extends GeradorArvoreMinima {

        public Prim(Grafo g) {
                super(g);
        }

        @Override
        public Grafo gerar(Grafo g, int grauMaximo, double custoMaximo) {
                Grafo agm = null;

                if (g != null) {
                        double custoMenor = Double.MAX_VALUE;
                        double custo;
                        int vertice1, vertice2;
                        vertice1 = vertice2 = 0;
                        Vertice[] vs = g.getVertices();

                        agm = new Grafo(clone(vs), g.getTipo());
                        agm.atualizarGrau();

                        int qtdVertices = g.getNumeroVertices();

                        List<Integer> verticesDentro = new LinkedList<Integer>();
                        List<Integer> verticesFora = new LinkedList<Integer>();

                        for (int i = 1; i < qtdVertices; i++) {
                                verticesFora.add(i + 1);
                        }

                        verticesDentro.add(1);
                        int v1, v2;

                        for (int k = 0; k < qtdVertices - 1; k++) {

                                for (int i = 0; i < verticesDentro.size(); i++) {
                                        v1 = verticesDentro.get(i);

                                        if (agm.getGrau(v1 - 1) >= grauMaximo) {
                                                continue;
                                        }

                                        for (int j = 0; j < verticesFora.size(); j++) {
                                                v2 = verticesFora.get(j);

                                                custo = (g.getMatrizCusto()[v1 - 1][v2 - 1] == null ? Double.MAX_VALUE
                                                                : g.getMatrizCusto()[v1 - 1][v2 - 1]);

                                                if (custo < custoMenor) {
                                                        custoMenor = g.getMatrizCusto()[v1 - 1][v2 - 1];
                                                        vertice1 = v1;
                                                        vertice2 = v2;
                                                }
                                        }

                                }

                                if (custoMaximo < ILIMITADO
                                                && (agm.resetCusto() + custoMenor) > custoMaximo) {
                                        return agm;
                                } else {

                                        if(custoMenor == Double.MAX_VALUE) {
                                                return null;
                                        }

                                        agm.setCusto(vertice1 - 1, vertice2 - 1, custoMenor);
                                        agm.setCusto(vertice2 - 1, vertice1 - 1, custoMenor);
                                        agm.incGrau(vertice1 - 1);
                                        agm.incGrau(vertice2 - 1);

                                        custoMenor = Double.MAX_VALUE;
                                        verticesDentro.add(vertice2);
                                        verticesFora.remove(new Integer(vertice2));
                                }
                        }

                }

                agm.resetCusto();
                return agm;
        }

        private Vertice[] clone(Vertice[] vs) {
                Vertice[] vertices = new Vertice[vs.length];
                for (int i = 0; i < vs.length; i++) {
                        vertices[i] = (Vertice) vs[i].clone();
                }
                return vertices;
        }
}
