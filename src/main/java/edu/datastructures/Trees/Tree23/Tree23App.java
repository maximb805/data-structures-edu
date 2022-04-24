package edu.datastructures.Trees.Tree23;


import edu.datastructures.Trees.Tree234.Node234;

import java.util.Arrays;

public class Tree23App<T extends Comparable<T>, R> {
    Node23<T, R> root;
    int counter = 0;
    int[] arr = new int[1001];

    public Tree23App() {
        root = null;
    }

    public void insert(T key, R data) {
        Item<T, R> newItem = new Item<>(key, data);
        if (root == null) {
            root = new Node23<>();
            Node23<T, R> child0 = new Node23<>();
            Node23<T, R> child1 = new Node23<>();
            child0.setChildNum(0);
            child1.setChildNum(1);
            root.setNode0(child0);
            root.setNode1(child1);
            child0.setParent(root);
            child1.setParent(root);
            root.setItem0(newItem);
        } else {
            Node23<T, R> next = root;
            Node23<T, R> current = root;
            while (next != null) {
                current = next;
                next = chooseNode(current, key);
            }
            if (current.getItem1() != null)
                split(current, newItem);
            else {
                current.setItem(newItem);
            }
        }
    }

    private Node23<T, R> chooseNode(Node23<T, R> current, T itemKey) {
        if (current.getNode0() == null)
            return null;
        if (itemKey.compareTo(current.getItem0().getKey()) < 0) {
            return current.getNode0();
        } else {
            if (current.getItem1() == null || itemKey.compareTo(current.getItem1().getKey()) < 0) {
                return current.getNode1();
            } else {
                return current.getNode2();
            }
        }
    }

    private Node23<T, R> split(Node23<T, R> current, Item<T, R> newItem) {
        if (current.getItem1() == null) {
                current.setItem(newItem);
            return null;
        }
        Item<T, R> middle;
        if (newItem.getKey().compareTo(current.getItem0().getKey()) < 0) {
            middle = current.getItem0();
            current.setItem0(newItem);
        } else {
            if (newItem.getKey().compareTo(current.getItem1().getKey()) < 0) {
                middle = newItem;
            } else {
                middle = current.getItem1();
                current.setItem1(newItem);
            }
        }
        if (current == root) {
            root = new Node23<>();
            current.setParent(root);
            root.setNode0(current);
        }
        Node23<T, R> parentBro = split(current.getParent(), middle);

        Node23<T, R> currentBro = new Node23<>();
        Node23<T, R> parent = current.getParent();
            if (parentBro == null) {
                currentBro.setChildNum(current.getChildNum() + 1);
                parent.setNode(currentBro);
                currentBro.setParent(parent);
                currentBro.setItem(current.getItem1());
                current.setItem1(null);
            } else {
                if (current.getChildNum() == 0) {
                    currentBro.setChildNum(1);
                    parent.getNode1().setChildNum(0);
                    parent.getNode2().setChildNum(1);

                    parentBro.setNode0(parent.getNode1());
                    parentBro.setNode1(parent.getNode2());

                    parent.setNode1(currentBro);
                    parent.setNode2(null);
                    currentBro.setParent(parent);
                } else {
                    if (current.getChildNum() == 1) {
                        currentBro.setChildNum(0);
                        parent.getNode2().setChildNum(1);

                        parentBro.setNode0(currentBro);
                        parentBro.setNode1(parent.getNode2());
                    } else {
                        currentBro.setChildNum(1);
                        parent.getNode2().setChildNum(0);

                        parentBro.setNode0(parent.getNode2());
                        parentBro.setNode1(currentBro);
                    }
                    parent.setNode2(null);
                }
                parentBro.getNode0().setParent(parentBro);
                parentBro.getNode1().setParent(parentBro);
                currentBro.setItem0(current.getItem1());
                current.setItem1(null);
            }
        return currentBro;
    }

    public void traverse() {
        inOrder(root);
    }

    private void inOrder(Node23<T, R> node) {
        if (node == null)
            return;
        else {
            inOrder(node.getNode0());
        }
        if (node.getItem0() != null) {
            System.out.print(node.getItem0().getKey() + " ");
            arr[counter] = (Integer) node.getItem0().getKey();
            counter++;
            inOrder(node.getNode1());
            if (node.getItem1() != null) {
                System.out.print(node.getItem1().getKey() + " ");
                arr[counter] = (Integer)node.getItem1().getKey();
                counter++;
                inOrder(node.getNode2());
            }
        }
    }

    public Item<T, R> find(T key) {
        if (root != null) {
            Node23<T, R> currentNode = root;
            while (currentNode != null) {
                if (currentNode.getItem0() != null) {
                    T thisKey = currentNode.getItem0().getKey();
                    if (key.compareTo(thisKey) <= 0) {
                        if (thisKey.compareTo(key) == 0)
                            return currentNode.getItem0();
                        currentNode = currentNode.getNode0();
                        continue;
                    }
                    if (currentNode.getItem1() != null) {
                        thisKey = currentNode.getItem1().getKey();
                        if (key.compareTo(thisKey) <= 0) {
                            if (thisKey.compareTo(key) == 0)
                                return currentNode.getItem1();
                            currentNode = currentNode.getNode1();
                        } else
                            currentNode = currentNode.getNode2();
                    } else
                        currentNode = currentNode.getNode1();
                } else
                    break;
            }
            System.out.println("Item with key " + key + " not found");
        } else {
            System.out.println("Tree's empty");
        }
        return null;
    }

    public Node23<T, R> getRoot() {
        return root;
    }
}

class Tree23AppUser {
    public static void main(String[] args) {
        Tree23App<Integer, Character> tree23 = new Tree23App<>();
        int[] intArr = new int[1000];
        for (int i = 0; i < intArr.length; ) {
            int r = (int) (Math.random() * 10000);
            int j;
            for (j = 0; j < i; j++) {
                if (r == intArr[j])
                    break;
            }
            if (j == i) {
                intArr[i] = r;
                i++;
            }
        }
        System.out.println(Arrays.toString(intArr));
        for (int i = 0; i < intArr.length; i++) {
            tree23.insert(intArr[i], (char) (i + 'A'));
        }
        System.out.println(tree23.getRoot().getNode0().getItem0());
        tree23.insert(324, 'A');
        tree23.find(324);
        tree23.traverse();
        System.out.println();

        System.out.println(tree23.counter);
        for (int i = 1; i < tree23.arr.length; i++) {
            int r = tree23.arr[i] - tree23.arr[i-1];
            if (r < 0)
                System.err.println(r + "!!! ");
            else
                System.out.print(r + " ");
        }
        System.out.println();
        Item<Integer, Character> item = tree23.find(324);
        System.out.println(item);
    }
}