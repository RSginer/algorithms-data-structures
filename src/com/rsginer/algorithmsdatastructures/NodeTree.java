package com.rsginer.algorithmsdatastructures;

public class NodeTree {
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
    public String toString() {
        return "NodeTree { \n" +
                "data=" + data +
                "\n , leftChild=" + leftChild +
                "\n, rightChild=" + rightChild +
                "\n, name='" + name + '\'' +
                "\n }";
    }
}
