/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FAA.TG.Interface;

import FAA.TG.Algoritmos.Grafos.Grafo;
import FAA.TG.Algoritmos.Largura.BuscaEmLargura;
import FAA.TG.Entrada.Parser;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class Main {
    public static void main(String[] args){
        File arq = new File("");
        Parser parser = new Parser(arq);
        Grafo grafo;
        grafo = new Grafo(parser.getMatriz().length,parser.getMatriz().length);
        parser.ParserBFSDFS(grafo);
        //grafo.imprime();
        BuscaEmLargura largura = new BuscaEmLargura(grafo);
        try {
            largura.visitaBfs(grafo.getNumVertices(), grafo.getCab());
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
