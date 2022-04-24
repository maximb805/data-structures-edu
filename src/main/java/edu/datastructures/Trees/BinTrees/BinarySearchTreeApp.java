package edu.datastructures.Trees.BinTrees;

import java.time.LocalDate;

public class BinarySearchTreeApp<T extends Comparable<T>, R> {
    private Node<T, R> root;

    public BinarySearchTreeApp() {
        root = null;
    }

    public void insert(T key, R data) {
        Node<T, R> newNode = new Node<>(key, data);
        if (root == null)
            root = newNode;
        else {
            Node<T, R> current = root;
            while (true) {
                if (key.compareTo(current.getKey()) >= 0) {
                    if (current.getRight() != null)
                        current = current.getRight();
                    else {
                        current.setRight(newNode);
                        break;
                    }
                } else {
                    if (current.getLeft() != null)
                        current = current.getLeft();
                    else {
                        current.setLeft(newNode);
                        break;
                    }
                }
            }
        }
    }

    public void insertRight(Node<T, R> parent, Node<T, R> child) {
        if (root != null) {
            parent.setRight(child);
        } else
            System.out.println("Tree is empty");
    }

    public void insertLeft(Node<T, R> parent, Node<T, R> child) {
        if (root != null) {
            parent.setLeft(child);
        } else
            System.out.println("Tree is empty");
    }

    public void insert(Node<T, R> newNode) {
        if (root == null)
            root = newNode;
        else {
            Node<T, R> current = root;
            while (true) {
                if (newNode.getKey().compareTo(current.getKey()) >= 0) {
                    if (current.getRight() != null)
                        current = current.getRight();
                    else {
                        current.setRight(newNode);
                        break;
                    }
                } else {
                    if (current.getLeft() != null)
                        current = current.getLeft();
                    else {
                        current.setLeft(newNode);
                        break;
                    }
                }
            }
        }
    }

    public Node<T, R> find(T key) {
        if (!isEmpty()) {
            Node<T, R> current = root;
            while (key.compareTo(current.getKey()) != 0) {
                if (key.compareTo(current.getKey()) > 0)
                    current = current.getRight();
                else
                    current = current.getLeft();
                if (current == null) {
                    return null;
                }
            }
            return current;
        } else {
            return null;
        }
    }

    public Node<T, R> getParent(Node<T, R> current) {
        if (current != root && current != null) {
            Node<T, R> prev = root;
            while (prev.getRight() != current && prev.getLeft() != current) {
                if (current.getKey().compareTo(prev.getKey()) > 0)
                    prev = prev.getRight();
                else
                    prev = prev.getLeft();
            }
            return prev;
        } else {
            System.out.println("Current node is root or null");
            return null;
        }
    }

    public Node<T, R> delete(T key) {
        Node<T, R> parent = root;
        Node<T, R> delNode = root;
        while (delNode != null && key.compareTo(delNode.getKey()) != 0) {
            if (key.compareTo(delNode.getKey()) < 0) {
                parent = delNode;
                delNode = delNode.getLeft();
            } else {
                parent = delNode;
                delNode = delNode.getRight();
            }
        }
        if (delNode != null) {
            if (delNode.getLeft() == null && delNode.getRight() == null) {
                if (delNode == root) {
                    root = null;
                } else {
                    if (delNode == parent.getLeft()) {
                        parent.setLeft(null);
                    } else {
                        parent.setRight(null);
                    }
                }
            } else {
                if (delNode.getLeft() == null) {
                    if (delNode == root) {
                        root = delNode.getRight();
                    } else {
                        parent.setRight(delNode.getRight());
                    }
                } else {
                    if (delNode.getRight() == null) {
                        if (delNode == root) {
                            root = delNode.getLeft();
                        } else {
                            parent.setLeft(delNode.getLeft());
                        }
                    } else {
                        Node<T, R> replacer = delNode.getRight();
                        Node<T, R> replacerParent = delNode;
                        while (replacer.getLeft() != null) {
                            replacerParent = replacer;
                            replacer = replacer.getLeft();
                        }
                        if (replacer != delNode.getRight()) {
                            replacerParent.setLeft(replacer.getRight());
                            replacer.setRight(delNode.getRight());
                        }
                        replacer.setLeft(delNode.getLeft());
                        if (delNode == root) {
                            root = replacer;
                        } else {
                            if (delNode == parent.getLeft()) {
                                parent.setLeft(replacer);
                            } else {
                                parent.setRight(replacer);
                            }
                        }
                    }
                }
            }
            return delNode;
        } else {
            System.out.println("Element with key " + key + " not found");
            return null;
        }
    }

