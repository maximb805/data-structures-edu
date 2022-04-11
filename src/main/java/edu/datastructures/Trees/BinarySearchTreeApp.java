package edu.datastructures.Trees;

import java.time.LocalDate;

public class BinarySearchTreeApp<T extends Comparable<T>, R> {
    private Node<T, R> root;

    public BinarySearchTreeApp() {
        root = null;
    }

    public void insert(T id, R data) {
        Node<T, R> newNode = new Node<>(id, data);
        if (root == null)
            root = newNode;
        else {
            Node<T, R> current = root;
            while (true) {
                if (id.compareTo(current.getKey()) >= 0) {
                    if (current.getRight() != null)
                        current = current.getRight();
                    else
                        break;
                } else {
                    if (current.getLeft() != null)
                        current = current.getLeft();
                    else
                        break;
                }
            }
            if (id.compareTo(current.getKey()) >= 0)
                current.setRight(newNode);
            else
                current.setLeft(newNode);
        }
    }

    public Node<T, R> find(T id) {
        if (!isEmpty()) {
            Node<T, R> current = root;
            while (id.compareTo(current.getKey()) != 0) {
                if (id.compareTo(current.getKey()) > 0)
                    current = current.getRight();
                else
                    current = current.getLeft();
                if(current == null) {
                    System.out.println("Element with key " + id + " not found");
                    return null;
                }
            }
            return current;
        } else {
            System.out.println("Tree is empty");
            return null;
        }
    }

    private Node<T, R> getPrev(Node<T, R> current) throws TreeException{
        if (current != root && current != null) {
            Node<T, R> prev = root;
            while (prev.getRight().getKey().compareTo(current.getKey()) != 0 &&
                    prev.getLeft().getKey().compareTo(current.getKey()) != 0) {
                if (current.getKey().compareTo(prev.getKey()) > 0)
                    prev = prev.getRight();
                else
                    prev = prev.getLeft();
                }
            return prev;
        } else {
            throw new TreeException("Current node is root or null");
        }
    }

    public Node<T, R> delete(T id) throws TreeException{
        Node<T, R> delNode = find(id);
        if (delNode != null) {
            try {
                if (delNode.getLeft() == null && delNode.getRight() == null) {
                    if (delNode == root) {
                        root = null;
                    } else {
                        if (delNode == getPrev(delNode).getLeft()) {
                            getPrev(delNode).setLeft(null);
                        } else {
                            getPrev(delNode).setRight(null);
                        }
                    }
                } else {
                    if (delNode.getLeft() == null) {
                        if (delNode == root) {
                            root = delNode.getRight();
                        } else {
                            getPrev(delNode).setRight(delNode.getRight());
                        }
                    } else {
                        if (delNode.getRight() == null) {
                            if (delNode == root) {
                                root = delNode.getLeft();
                            } else {
                                getPrev(delNode).setLeft(delNode.getLeft());
                            }
                        } else {
                            Node<T, R> replacer = delNode.getRight();
                            while (replacer.getLeft() != null) {
                                replacer = replacer.getLeft();
                            }
                            if (replacer != getPrev(replacer).getRight()) {
                                getPrev(replacer).setLeft(replacer.getRight());
                                replacer.setRight(delNode.getRight());
                            }
                            replacer.setLeft(delNode.getLeft());
                            if (delNode == root) {
                                root = replacer;
                            } else {
                                if (delNode == getPrev(delNode).getLeft()) {
                                    getPrev(delNode).setLeft(replacer);
                                } else {
                                    getPrev(delNode).setRight(replacer);
                                }
                            }
                        }
                    }
                }
                return delNode;
            } catch (TreeException ex) {
                throw new TreeException(ex.getMessage());
            }
        } else {
            return null;
        }
    }

    public Node<T, R> maximum() {
        if(!isEmpty()) {
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
        if(!isEmpty()) {
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

    public void traversal() {
        inOrder(root);
    }

    private void inOrder(Node<T, R> localRoot) {
        if(localRoot == null) {
            return;
        }
        inOrder(localRoot.getLeft());
        localRoot.displayNode();
        inOrder(localRoot.getRight());
    }

    public boolean isEmpty() {
        return root == null;
    }

    public Node<T, R> getRoot() {
        return root;
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
        tree.traversal();
        System.out.println();
        tree.maximum().displayNode();
        tree.minimum().displayNode();
        System.out.println();
        try {
            tree.delete(82);
            tree.traversal();
            System.out.println();
        } catch (TreeException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static Person addPerson(String firstName, String surname, LocalDate dateOfBirth) {
        Person person = new Person();
        person.setFirstName(firstName);
        person.setSurname(surname);
        person.setDateOfBirth(dateOfBirth);
        return person;
    }
}