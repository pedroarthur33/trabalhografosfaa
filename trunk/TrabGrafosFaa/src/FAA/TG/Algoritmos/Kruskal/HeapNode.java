/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FAA.TG.Algoritmos.Kruskal;

/**
 *
 * @author diego
 */
public interface HeapNode<Type> extends Comparable<HeapNode<Type>> {

        public Type getDatum();
}
