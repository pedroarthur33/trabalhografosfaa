/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FAA.TG.Algoritmos.Kruskal;

/**
 *
 * @author diego
 */
public class Resultado {

        private double tempo;

        private double custo;

        public Resultado(double tempo, double custo) {
                this.tempo = tempo;
                this.custo = custo;
        }

        public double getTempo() {
                return tempo;
        }

        public void setTempo(double tempo) {
                this.tempo = tempo;
        }

        public double getCusto() {
                return custo;
        }

        public void setCusto(double custo) {
                this.custo = custo;
        }
}
