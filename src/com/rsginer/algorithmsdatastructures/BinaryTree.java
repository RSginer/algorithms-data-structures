package com.rsginer.algorithmsdatastructures;

public class BinaryTree {
    NodeTree root;

    public BinaryTree(NodeTree root) {
        this.root = root;
    }

    public BinaryTree() {
        this.root = null;
    }


    public void add(int d, String name) {
        NodeTree node = new NodeTree(d, name);

        if (this.root == null) this.root = node;
        else {
            NodeTree aux = this.root;
            NodeTree dad;

            while (true) {
                dad = aux;

                // Go to left child
                if (d < aux.data) {
                    aux = aux.leftChild;

                    if (aux == null) {
                        dad.leftChild = node;
                        return;
                    }
                } else {
                    // Go to right child
                    aux = aux.rightChild;

                    if (aux == null) {
                        dad.rightChild = node;
                        return;
                    }
                }
            }
        }
    }

    public void inOrder(NodeTree root) {
        if (root != null) {
            this.inOrder(root.leftChild);
            this.inOrder(root.rightChild);
        }
    }

    public boolean isEmpty () {
        return this.root == null;
    }

    @Override
    public String toString() {
        return "BinaryTree { \n" +
                "root=" + root +
                "\n }";
    }
}
