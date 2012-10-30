/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FAA.TG.Algoritmos.Grafos;

/**
 * @author diego
 */
public class Grafo {

    public static class Aresta {

        private int v1, v2, peso;

        public Aresta(int v1, int v2, int peso) {
            this.v1 = v1;
            this.v2 = v2;
            this.peso = peso;
        }

        public int getV1() {
            return v1;
        }

        public void setV1(int v1) {
            this.v1 = v1;
        }

        public int getV2() {
            return v2;
        }

        public void setV2(int v2) {
            this.v2 = v2;
        }

        public int getPeso() {
            return peso;
        }

        public void setPeso(int peso) {
            this.peso = peso;
        }

        
    }
    private int mat[][];// pesos do tipo inteiro
    private int numVertices;
    private int pos[];    // posição atual ao se percorrer os adjs de um vértice v

    public Grafo(int numVertices) {
        this.mat = new int[numVertices][numVertices];
        this.pos = new int[numVertices];
        this.numVertices = numVertices;
        for (int i = 0; i < this.numVertices; i++) {
            for (int j = 0; j < this.numVertices; j++) {
                this.mat[i][j] = 0;
            }
            this.pos[i] = -1;
        }
    }

    public void insereAresta(int v1, int v2, int peso) {
        this.mat[v1][v2] = peso;
    }

    public boolean existeAresta(int v1, int v2) {
        return (this.mat[v1][v2] > 0);
    }

    public boolean listaAdjVazia(int v) {
        for (int i = 0; i < this.numVertices; i++) {
            if (this.mat[v][i] > 0) {
                return false;
            }
        }
        return true;
    }

    // Retorna a primeira aresta que o vértice v participa ou
    // null se a lista de adjacência de v for vazia
    public Aresta primeiroListaAdj(int v) {

        this.pos[v] = -1;
        return this.proxAdj(v);
    }

    public Aresta proxAdj(int v) {
    // Retorna a próxima aresta que o vértice v participa ou
    // null se a lista de adjacência de v estiver no fim
        this.pos[v]++;
        while ((this.pos[v] < this.numVertices)
                && (this.mat[v][ this.pos[v]] == 0)) {
            this.pos[v]++;
        }
        if (this.pos[v] == this.numVertices) {
            return null;
        } else {
            return new Aresta(v, this.pos[v], this.mat[v][ this.pos[v]]);
        }
    }

    public Aresta retiraAresta(int v1, int v2) {
        if (this.mat[v1][v2] == 0) {
            return null; // Aresta não existe
        } else {
            Aresta aresta = new Aresta(v1, v2, this.mat[v1][v2]);
            this.mat[v1][v2] = 0;
            return aresta;
        }
    }

    public void imprime() {
        System.out.print(" ");
        for (int i = 0; i < this.numVertices; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < this.numVertices; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < this.numVertices; j++) {
                System.out.print(this.mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] getMat() {
        return mat;
    }

    public void setMat(int[][] mat) {
        this.mat = mat;
    }

    public int getNumVertices() {
        return numVertices;
    }

    public void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }

    public int[] getPos() {
        return pos;
    }

    public void setPos(int[] pos) {
        this.pos = pos;
    }   
}