    public Node<T, R> maximum() {
        if (!isEmpty()) {
            Node<T, R> current = root;
            while (current.getRight() != null) {
                current = current.getRight();
            }
            return current;
        } else {
            System.out.println("Tree is empty");
            return null;
        }
    }

    public Node<T, R> minimum() {
        if (!isEmpty()) {
            Node<T, R> current = root;
            while (current.getLeft() != null) {
                current = current.getLeft();
            }
            return current;
        } else {
            System.out.println("Tree is empty");
            return null;
        }
    }

    public void traverseInOrd() {
        inOrder(root);
    }

    public void traversePreOrd() {
        preOrder(root);
    }

    public void traversePostOrd() {
        postOrder(root);
    }

    private void inOrder(Node<T, R> localRoot) {
        if (localRoot == null) {
            return;
        }
        inOrder(localRoot.getLeft());
        localRoot.displayNode();
        inOrder(localRoot.getRight());
    }

    private void preOrder(Node<T, R> localRoot) {
        if (localRoot == null) {
            return;
        }
        localRoot.displayNode();
        preOrder(localRoot.getLeft());
        preOrder(localRoot.getRight());
    }

    private void postOrder(Node<T, R> localRoot) {
        if (localRoot == null) {
            return;
        }
        postOrder(localRoot.getLeft());
        postOrder(localRoot.getRight());
        localRoot.displayNode();
    }

    public boolean isEmpty() {
        return root == null;
    }

    public Node<T, R> getRoot() {
        return root;
    }

    @Override
    public String toString() {
        return "BinarySearchTreeApp{" +
                "root=" + root +
                '}';
    }
}

class BinarySearchTreeAppUser {
    public static void main(String[] args) {
        BinarySearchTreeApp<Integer, Person> tree = new BinarySearchTreeApp<>();
        tree.insert(50, addPerson("Todd", "Howard", LocalDate.of(1971, 4, 25)));
        tree.insert(25, addPerson("Mark", "Zuckerberg", LocalDate.of(1984, 5, 14)));
        tree.insert(75, addPerson("Edward", "Norton", LocalDate.of(1969, 8, 18)));
        tree.insert(13, addPerson("Max", "Payne", LocalDate.of(1977, 2, 4)));
        tree.insert(38, addPerson("Dave", "Rodgers", LocalDate.of(1963, 2, 23)));
        tree.insert(63, addPerson("Daniel", "Craig", LocalDate.of(1968, 3, 2)));
        tree.insert(87, addPerson("Mike", "Tyson", LocalDate.of(1966, 6, 30)));
        tree.insert(81, addPerson("John", "Wick", LocalDate.of(1964, 9, 2)));
        tree.insert(93, addPerson("Peter", "Parker", LocalDate.of(1975, 6, 27)));
        tree.insert(6, addPerson("Michael", "Jackson", LocalDate.of(1958, 8, 29)));
        tree.insert(19, addPerson("Benson", "Payne", LocalDate.of(1979, 6, 17)));
        System.out.println("In order: ");
        tree.traverseInOrd();
        System.out.println("\nPre order: ");
        tree.traversePreOrd();
        System.out.println("\nPost order: ");
        tree.traversePostOrd();
        System.out.println();
        System.out.println("Max key value: ");
        tree.maximum().displayNode();
        System.out.println("Min key value: ");
        tree.minimum().displayNode();
        System.out.println();
        tree.delete(87);
        tree.traverseInOrd();
        System.out.println("\nParent of element with key 63: ");
        tree.getParent(tree.find(63)).displayNode();
    }

    public static Person addPerson(String firstName, String surname, LocalDate dateOfBirth) {
        Person person = new Person();
        person.setFirstName(firstName);
        person.setSurname(surname);
        person.setDateOfBirth(dateOfBirth);
        return person;
    }
}