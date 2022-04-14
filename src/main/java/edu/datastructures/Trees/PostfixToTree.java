package edu.datastructures.Trees;

import edu.datastructures.Lists.Link;
import edu.datastructures.Lists.TwoDirectedListApp;
import edu.datastructures.Lists.TwoSidedLinkedListApp;

public class PostfixToTree {
    static BinarySearchTreeApp<Integer, Character> tree;
    static TwoDirectedListApp<BinarySearchTreeApp<Integer, Character>> treeList;

    public static void postfixToTree(String expression) {
        treeList = new TwoDirectedListApp<>();
        expression = expression.replaceAll(" ", "");
        for (int i = 0; i < expression.length(); i++) {
            tree = new BinarySearchTreeApp<>();
            tree.insert(0, expression.charAt(i));
            treeList.insertLast(tree);
        }
        Link<BinarySearchTreeApp<Integer, Character>> link;
        link = treeList.getFirst();
        while (link != null) {
            if (link.getData().getRoot().getData() == '+' ||
                    link.getData().getRoot().getData() == '-' ||
                    link.getData().getRoot().getData() == '*' ||
                    link.getData().getRoot().getData() == '/') {
                link.getData().getRoot().setRight(link.getPrev().getData().getRoot());
                link.getData().getRoot().setLeft(link.getPrev().getPrev().getData().getRoot());
                treeList.removeCurrent(link.getPrev().getPrev());
                treeList.removeCurrent(link.getPrev());
            }
            link = link.getNext();
        }
        SymbolTree.treeList = new TwoSidedLinkedListApp<>();
        SymbolTree.treeList.insertFirst(treeList.getFirst().getData());
        SymbolTree.displayTree();
    }

    public static void getPrefix() {
        preOrder(treeList.getFirst().getData().getRoot());
        System.out.println();
    }

    public static void getInfix() {
        inOrder(treeList.getFirst().getData().getRoot());
        System.out.println();
    }

    public static void inOrder(Node<Integer, Character> localRoot) {
        if (localRoot == null) {
            return;
        }
        System.out.print("(");
        inOrder(localRoot.getLeft());
        System.out.print(localRoot.getData());
        inOrder(localRoot.getRight());
        System.out.print(")");
    }

    public static void preOrder(Node<Integer, Character> localRoot) {
        if (localRoot == null) {
            return;
        }
        System.out.print(localRoot.getData());
        preOrder(localRoot.getLeft());
        preOrder(localRoot.getRight());
    }

    public static void main(String[] args) {
        postfixToTree("ABC+*DE/FG-H+IJ*/+*");
        getPrefix();
        getInfix();
    }
}
