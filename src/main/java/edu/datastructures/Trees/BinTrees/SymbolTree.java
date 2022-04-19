package edu.datastructures.Trees.BinTrees;

import edu.datastructures.ListBasedStackAndQueues.LinkStack;
import edu.datastructures.Lists.TwoSidedLinkedListApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SymbolTree {
    static BinarySearchTreeApp<Integer, Character> tree;
    static TwoSidedLinkedListApp<BinarySearchTreeApp<Integer, Character>> treeList;

    public static void createUnbalancedTree(String input) {
        treeList = new TwoSidedLinkedListApp<>();
        for (int i = 0; i < input.length(); i++) {
            tree = new BinarySearchTreeApp<>();
            tree.insert(0, input.charAt(i));
            treeList.insertLast(tree);
        }
        while (true) {
            if (treeList.getFirst() == treeList.getLast()) {
                break;
            }
            treeList.insertFirst(createTree());
        }
        displayTree();
    }

    public static void createBalancedTree(String input) {
        treeList = new TwoSidedLinkedListApp<>();
        for (int i = 0; i < input.length(); i++) {
            tree = new BinarySearchTreeApp<>();
            tree.insert(0, input.charAt(i));
            treeList.insertLast(tree);
        }
        while (true) {
            if (treeList.getFirst() == treeList.getLast()) {
                break;
            }
            treeList.insertLast(createTree());
        }
        displayTree();
    }

    public static void createFilledTree(String input) {
        treeList = new TwoSidedLinkedListApp<>();
        tree = new BinarySearchTreeApp<>();
        fillNode(input,0, tree.getRoot());
        treeList.insertFirst(tree);
        displayTree();
    }

    public static void fillNode(String input, int nodeKey, Node<Integer, Character> thisNode) {
        Node<Integer, Character> node = new Node<>(nodeKey, input.charAt(nodeKey));
        if (nodeKey == 0) {
            tree.insert(node);
        } else {
            if (nodeKey % 2 == 1)
                tree.insertLeft(thisNode, node);
            else
                tree.insertRight(thisNode, node);
        }
        nodeKey = nodeKey * 2 + 1;
        if (nodeKey > input.length() - 1)
            return;
        fillNode(input, nodeKey, node);
        nodeKey++;
        if (nodeKey > input.length() - 1)
            return;
        fillNode(input, nodeKey, node);
    }

    public static BinarySearchTreeApp<Integer, Character> createTree() {
        BinarySearchTreeApp<Integer, Character> newTree = new BinarySearchTreeApp<>();
        Node<Integer, Character> node1 = treeList.deleteFirst().getData().getRoot();
        Node<Integer, Character> node2 = treeList.deleteFirst().getData().getRoot();
        newTree.insert(new Node<>(0, '+'));
        newTree.getRoot().setLeft(node1);
        newTree.getRoot().setRight(node2);
        return newTree;
    }

    public static void displayTree() {
        LinkStack<Node<Integer, Character>> globalStack = new LinkStack<>();
        globalStack.push(treeList.getFirst().getData().getRoot());
        int nBlanks = 64;
        boolean isRowEmpty = false;
        System.out.println(
                "......................................................" +
                        ".........................................................................");
        while (!isRowEmpty) {
            LinkStack<Node<Integer, Character>> localStack = new LinkStack<>();
            isRowEmpty = true;
            for (int j = 0; j < nBlanks; j++)
                System.out.print(' ');


            while (!globalStack.isEmpty()) {
                Node<Integer, Character> temp = globalStack.pop().getData();
                if (temp != null) {
                    System.out.print(temp.getData());
                    localStack.push(temp.getLeft());
                    localStack.push(temp.getRight());
                    if (temp.getLeft() != null ||
                            temp.getRight() != null)
                        isRowEmpty = false;
                } else {
                    System.out.print("-");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 1; j++)
                    System.out.print(' ');
            }


            System.out.println();
            nBlanks /= 2;
            while (!localStack.isEmpty())
                globalStack.push(localStack.pop().getData());
        }
        System.out.println(
                "......................................................" +
                        ".........................................................................");
    }

    public static void main(String[] args) {
        String input;
        while (true) {
            input = getString();
            if (input.equals(""))
                break;
//            createUnbalancedTree(input);
            createBalancedTree(input);
            createFilledTree(input);
        }
    }

    static String getString() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try {
            return br.readLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "";
    }
}
