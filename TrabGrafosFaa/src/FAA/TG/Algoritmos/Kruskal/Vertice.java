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
 * Classe que representa um vértice. A classe vai conter apenas a posição
 * carteziana x e y do vertice.
 * 
 */
public class Vertice {

        /**
         * Identificador numúrico do vértice.
         */
        private int id;

        /**
         * Posição carteziana X
         */
        private int x;

        /**
         * Posição carteziana Y
         */
        private int y;

        private int degree;

        /**
         * Constroi um vértice especificando a sua posição carteziana.
         * 
         * @param int x
         * @param int y
         */
        public Vertice(int id, int x, int y) {
                this.degree = 0;
                this.id = id;
                this.x = x;
                this.y = y;
        }

        /**
         * Constroi um vértice especificando a sua posição carteziana.
         * 
         * @param String
         *            x
         * @param String
         *            y
         */
        public Vertice(Double id, Double x, Double y) {
                this.id = id.intValue();
                this.x = x.intValue();
                this.y = y.intValue();
        }

        /**
         * Calcula a distância Euclidiana entre dois vertices.
         * 
         * @param v1
         *            Vertice de partida.
         * @param v2
         *            Vertice de chegada.
         * @return Distância entre os vertices.
         */
        public static double calcularDistanciaEuclidiana(Vertice v1, Vertice v2) {

                double x1 = v1.getX();
                double y1 = v1.getY();
                double x2 = v2.getX();
                double y2 = v2.getY();

                return Math.sqrt(((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)));
        }

        /**
         * 
         * @return Posição carteziana x.
         */
        public int getX() {
                return x;
        }

        /**
         * 
         * @return Posição carteziana y.
         */
        public int getY() {
                return y;
        }

        public int getDegree() {
                return degree;
        }

        /**
         * 
         * @return Identificador do vertice.
         */
        public int getId() {
                return id;
        }

        public void incDegree() {
                degree++;
        }

        @Override
        public Object clone() {
                Vertice v = new Vertice(getId(), getX(), getY());
                v.degree = this.degree;
                return v;
        }

        public void decDegree() {
                degree--;
        }

        public void setDegree(int degree) {
                this.degree = degree;

        }
}
