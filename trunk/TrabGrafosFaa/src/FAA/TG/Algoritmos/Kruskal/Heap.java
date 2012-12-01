/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FAA.TG.Algoritmos.Kruskal;

/**
 *
 * @param <Type>
 */
public abstract class Heap<Type> {

    private boolean isMinimum;

    public enum Priority {

        MAX, MIN
    }

    public Heap(Priority p) {
        isMinimum = (p == Priority.MIN);
    }

    public abstract void insert(Type element);

    public abstract Type seeMorePriority();

    public abstract Type extractMorePriority();

    public abstract void delete(Type element);

    public abstract void union(Heap<Type> another) throws IllegalArgumentException;

    protected boolean isBest(HeapNode<Type> best, HeapNode<Type> worst) {
        return (best.compareTo(worst) >= 0) ^ isMinimum;
    }

    public abstract boolean hasNext();
}
