/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FAA.TG.Entrada;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Parser {
    
    public Parser(File selectedFile) {
        String linha = null;
        try {
            // instancia do arquivo que vou ler  
            FileReader reader = new FileReader(selectedFile);
            BufferedReader leitor = new BufferedReader(reader);

            // loop que percorrerá todas as  linhas do arquivo.txt que eu quero ler  
            while ((linha = leitor.readLine()) != null) {
                //No metodo StringTokenizer passo os parametros que quero ler, em seguida o que eu quero descartar no meu caso ( - ) e ( ; ).   
                StringTokenizer st = new StringTokenizer(linha, "{}");
                // Aqui determino que enquanto existir tokens que ele faça a leitura  
                String dados = st.nextToken();
                System.out.print(dados);
                System.out.println("");
            }
            leitor.close();
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    
    public void ParserBFSDFS(){
        
        
    }

    public void ParserDijkstra() throws FileNotFoundException, IOException {

    }
}
