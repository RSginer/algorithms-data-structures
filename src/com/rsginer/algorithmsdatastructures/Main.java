package com.rsginer.algorithmsdatastructures;

import com.sun.source.tree.Tree;

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
        TreePrinter printer = new TreePrinter();

        do {
            try {
                option = Integer.parseInt(JOptionPane.showInputDialog(null, " 1. Add node \n 2. Read tree inOrder \n 3. Read tree postOrder \n 4. Read tree preOrder \n 5. Search node \n 6. Remove node \n 7. Exit \n\n Choose an option", JOptionPane.QUESTION_MESSAGE));
                switch (option) {
                    case 1:
                        name = JOptionPane.showInputDialog(null, "Node name", "Adding node", JOptionPane.QUESTION_MESSAGE);
                        element = Integer.parseInt(JOptionPane.showInputDialog(null, "Node number", "Adding node"));
                        tree.add(element, name);
                        break;
                    case 2:
                        System.out.println("InOrder");
                        if (!tree.isEmpty()) {
                            tree.inOrder(tree.root, new Consumer<NodeTree>() {
                                @Override
                                public void accept(NodeTree nodeTree) {
                                    System.out.print(nodeTree.data + ", ");
                                }
                            });
                            System.out.println(" ");
                            printer.print(tree.root);
                        } else {
                            System.out.println("Is empty");
                        }
                        break;
                    case 3:
                        System.out.println("postOrder");
                        if (!tree.isEmpty()) {
                            tree.postOrder(tree.root, new Consumer<NodeTree>() {
                                @Override
                                public void accept(NodeTree nodeTree) {
                                    System.out.print(nodeTree.data + ", ");
                                }
                            });
                            System.out.println(" ");
                            printer.print(tree.root);

                        } else {
                            System.out.println("Is empty");
                        }
                        break;
                    case 4:
                        System.out.println("preOrder");
                        if (!tree.isEmpty()) {
                            tree.preOrder(tree.root, new Consumer<NodeTree>() {
                                @Override
                                public void accept(NodeTree nodeTree) {
                                     System.out.print(nodeTree.data + ", ");
                                }
                            });
                            System.out.println(" ");
                            printer.print(tree.root);
                        } else {
                            System.out.println("Is empty");
                        }
                        break;
                    case 5:
                        if (!tree.isEmpty()) {
                            int data;
                            data = Integer.parseInt(JOptionPane.showInputDialog(null, "Node number to search", "Adding node"));
                            NodeTree node = tree.searhNode(data);
                            if (node != null) {
                                System.out.println();
                                printer.print(node);
                            } else {
                                System.out.println("Not found");
                            }
                        } else {
                            System.out.println("Is empty");
                        }
                        break;
                    case 6:
                        if (!tree.isEmpty()) {
                            int data;
                            data = Integer.parseInt(JOptionPane.showInputDialog(null, "Node number to remove", 0));
                            boolean removed = tree.removeNode(data);
                            System.out.println("Removed node with data " + data + " " + removed);
                        } else {
                            System.out.println("Is empty");
                        }
                        break;
                    default:
                        option = 7;
                        break;
                }
            } catch (NumberFormatException n) {
                System.out.println(n.getMessage());
            }
        } while (option != 7);

    }



}
