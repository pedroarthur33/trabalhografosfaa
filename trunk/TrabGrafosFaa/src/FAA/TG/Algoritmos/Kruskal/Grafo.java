/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FAA.TG.Algoritmos.Kruskal;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Classe para representar um grafo. A forma de armazenamento desta informa��o �
 * a partir de uma matriz de custos, onde a primeira dimens�o indica o v�rtice
 * origem e a segunda o v�rtice destino.
 * 
 * @author juliano
 * 
 */
public class Grafo {

        /**
         * Defini��o do tipo de grafo de mesmo nome.
         */
        public static final int EUCLIDIANO = 0;

        /**
         * Defini��o do tipo de grafo de mesmo nome.
         */
        public static final int SIMETRICO = 1;

        /**
         * Matriz de custo do grafo. O quadrante [x][y] indica o custo da aresta que
         * liga x a y.
         */
        private Double[][] matrizCusto;

        /**
         * Lista de v�rtices que fazem parte do grafo.
         */
        private Vertice[] vertices;

        /**
         * Tipo de grafo, podendo ser EUCLIDIANO ou SIMETRICO
         */
        private int tipo;

        private Double custoTotal = null;

        /**
         * Constroi um grafo com nrVertices.
         * 
         * @param nrVertices
         *            Quantidade de v�rtices do grafo.
         */
        public Grafo(Vertice[] vertices, int tipo) {

                this.vertices = vertices;
                this.tipo = tipo;
                this.matrizCusto = new Double[vertices.length][vertices.length];
        }

        /**
         * Atribui o v�rtice a lista de v�rtices.
         * 
         * @param id
         *            Identificar do v�rtice, o qual corresponder� a sua posi��o no
         *            vetor.
         * @param v
         *            Vertice a ser inserido.
         */
        public void setVertice(int id, Vertice v) {
                vertices[id] = v;
        }

        /**
         * Obt�m o v�rtice com o identificar passado.
         * 
         * @param id
         *            Identificar dor v�rtice.
         * @return V�rtice correpondente ao identificar.
         */
        public Vertice getVertice(int id) {
                return vertices[id];
        }

        /**
         * Atribui o custo a aresta que liga vOrigem � vDestino.
         * 
         * @param vOrigem
         *            vertice origem
         * @param vDestino
         *            vertice destino.
         * @param custo
         *            custo da aresta.
         */
        public void setCusto(int vOrigem, int vDestino, double custo) {
                matrizCusto[vOrigem][vDestino] = custo;
        }

        /**
         * Obt�m o custo a aresta que liga vOrigem � vDestino.
         * 
         * @param vOrigem
         *            vertice origem
         * @param vDestino
         *            vertice destino.
         */
        public Double getCusto(int vOrigem, int vDestino) {
                return matrizCusto[vOrigem][vDestino];
        }

        /**
         * Obt�m o custo total (soma de todas as arestas). Ser� usado para o c�lculo
         * do valor do custo das �rvores geradoras m�nimas.
         * 
         * @return Custo total.
         */
        public double getCustoTotal() {
                if (this.custoTotal == null) {
                        custoTotal = 0d;
                        int qtdVertices = getNumeroVertices();
                        for (int i = 0; i < qtdVertices; i++) {
                                for (int j = i + 1; j < qtdVertices; j++) {
                                        custoTotal += (matrizCusto[i][j] == null ? 0
                                                        : matrizCusto[i][j]);
                                }
                        }
                }
                return custoTotal;
        }

        /**
         * @return n�mero de vertices do grafo.
         */
        public int getNumeroVertices() {
                return vertices.length;
        }

        /**
         * 
         * @return O tipo do grafo.
         */
        public int getTipo() {
                return tipo;
        }

        /**
         * Calcular os valores da matriz de custo, baseado na dist�ncia euclidiana
         * dos v�rtices.
         */
        public void calcularMatrizCustoEuclidiano() {

                for (int i = 0; i < vertices.length; i++) {
                        for (int j = i + 1; j < vertices.length; j++) {
                                matrizCusto[i][j] = Vertice.calcularDistanciaEuclidiana(
                                                vertices[i], vertices[j]);
                                matrizCusto[j][i] = matrizCusto[i][j];
                        }
                }
        }

        /**
         * 
         * @return Array de v�rtices do grafo.
         */
        public Vertice[] getVertices() {
                return vertices;
        }

        @Override
        public String toString() {
                String string = "";

                for (Vertice vertice : vertices) {
                        string += "Vertice " + vertice.getId() + ": ";
                        string += "X: " + vertice.getX() + " | ";
                        string += "Y: " + vertice.getY() + '\n';
                }

                string += "--------MATRIZ----------" + '\n';
                for (int i = 0; i < vertices.length; i++) {
                        for (int j = 0; j < vertices.length; j++) {
                                string += matrizCusto[i][j] + "| ";
                        }
                        string += '\n';
                }
                return string;
        }

