package edu.datastructures.Trees.BinTrees;

import edu.datastructures.ListBasedStackAndQueues.LinkStack;


public class RedBlackTree<T extends Comparable<T>, R> {
    private RBNode<T, R> root;

    public RedBlackTree() {
        root = null;
    }

    public void insert(T key, R data) {
        RBNode<T, R> newNode = new RBNode<>(key, data);
        if (root == null) {
            root = newNode;
            root.setRed(false);
        } else {
            RBNode<T, R> parent = null;
            RBNode<T, R> current = root;
            while (true) {
                if (current.getLeft() != null && current.getRight() != null) {
                    if (current.getLeft().isRed() && current.getRight().isRed())
                        flip(current);
                    if (current.isRed() && parent.isRed())
                        checkRRConflict(current);
                }
                if (key.compareTo(current.getKey()) >= 0) {
                    parent = current;
                    if (current.getRight() != null) {
                        current = current.getRight();
                    } else {
                        current.setRight(newNode);
                        current = current.getRight();
                        current.setParent(parent);
                        break;
                    }
                } else {
                    parent = current;
                    if (current.getLeft() != null) {
                        current = current.getLeft();
                    } else {
                        current.setLeft(newNode);
                        current = current.getLeft();
                        current.setParent(parent);
                        break;
                    }
                }
            }
            if (!parent.isRed() || parent == root)
                return;
            else
                checkRRConflict(current);
        }
    }

    private void checkRRConflict(RBNode<T, R> current) {
        RBNode<T, R> parent = current.getParent();
        while (true) {
            RBNode<T, R> grandParent = parent.getParent();
            if (grandParent.getRight() == parent && parent.getRight() == current) {
                parent.setRed(false);
                grandParent.setRed(true);
                rollLeft(grandParent);
                if (parent == root)
                    parent.setRed(false);
                else if (parent.getParent().isRed()) {
                    current = parent;
                    parent = parent.getParent();
                    continue;
                }
            }
            if (grandParent.getLeft() == parent && parent.getLeft() == current) {
                parent.setRed(false);
                grandParent.setRed(true);
                rollRight(grandParent);
                if (parent == root)
                    parent.setRed(false);
                else if (parent.getParent().isRed()) {
                    current = parent;
                    parent = parent.getParent();
                    continue;
                }
            }
            if (grandParent.getLeft() == parent && parent.getRight() == current) {
                grandParent.setRed(true);
                current.setRed(false);
                rollLeft(parent);
                rollRight(grandParent);
                if (current == root)
                    current.setRed(false);
                else if (current.getParent().isRed()) {
                    parent = current.getParent();
                    continue;
                }
            }
            if (grandParent.getRight() == parent && parent.getLeft() == current) {
                grandParent.setRed(true);
                current.setRed(false);
                rollRight(parent);
                rollLeft(grandParent);
                if (current == root)
                    current.setRed(false);
                else if (current.getParent().isRed()) {
                    parent = current.getParent();
                    continue;
                }
            }
            break;
        }
    }

    public RBNode<T, R> find(T key) {
        if (!isEmpty()) {
            RBNode<T, R> current = root;
            while (true) {
                if (current == null) {
                    System.out.println("Element with key " + key + " not found");
                    return null;
                }
                if (key.compareTo(current.getKey()) > 0) {
                    current = current.getRight();
                    continue;
                }
                if (key.compareTo(current.getKey()) < 0) {
                    current = current.getLeft();
                    continue;
                }
                if (current.isDeleted())
                    current = current.getRight();
                else
                    break;
            }
            return current;
        } else {
            System.out.println("Tree is empty");
            return null;
        }
    }

    public boolean delete(T key) {
        RBNode<T, R> deleted = find(key);
        if (deleted == null)
            return false;
        else {
            deleted.setDeleted(true);
            return true;
        }
    }

    private void flip(RBNode<T, R> flipTop) {
        if (flipTop != root)
            flipTop.setRed(!flipTop.isRed());
        flipTop.getLeft().setRed(!flipTop.getLeft().isRed());
        flipTop.getRight().setRed(!flipTop.getRight().isRed());
    }

