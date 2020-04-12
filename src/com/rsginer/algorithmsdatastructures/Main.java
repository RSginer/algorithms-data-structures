package com.rsginer.algorithmsdatastructures;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;


public class Main {

    public static void main(String[] args) {

        /* QuickSort test
        int[] arr = {1, 5, 6, 3, 2, 9, 8, 7};
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }

        QuickSort quickSort = new QuickSort();
        int[] orderedIntArr = quickSort.sortIntArray(arr);
        List<Integer> orderedList = quickSort.sortIntegerList(list, 0, orderedIntArr.length - 1);

        for (int i = 0; i < orderedList.size(); i++) {
            System.out.println(orderedList.get(i));
        } */

        int option = 0;
        int element;
        String name;
        BinaryTree tree = new BinaryTree();

        do {
            try {
                option = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Add node \n 2. Read tree \n 3. Search node \n 4. Exit \n Choose an option"));
                switch (option) {
                    case 1:
                        name = JOptionPane.showInputDialog(null, "Node name", "Adding node");
                        element = Integer.parseInt(JOptionPane.showInputDialog(null, "Node number", "Adding node"));
                        tree.add(element, name);
                        break;
                    case 2:
                        if (!tree.isEmpty()) {
                            tree.inOrder(tree.root, new Consumer<NodeTree>() {
                                @Override
                                public void accept(NodeTree nodeTree) {
                                    System.out.println(nodeTree.data);
                                }
                            });
                        } else {
                            System.out.println("Is empty");
                        }
                    case 3:
                        if (!tree.isEmpty()) {
                            int data;
                            data = Integer.parseInt(JOptionPane.showInputDialog(null, "Node number to search", "Adding node"));
                            NodeTree node = tree.searhNode(data);
                            if (node != null) {
                                System.out.println(node);
                            } else {
                                System.out.println("Not found");
                            }
                        } else {
                            System.out.println("Is empty");
                        }
                    default:
                        option = 4;
                        break;
                }
            } catch (NumberFormatException n) {
                System.out.println(n.getMessage());
            }
        } while (option != 4);

    }



}
