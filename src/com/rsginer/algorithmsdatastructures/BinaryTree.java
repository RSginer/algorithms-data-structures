package com.rsginer.algorithmsdatastructures;

import java.util.function.Consumer;
import java.util.function.Function;

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

    public void inOrder(NodeTree root, Consumer<NodeTree> callback) {
        if (root != null) {
            this.inOrder(root.leftChild, callback);
            callback.accept(root);
            this.inOrder(root.rightChild, callback);
        }
    }

    public void preOrder(NodeTree root, Consumer<NodeTree> callback) {
        if (root != null) {
            callback.accept(root);
            this.inOrder(root.leftChild, callback);
            this.inOrder(root.rightChild, callback);
        }
    }

    public void postOrder(NodeTree root, Consumer<NodeTree> callback) {
        if (root != null) {
            this.inOrder(root.leftChild, callback);
            this.inOrder(root.rightChild, callback);
            callback.accept(root);
        }
    }

    public NodeTree searhNode(int data) {
        NodeTree aux = this.root;

        while (aux.data != data) {
            if (aux.data < data) {
                aux = aux.leftChild;
            }

            if (aux.data > data) {
                aux = aux.rightChild;
            }

            if (aux == null) {
                return null;
            }
        }

        return aux;
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
