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
            if (aux.data > data) {
                aux = aux.leftChild;
            } else {
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

    public boolean removeNode(int data) {
        NodeTree aux = this.root;
        NodeTree dad = this.root;
        boolean isLeftChild = true;

        while(aux.data != data) {
            dad = aux;

            if (data < aux.data) {
                isLeftChild = true;
                aux = aux.leftChild;
            } else {
                isLeftChild = false;
                aux = aux.rightChild;
            }

            if (aux == null) {
                return false;
            }
        }

        if (aux.leftChild == null && aux.rightChild == null) {
            if (aux == this.root) {
                this.root = null;
            } else if (isLeftChild) {
                dad.leftChild = null;
            } else {
                dad.rightChild = null;
            }
        } else if (aux.rightChild == null) {
            if (aux == this.root) {
                this.root = aux.leftChild;
            } else if (isLeftChild) {
                dad.leftChild = aux.leftChild;
            } else {
                dad.rightChild = aux.leftChild;
            }
        } else if (aux.leftChild == null) {
            if (aux == this.root) {
                this.root = aux.rightChild;
            } else if (isLeftChild) {
                dad.leftChild = aux.rightChild;
            } else {
                dad.rightChild = aux.leftChild;
            }
        } else {
            NodeTree replace = getReplaceNode(aux);

            if (aux == root) {
                this.root = replace;
            } else if (isLeftChild) {
                dad.leftChild = replace;
            } else {
                dad.rightChild = replace;
            }

            replace.leftChild = aux.leftChild;
        }

        return true;
    }

    public NodeTree getReplaceNode(NodeTree replaceNode) {
        NodeTree replaceDad = replaceNode;
        NodeTree replace = replaceNode;
        NodeTree aux = replaceNode.rightChild;

        while (aux != null) {
            replaceDad = replace;
            replace = aux;
            aux = aux.leftChild;
        }

        if (replace != replaceNode.rightChild) {
            replaceDad.leftChild = replace.rightChild;
            replace.rightChild = replaceNode.rightChild;
        }

        return replace;
    }

    @Override
    public String toString() {
        return "BinaryTree { \n" +
                "root=" + root +
                "\n }";
    }
}
