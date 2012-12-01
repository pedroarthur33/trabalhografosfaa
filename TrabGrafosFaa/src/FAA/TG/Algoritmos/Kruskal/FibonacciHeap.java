/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FAA.TG.Algoritmos.Kruskal;

import java.util.List;

/**
 *
 * @author diego
 */
public class FibonacciHeap<Type> extends Heap<Type> {

        private FibonacciNode<Type> morePriority;

        private int numNodes;

        private final int D = 100;

        public FibonacciHeap(Heap.Priority p) {
                super(p);
                morePriority = null;
                numNodes = 0;
        }

        public FibonacciHeap(Heap.Priority p, List<Type> list) {
                this(p);
                for (Type element : list) {
                        insert(element);
                }
        }

        public FibonacciHeap(Heap.Priority p, Type[] array) {
                this(p);
                for (Type element : array) {
                        insert(element);
                }
        }

        @Override
        public void delete(Type element) {
                // NÃO SERÁ NECESSÁRIO...

        }

        @Override
        public Type extractMorePriority() {
                FibonacciNode<Type> node = morePriority;
                //System.out.println("Entrada: MorePriority: " + node);

                if (node != null) {
                        FibonacciNode<Type> child = node.getChild();

                        if (child != null) {
                                do {
                                        child.setFather(null);
                                        child = child.getLeft();
                                } while (child != node.getChild());

                                FibonacciNode<Type> left = child.getLeft();

                                if (node.getLeft() != node) {
                                        child.setLeft(node.getLeft());
                                        node.getLeft().setRight(child);
                                        left.setRight(node.getRight());
                                        node.getRight().setLeft(left);
                                }

                                morePriority = child;
                        } else {
                                if (node.getLeft() == node) {
                                        morePriority = child;
                                } else {
                                        node.getLeft().setRight(node.getRight());
                                        node.getRight().setLeft(node.getLeft());
                                        morePriority = node.getLeft();
                                }
                        }
                        consolidate();
                        numNodes--;
                }
                return (node != null ? node.getDatum() : null);
        }

        @Override
        public void insert(Type element) {
                FibonacciNode<Type> node = new FibonacciNode<Type>(element);
                node.setDegree(0);

                if (morePriority == null) {
                        morePriority = node;
                        node.setLeft(node);
                        node.setRight(node);
                } else {
                        node.setLeft(morePriority.getLeft());
                        node.setRight(morePriority);
                        morePriority.setLeft(node);
                        node.getLeft().setRight(node);
                        if (isBest(node, morePriority)) {
                                morePriority = node;
                        }
                }
                numNodes++;
        }

        @Override
        public void union(Heap<Type> another) throws IllegalArgumentException {
                //NÃO SERÁ NECESSÁRIO

        }

        @Override
        public Type seeMorePriority() {
                return morePriority.getDatum();
        }

        @SuppressWarnings("unchecked")
        private void consolidate() {

                if (morePriority != null) {

                        FibonacciNode<Type>[] auxiliar = new FibonacciNode[D];
                        FibonacciNode<Type> x = morePriority;
                        FibonacciNode<Type> y;
                        FibonacciNode<Type> temp;
                        int grau;

                        do {
                                //System.out.println("X vale: " + x);
                                grau = x.getDegree();
                                while (auxiliar[grau] != null) {
                                        y = auxiliar[grau];
                                        if (isBest(y, x)) {
                                                temp = x;
                                                x = y;
                                                y = temp;
                                        }

                                        if (y == morePriority) {
                                                morePriority = x;
                                        }
                                        link(y, x);
                                        auxiliar[grau] = null;
                                        grau++;
                                }
                                auxiliar[grau] = x;
                                x = x.getLeft();
                        } while (x != auxiliar[x.getDegree()]);

                        FibonacciNode<Type> inicio = morePriority;
                        temp = inicio.getLeft();
                        while (temp != inicio) {
                                if (isBest(temp, morePriority)) {
                                        morePriority = temp;
                                }
                                temp = temp.getLeft();
                                //System.out.println("morePriority");
                        }
                }

        }

        private void link(FibonacciNode<Type> y, FibonacciNode<Type> x) {
                // REMOVE Y DA LISTA DE RAIZES.
                y.getLeft().setRight(y.getRight());
                y.getRight().setLeft(y.getLeft());
                // TORNA Y FILHO DE X.
                if (x.getChild() == null) {
                        x.setChild(y);
                        y.setLeft(y);
                        y.setRight(y);
                } else {
                        y.setRight(x.getChild().getRight());
                        y.getRight().setLeft(y);
                        y.setLeft(x.getChild());
                        x.getChild().setRight(y);
                }
                y.setFather(x);
                x.incDegree();
                y.setMark(false);
                //System.out.println("Tornou " + y + " filho de " + x);

        }

        @Override
        public boolean hasNext() {
                return (numNodes > 0);
        }
}