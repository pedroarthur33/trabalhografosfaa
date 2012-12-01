/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FAA.TG.Algoritmos.Kruskal;

/**
 *
 * @author diego
 */
public class Aresta implements Comparable<Aresta>{

        private int vertice1;

        private int vertice2;

        private double custo;

        public Aresta(int v1, int v2, Double custo) {
                this.vertice1 = v1;
                this.vertice2 = v2;
                this.custo = custo;
        }

        public int getVertice1() {
                return vertice1;
        }

        public void setVertice1(int vertice1) {
                this.vertice1 = vertice1;
        }

        public int getVertice2() {
                return vertice2;
        }

        public void setVertice2(int vertice2) {
                this.vertice2 = vertice2;
        }

        public double getCusto() {
                return custo;
        }

        public void setCusto(double custo) {
                this.custo = custo;
        }

        @Override
        public int compareTo(Aresta o) {
                return (o.custo>custo?1:-1);
        }

        @Override
        public String toString() {
                return "V1: " + vertice1 + "| V2: " + vertice2;
        }
}
