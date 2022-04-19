package edu.datastructures.Trees.Tree234;

public class Node234<T extends Comparable<T>, R> {
    private Item<T, R> item0, item1, item2;
    private Node234<T, R> parent, node0, node1, node2, node3;
    private int childNum;

    public void setItem(Item<T, R> item) {
        if (item0 == null) {
            item0 = item;
        } else {
            if (item1 == null) {
                if (item0.getKey().compareTo(item.getKey()) <= 0) {
                    item1 = item;
                } else {
                    item1 = item0;
                    item0 = item;
                }
            } else {
                if (item1.getKey().compareTo(item.getKey()) <= 0) {
                    item2 = item;
                } else {
                    if (item0.getKey().compareTo(item.getKey()) <= 0) {
                        item2 = item1;
                        item1 = item;
                    } else {
                        item2 = item1;
                        item1 = item0;
                        item0 = item;
                    }
                }
            }
        }
    }

    public void setNode(Node234<T, R> node) {
        int num = node.getChildNum();
        if (num == 3) {
            node3 = node;
        } else {
            if (num == 2) {
                if (node2 != null) {
                    node2.setChildNum(3);
                    node3 = node2;
                }
                node2 = node;
            } else {
                if (num == 1) {
                    if (node2 != null) {
                        node2.setChildNum(3);
                        node3 = node2;
                    }
                    if (node1 != null) {
                        node1.setChildNum(2);
                        node2 = node1;
                    }
                    node1 = node;
                } else {
                    node0 = node;
                }
            }
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

    public Item<T, R> getItem2() {
        return item2;
    }

    public void setItem2(Item<T, R> item2) {
        this.item2 = item2;
    }

    public Node234<T, R> getNode0() {
        return node0;
    }

    public void setNode0(Node234<T, R> node0) {
        this.node0 = node0;
    }

    public Node234<T, R> getNode1() {
        return node1;
    }

    public void setNode1(Node234<T, R> node1) {
        this.node1 = node1;
    }

    public Node234<T, R> getNode2() {
        return node2;
    }

    public void setNode2(Node234<T, R> node2) {
        this.node2 = node2;
    }

    public Node234<T, R> getNode3() {
        return node3;
    }

    public void setNode3(Node234<T, R> node3) {
        this.node3 = node3;
    }

    public int getChildNum() {
        return childNum;
    }

    public void setChildNum(int childNum) {
        this.childNum = childNum;
    }

    public Node234<T, R> getParent() {
        return parent;
    }

    public void setParent(Node234<T, R> parent) {
        this.parent = parent;
    }
}
