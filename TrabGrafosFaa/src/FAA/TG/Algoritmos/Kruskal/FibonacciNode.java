/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FAA.TG.Algoritmos.Kruskal;

/**
 *
 * @author diego
 */
public class FibonacciNode<Type> implements HeapNode<Type> {

        private Type datum;

        private FibonacciNode<Type> father;

        private FibonacciNode<Type> child;

        private FibonacciNode<Type> left;

        private FibonacciNode<Type> right;

        private int degree;

        private boolean mark = false;

        public FibonacciNode() {

        }

        public FibonacciNode(Type datum) {
                this.datum = datum;
        }

        public Type getDatum() {
                return datum;
        }

        public void setDatum(Type datum) {
                this.datum = datum;
        }

        public FibonacciNode<Type> getFather() {
                return father;
        }

        public void setFather(FibonacciNode<Type> father) {
                this.father = father;
        }

        public FibonacciNode<Type> getChild() {
                return child;
        }

        public void setChild(FibonacciNode<Type> child) {
                this.child = child;
        }

        public FibonacciNode<Type> getLeft() {
                return left;
        }

        public void setLeft(FibonacciNode<Type> left) {
                this.left = left;
        }

        public FibonacciNode<Type> getRight() {
                return right;
        }

        public void setRight(FibonacciNode<Type> right) {
                this.right = right;
        }

        public int getDegree() {
                return degree;
        }

        public void incDegree() {
                this.degree++;
        }

        public void setDegree(int degree) {
                this.degree = degree;
        }

        public boolean isMark() {
                return mark;
        }

        public void setMark(boolean mark) {
                this.mark = mark;
        }

        @SuppressWarnings("unchecked")
        @Override
        public int compareTo(HeapNode<Type> o) {
                return ((Comparable<Type>) datum).compareTo(o.getDatum());
        }

        @Override
        public String toString() {
                return "Dado: " + datum + " | G: " + degree;
        }
}

