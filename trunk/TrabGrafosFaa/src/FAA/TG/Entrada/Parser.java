/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FAA.TG.Entrada;

import FAA.TG.Algoritmos.Grafos.Grafo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Parser {
    
    int [][] matriz = null;
    
    public Parser(File selectedFile) {
        String linha = null;
        String[] temp = null;
        try {
            // instancia do arquivo que vou ler  
            FileReader reader = new FileReader(selectedFile);
            BufferedReader leitor = new BufferedReader(reader);
            int i = 0;
            int j = 0;
            // loop que percorrerá todas as  linhas do arquivo.txt que eu quero ler  
            while ((linha = leitor.readLine()) != null) {
                
                //No metodo StringTokenizer passo os parametros que quero ler, em seguida o que eu quero descartar no meu caso ( - ) e ( ; ).   
                StringTokenizer st = new StringTokenizer(linha, "{}");
                int tamanho = st.countTokens();
                // Aqui determino que enquanto existir tokens que ele faça a leitura  
                String dados = st.nextToken();
                System.out.print(dados);
                temp = dados.split("\\,");
                if (matriz == null) {matriz = new int[temp.length][temp.length];}
                for(j = 0; j < temp.length; j++){
                    matriz[i][j] = Integer.parseInt(temp[j]);
                }
                j = 0;
                i++;
                System.out.println("");
            }
            leitor.close();
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    
    public void ParserBFSDFS(Grafo grafo){
        
        int i ;
        int j;
        for(i = 0 ;i < matriz.length; i++){
            for(j =0; j <matriz.length; j++){
                if (matriz[i][j] != 0){
                    grafo.insereAresta(i, j, 0);
                }
            }
            j = 0;
        }
        System.out.println("");
    }

    public void ParserDijkstra() throws FileNotFoundException, IOException {

    }

    public int[][] getMatriz() {
        return matriz;
    }
    
}
