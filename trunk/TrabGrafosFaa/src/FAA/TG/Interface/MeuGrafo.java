/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FAA.TG.Interface;

/**
 *
 * Classe Demo para criação e visualização de Grafos usando o prefuse
 *
 * @author Samuel FÃ©lix
 *
 *
 *
 */
public class MeuGrafo {

    //Amigos aqui
    private String[] amigos = {"Diego", "Eduardo", "Fernando", "Denise", "Guga", "Douglas", "Fabio", "Armandinho"};
    //Pessoas famosas aqui
    private String[] famosos = {"Dijk", "Tannen", "Linu", "Richard", "Bill", "C.S.Lewi"};

    public MeuGrafo(String nomeDoMeuGrafo) {

        criarNodos();
        criarArestas();
        criaArquivo(nomeDoMeuGrafo);
    }

    /**
     * Finaliza e cria o XML
     */
    private void criaArquivo(String nomeDoMeuGrafo) {
        GenerateXML.fechaArquivo();
        GenerateXML.salvarXML(nomeDoMeuGrafo);
    }

    /**
     * Criamos os nodos, veja que especificamos um id para cada nodo,
     * esse id ira identificar o ator quando criarmos as arestas
     * criei um criterio para dizer o genero do ator
     */
    private void criarNodos() {

        //Vamos criar os nodos dos "amigos"
        for (int i = 0; i < amigos.length; i++) {
            GenerateXML.generateNodes(i * 100 + 1, amigos[i], i % 2 == 0 ? "M" : "F");
        }

        //Vamos criar os nodos dos "famosos"
        for (int i = 0; i < famosos.length; i++) {
            GenerateXML.generateNodes(i * 100 + 5, famosos[i], "M");
        }
    }

    /*
     * Neste metodo "ligamos" todos os amigos a todos os famosos.
     * Mas obviamente isso e algo ilustrativo.
     */
    private void criarArestas() {
        
        for (int i = 0; i < amigos.length; i++) {
            for (int j = 0; j < famosos.length; j++) {
                GenerateXML.generateEdges(i * 100 + 1, j * 100 + 5);
            }
        }
    }

    public static void main(String[] args) {

        //Cria o XML
        new MeuGrafo("grafo.xml");
        //Cria a Visualização Apontando o XML criado
//        new VisualisadorDeGrafo("grafo.xml");
    }
}