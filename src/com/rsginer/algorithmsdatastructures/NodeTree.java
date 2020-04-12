package com.rsginer.algorithmsdatastructures;

public class NodeTree implements PrintableNode{
    int data;
    NodeTree leftChild;
    NodeTree rightChild;
    String name;

    public NodeTree(int d, String name) {
        this.data = d;
        this.name = name;
        this.leftChild = null;
        this.rightChild = null;
    }

    @Override
    public PrintableNode getLeft() {
        return this.leftChild;
    }

    @Override
    public PrintableNode getRight() {
        return this.rightChild;
    }

    @Override
    public String getText() {
        return this.name + ' ' + this.data;
    }
}
