package com.rsginer.algorithmsdatastructures;

public class BinaryTree {
    NodeTree root;

    public BinaryTree(NodeTree root) {
        this.root = root;
    }

    public BinaryTree() {
        this.root = null;
    }

    @Override
    public String toString() {
        return "BinaryTree { \n" +
                "root=" + root +
                "\n }";
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
                    aux = aux.rightChild;

                    if (aux == null) {
                        dad.rightChild = node;
                        return;
                    }
                }
            }
        }
    }
}
