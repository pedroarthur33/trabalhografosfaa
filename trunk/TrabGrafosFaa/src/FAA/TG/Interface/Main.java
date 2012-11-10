/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FAA.TG.Interface;

import FAA.TG.Algoritmos.Dijkstra.Dijkstra;
import FAA.TG.Algoritmos.Grafos.Grafo;
import FAA.TG.Algoritmos.Largura.BuscaEmLargura;
import FAA.TG.Algoritmos.Profundidade.BuscaEmProfundidade;
import FAA.TG.Entrada.Parser;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class Main {
    public static void main(String[] args) throws Exception{
        File arq = new File("Arquivo de teste/entrada.txt");
        Parser parser = new Parser(arq);
        Grafo grafo = parser.ParserBFSDFS();
        grafo.imprime();
        
        BuscaEmLargura largura = new BuscaEmLargura(grafo);
        largura.buscaEmLargura();
        
        System.out.println("");
        System.out.println("Busca em largura:");
        largura.imprimeCaminho(0, 4);
 
        System.out.println("");
        BuscaEmProfundidade p = new BuscaEmProfundidade(grafo);
        p.buscaEmProfundidade();
        System.out.println("Busca em profundidade:");
        p.imprimeCaminho(0, 4);
        
        System.out.println("");
        Dijkstra d = new Dijkstra(grafo);
        d.obterArvoreCMC(0);
        System.out.println("Dijkstra:");
        d.imprimeCaminho(0, 4);
        
    }    
}
