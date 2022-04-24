package edu.datastructures.Trees.Tree23;

public class Node23<T extends Comparable<T>, R> {
    private Item<T, R> item0, item1;
    private Node23<T, R> parent, node0, node1, node2;
    private int childNum;

    public void setItem(Item<T, R> item) {
        if (item0 == null) {
            item0 = item;
        } else {
            if (item0.getKey().compareTo(item.getKey()) <= 0) {
                item1 = item;
            } else {
                item1 = item0;
                item0 = item;
            }
        }
    }

    public void setNode(Node23<T, R> node) {
        int num = node.getChildNum();
        if (num == 2) {
            node2 = node;
        } else {
            if (num == 1) {
                if (node1 != null) {
                    node2 = node1;
                    node2.setChildNum(2);
                }
                node1 = node;
            } else
                node0 = node;
        }
        node.setParent(this);
    }

    public Item<T, R> getItem0() {
        return item0;
    }

    public void setItem0(Item<T, R> item0) {
        this.item0 = item0;
    }

    public Item<T, R> getItem1() {
        return item1;
    }

    public void setItem1(Item<T, R> item1) {
        this.item1 = item1;
    }

    public Node23<T, R> getNode0() {
        return node0;
    }

    public void setNode0(Node23<T, R> node0) {
        this.node0 = node0;
    }

    public Node23<T, R> getNode1() {
        return node1;
    }

    public void setNode1(Node23<T, R> node1) {
        this.node1 = node1;
    }

    public Node23<T, R> getNode2() {
        return node2;
    }

    public void setNode2(Node23<T, R> node2) {
        this.node2 = node2;
    }

    public int getChildNum() {
        return childNum;
    }

    public void setChildNum(int childNum) {
        this.childNum = childNum;
    }

    public Node23<T, R> getParent() {
        return parent;
    }

    public void setParent(Node23<T, R> parent) {
        this.parent = parent;
    }
}

