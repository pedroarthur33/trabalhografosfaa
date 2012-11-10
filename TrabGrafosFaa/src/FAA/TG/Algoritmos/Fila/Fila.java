package FAA.TG.Algoritmos.Fila;


public class Fila {
	
  private Integer item[];
  private Integer    frente, tras;
  
  // Operações 
  public Fila () { // Cria uma fila vazia
    this.item = new Integer[100];
    this.frente = 0;
    this.tras = this.frente;
  }
  
  public Fila (Integer maxTam) { // Cria uma fila vazia
    this.item = new Integer[maxTam];
    this.frente = 0;
    this.tras = this.frente;
  }
  
  public void enfileira (Integer x) throws Exception {
    if ((this.tras + 1) % this.item.length == this.frente)
      throw new Exception ("Erro: A fila esta cheia");
    
    this.item[this.tras] = x;
    this.tras = (this.tras + 1) % this.item.length;
  }
  
  public Integer desenfileira () throws Exception {
    if (this.vazia ())
      throw new Exception ("Erro: A fila esta vazia");
    
    Integer item = this.item[this.frente];
    this.frente = (this.frente + 1) % this.item.length;
    return item;
  }
  
  public boolean vazia () {
    return (this.frente == this.tras);
  }
  
  public Integer tamanho(){
      return this.tras;
  }
  
  public void imprime () {
    for (int i = this.frente; i != this.tras; i = (i + 1) % this.item.length)
      System.out.print("[" + this.item[i] + "]");
    System.out.println("");
  }
}