    public void rollLeft(RBNode<T, R> rollTop) {
        RBNode<T, R> rightChild = rollTop.getRight();
        if (rightChild == null) {
            System.out.println("Can't roll left");
            return;
        }
        if (rollTop != root) {
            RBNode<T, R> parent = rollTop.getParent();
            if (rollTop == parent.getLeft())
                parent.setLeft(rightChild);
            else
                parent.setRight(rightChild);
            rightChild.setParent(parent);
        } else {
            root = rightChild;
            rightChild.setParent(null);
        }
        RBNode<T, R> rcLeft = rightChild.getLeft();
        if (rcLeft != null)
            rcLeft.setParent(rollTop);
        rollTop.setRight(rcLeft);
        rightChild.setLeft(rollTop);
        rollTop.setParent(rightChild);
    }

    public void rollRight(RBNode<T, R> rollTop) {
        RBNode<T, R> leftChild = rollTop.getLeft();
        if (leftChild == null) {
            System.out.println("Can't roll left");
            return;
        }
        if (rollTop != root) {
            RBNode<T, R> parent = rollTop.getParent();
            if (rollTop == parent.getLeft())
                parent.setLeft(leftChild);
            else
                parent.setRight(leftChild);
            leftChild.setParent(parent);
        } else {
            root = leftChild;
            leftChild.setParent(null);
        }
        RBNode<T, R> lcRight = leftChild.getRight();
        if (lcRight != null)
            lcRight.setParent(rollTop);
        rollTop.setLeft(lcRight);
        leftChild.setRight(rollTop);
        rollTop.setParent(leftChild);
    }

    public void displayTree() {
        LinkStack<RBNode<T, R>> globalStack = new LinkStack<>();
        globalStack.push(root);
        int nBlanks = 128;
        boolean isRowEmpty = false;
        System.out.println(
                "......................................................" +
                        ".........................................................................");
        while (!isRowEmpty) {
            LinkStack<RBNode<T, R>> localStack = new LinkStack<>();
            isRowEmpty = true;
            for (int j = 0; j < nBlanks; j++)
                System.out.print(' ');


            while (!globalStack.isEmpty()) {
                RBNode<T, R> temp = globalStack.pop().getData();
                if (temp != null) {
                    char r;
                    if (temp.isRed()) {
                        r = 'r';
                    } else {
                        r = 'b';
                    }
                    System.out.print(r);
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

    public RBNode<T, R> getRoot() {
        return root;
    }

    public boolean isEmpty() {
        return root == null;
    }
}

class RedBlackTreeUser {
    public static void main(String[] args) {
        RedBlackTree<Integer, Character> tree = new RedBlackTree<>();
        tree.insert(1, 'A');
        tree.insert(2, 'B');
        tree.displayTree();

        tree.insert(3, 'C');
        tree.insert(4, 'D');
        tree.displayTree();

        tree.insert(5, 'E');
        tree.insert(6, 'F');
        tree.displayTree();

        tree.insert(7, 'G');
        tree.insert(8, 'H');
        tree.displayTree();

        tree.insert(9, 'I');
        tree.insert(10, 'J');
        tree.displayTree();

        tree.insert(11, 'K');
        tree.insert(12, 'L');
        tree.displayTree();

        tree.insert(13, 'G');
        tree.insert(14, 'H');
        tree.displayTree();

        tree.insert(15, 'I');
        tree.insert(16, 'J');
        tree.displayTree();

        tree.insert(17, 'K');
        tree.insert(18, 'L');
        tree.displayTree();

        int[] intArr = new int[50];
        for (int i = 0; i < intArr.length; ) {
            int r = (int) (Math.random() * 100);
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
        for (int i = 0; i < intArr.length; i++) {
            tree.insert(intArr[i], (char) (i + 'A'));
        }
        tree.displayTree();
        tree.insert(100, 'A');
        tree.insert(101, 'A');
        tree.insert(102, 'A');
        tree.insert(103, 'A');
        tree.displayTree();
        tree.find(100).displayNode();
        System.out.println(tree.delete(100));
        tree.find(100);
    }
}
