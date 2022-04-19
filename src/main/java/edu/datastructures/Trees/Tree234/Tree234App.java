package edu.datastructures.Trees.Tree234;


import java.util.Arrays;

public class Tree234App<T extends Comparable<T>, R> {
    private Node234<T, R> root;

    public Tree234App() {
        root = null;
    }

    public void insert(T key, R data) {
        Item<T, R> newItem = new Item<>(key, data);
        if (isEmpty()) {
            root = new Node234<>();
            root.setItem0(newItem);
            Node234<T, R> node0 = new Node234<>();
            Node234<T, R> node1 = new Node234<>();
            node0.setChildNum(0);
            node1.setChildNum(1);
            root.setNode0(node0);
            root.setNode1(node1);
            node0.setParent(root);
            node1.setParent(root);
        } else {
            Node234<T, R> currentNode = root;
            while (true) {
                if (currentNode != null) {
                    if (currentNode.getItem2() != null) {
                        split(currentNode);
                        currentNode = currentNode.getParent();
                        continue;
                    }
                    if (currentNode.getNode0() == null) {
                        currentNode.setItem(newItem);
                        break;
                    } else {
                        if (currentNode.getItem0() != null
                                && key.compareTo(currentNode.getItem0().getKey()) < 0) {
                            currentNode = currentNode.getNode0();
                        } else {
                            if (currentNode.getItem1() != null
                                    && key.compareTo(currentNode.getItem1().getKey()) < 0) {
                                currentNode = currentNode.getNode1();
                            } else {
                                currentNode = currentNode.getItem1() == null ?
                                        currentNode.getNode1() : currentNode.getNode2();
                            }
                        }
                    }
                }
            }
        }
    }

    public void split(Node234<T, R> currentNode) {
        if (currentNode.getParent() == null) {
            Node234<T, R> parent = new Node234<>();
            root = parent;
            currentNode.setChildNum(0);
            currentNode.setParent(parent);
            parent.setNode(currentNode);
        }
        Node234<T, R> currentNodeBro = new Node234<>();
        currentNodeBro.setChildNum(currentNode.getChildNum() + 1);

        currentNodeBro.setItem(currentNode.getItem2());
        currentNode.setItem2(null);

        currentNode.getParent().setItem(currentNode.getItem1());
        currentNode.setItem1(null);

        currentNode.getParent().setNode(currentNodeBro);

        if (currentNode.getNode0() != null) {
            currentNode.getNode2().setChildNum(0);
            currentNodeBro.setNode(currentNode.getNode2());
            currentNode.setNode2(null);

            currentNode.getNode3().setChildNum(1);
            currentNodeBro.setNode(currentNode.getNode3());
            currentNode.setNode3(null);
        }
    }

    public Item<T, R> find(T key) {
        if (!isEmpty()) {
            Node234<T, R> currentNode = root;
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
                            continue;
                        }
                        if (currentNode.getItem2() != null) {
                            thisKey = currentNode.getItem2().getKey();
                            if (key.compareTo(thisKey) <= 0) {
                                if (thisKey.compareTo(key) == 0)
                                    return currentNode.getItem2();
                                currentNode = currentNode.getNode2();
                            } else
                                currentNode = currentNode.getNode3();
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

    public boolean isEmpty() {
        return root == null;
    }

    public Node234<T, R> getRoot() {
        return root;
    }
}

class Tree234AppUser {
    public static void main(String[] args) {
        Tree234App<Integer, Character> tree = new Tree234App<>();
        int[] intArr = new int[1000];
        for (int i = 0; i < intArr.length; ) {
            int r = (int) (Math.random() * 5000);
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
            tree.insert(intArr[i], (char) (i + 'A'));
        }
        tree.insert(500, 'V');
        System.out.println(tree.find(500).toString());
        System.out.println(tree.find((int) (Math.random() * 5000)).toString());
    }
}

