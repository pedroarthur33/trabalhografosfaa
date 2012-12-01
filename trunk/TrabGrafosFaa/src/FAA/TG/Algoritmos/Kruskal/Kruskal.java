/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FAA.TG.Algoritmos.Kruskal;

import FAA.TG.Algoritmos.Grafos.Grafo;
import FAA.TG.Algoritmos.Grafos.Grafo.Aresta;

/**
 *
 * @author Eduardo
 * 
 * Cria uma arvore geradora minima, com as arestas e menor pesos do grafo.
 * Exemplo em   http://pt.wikipedia.org/wiki/Algoritmo_de_Kruskal
 * Exemplo de empilhar em http://www.slideshare.net/briansupra/kruskal-3127658
 */
public class Kruskal {

    private Grafo grafo;
    
    public Kruskal(Grafo grafo){
        this.grafo = grafo;
    }
    
    
    /**
     *
     */
    public ArvoreGeradoraMinima(){
    ConjuntoDisjunto conj = new ConjuntoDisjunto ( ) ;
    int S  = 0;
    for ( int v = 0; v < grafo.getNumVertices() ; v++) conj.criaConjunto (v);
    //Ordena as arestas de A pelo peso ;
    for(cada(u, v) de A tomadas em ordem ascendente de peso)
        if( conj.encontraConjunto(u) != conj.encontraConjunto(v) )
                S = S + {(u, v)};
                conj.uniao(u, v);
    }
    
    
    //
    private void empilhaarestas() throws Exception{
        
        int n = this.grafo.getNumVertices();
        FilaArestas nova = new FilaArestas();
        /*
        for (int i = 0; i <= n+1; i++){
            Aresta temp = grafo.primeiroListaAdj(i);
            if(temp.getPeso() == 1){
                nova.enfileira(temp);
            }
            
        }*/     
        int[][] teste = grafo.getMat();
        int peso = 0;
        for (int i = 0; i < grafo.getNumVertices(); i++) {
            for (int j = 0; j < grafo.getNumVertices(); j++) {
                if (teste[i][j] == peso){
                    nova.enfileira(new Aresta(j, j, peso));
                }
            }
            peso++;
        }
                
                
    }
    
    
}