        public Double[][] getMatrizCusto() {
                return matrizCusto;
        }

        public Aresta[] gerarArestas() {
                List<Aresta> arranjo = new LinkedList<Aresta>();
                for (int i = 0; i < matrizCusto.length; i++) {
                        for (int j = i + 1; j < matrizCusto.length; j++) {
                                double custo = (matrizCusto[i][j] == null ? Double.MAX_VALUE
                                                : matrizCusto[i][j]);
                                arranjo.add(new Aresta(i, j, custo));
                        }
                }
                return arranjo.toArray(new Aresta[1]);
        }

        public Grafo extrairArvore(List<Aresta> arestas) {

                Grafo result = new Grafo(this.getVertices(), this.getTipo());
                int i, j;

                for (int k = 0; k < arestas.size(); k++) {
                        i = arestas.get(k).getVertice1();
                        j = arestas.get(k).getVertice2();

                        result.setCusto(i, j, arestas.get(k).getCusto());
                        result.setCusto(j, i, arestas.get(k).getCusto());
                }

                return result;
        }

        public Grafo extrairArvoreFloresta(List<List<Aresta>> floresta) {

                Grafo result = new Grafo(this.getVertices(), this.getTipo());
                int i, j;
                Iterator<List<Aresta>> iter = floresta.iterator();
                Iterator<Aresta> arestas;
                Aresta a;
                
                while (iter.hasNext()) {
                        arestas = iter.next().iterator();

                        
                        while(arestas.hasNext()) {
                                a = arestas.next();
                                i = a.getVertice1();
                                j = a.getVertice2();

                                result.setCusto(i, j, a.getCusto());
                                result.setCusto(j, i, a.getCusto());
                        }
                }
                return result;
        }

        public void removerAresta(Aresta a) {

                matrizCusto[a.getVertice1()][a.getVertice2()] = null;
                matrizCusto[a.getVertice2()][a.getVertice1()] = null;

                vertices[a.getVertice1()].decDegree();
                vertices[a.getVertice2()].decDegree();
        }

        @Override
        public Object clone() {

                Vertice[] vertices = new Vertice[getVertices().length];

                for (int i = 0; i < getVertices().length; i++) {
                        vertices[i] = (Vertice) this.vertices[i].clone();
                }
                Grafo g = new Grafo(vertices, getTipo());

                for (int i = 0; i < vertices.length; i++) {
                        for (int j = 0; j < vertices.length; j++) {
                                g.matrizCusto[i][j] = this.matrizCusto[i][j];
                        }
                }

                g.custoTotal = null;
                return g;

        }

        public boolean isDesconexo() {

                for (Vertice v : vertices) {
                        if (v.getDegree() <= 0) {
                                return true;
                        }
                }

                return false;
        }

        public void atualizarGrau() {
                for (Vertice v : vertices) {
                        v.setDegree(0);
                }
                for (int i = 0; i < vertices.length; i++) {
                        for (int j = i + 1; j < vertices.length; j++) {
                                if (matrizCusto[i][j] != null) {
                                        vertices[i].incDegree();
                                        vertices[j].incDegree();
                                }
                        }
                }
        }

        public int getGrau(int vertice) {
                return vertices[vertice].getDegree();
        }

        public void incGrau(int vertice) {
                vertices[vertice].incDegree();
        }

        public Aresta getArestaMaiorCusto() {
                int v1, v2;
                Aresta inicial = getArestaValida();
                v1 = inicial.getVertice1();
                v2 = inicial.getVertice2();

                for (int i = 0; i < vertices.length; i++) {
                        for (int j = i + 1; j < vertices.length; j++) {
                                if (matrizCusto[i][j] != null
                                                && matrizCusto[i][j] > matrizCusto[v1][v2]) {
                                        v1 = i;
                                        v2 = j;
                                }
                        }
                }

                return new Aresta(v1, v2, matrizCusto[v1][v2]);
        }

        private Aresta getArestaValida() {
                for (int i = 0; i < vertices.length; i++) {
                        for (int j = i + 1; j < vertices.length; j++) {
                                if (matrizCusto[i][j] != null) {
                                        return new Aresta(i, j, matrizCusto[i][j]);
                                }
                        }
                }
                // NUNCA ACONTECE.
                return null;
        }

        public Grafo substituirAresta(Aresta remover, Aresta adicionar) {
                Grafo clone = (Grafo) this.clone();
                clone.matrizCusto[remover.getVertice1()][remover.getVertice2()] = null;
                clone.matrizCusto[adicionar.getVertice1()][adicionar.getVertice2()] = adicionar
                                .getCusto();

                return clone;
        }

        public Double resetCusto() {
                custoTotal = null;
                return getCustoTotal();
        }
}
