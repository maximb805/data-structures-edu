package edu.datastructures.HashTables;

import edu.datastructures.Trees.BinTrees.BinarySearchTreeApp;
import edu.datastructures.Trees.BinTrees.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HashChain<T> {
    private BinarySearchTreeApp<Integer, DataItem<T>>[] hashArray;
    private int hashConst;

    public HashChain(int size) {
        hashArray = new BinarySearchTreeApp[getPrime(size * 2)];
        for (int i = 0; i < hashArray.length; i++) {
            hashArray[i] = new BinarySearchTreeApp<>();
        }
        hashConst = getPrime(size);
    }

    private int hashFunc(int key) {
        return key % hashArray.length;
    }

    private int hashFunc2(int key) {
        return hashConst - (key % hashConst);
    }

    public DataItem<T> find(int key) {
        int hashVal = hashFunc(key);
        Node<Integer, DataItem<T>> node = hashArray[hashVal].find(key);
        return node == null ? null : node.getData();
    }

    public void insert(DataItem<T> dataItem) {
        int hashVal = hashFunc(dataItem.getKey());
        Node<Integer, DataItem<T>> node = hashArray[hashVal].find(dataItem.getKey());
        if (node != null) {
            System.out.println("Item with key " + dataItem.getKey() + " already defined in the table");
            return;
        }
        node = new Node<>(dataItem.getKey(), dataItem);
        hashArray[hashVal].insert(node);
    }

    public DataItem<T> delete(int key) {
        int hashVal = hashFunc(key);
        Node<Integer, DataItem<T>> node = hashArray[hashVal].delete(key);
        return node == null ? null : node.getData();
    }

    private int getPrime(int min) {
        if (min % 2 == 0)
            min += 1;
        int j;
        while (true) {
            for (j = 3; j * j < min; j++) {
                if (min % j == 0)
                    break;
            }
            if (j * j > min)
                break;
            else
                min += 2;
        }
        return min;
    }

    public void displayTable() {
        System.out.println("Table: ");
        for (int i = 0; i < hashArray.length - 1; i++) {
            if (hashArray[i] == null || hashArray[i].getRoot() == null)
                System.out.println((i + 1) + ": null");
            else {
                System.out.print((i + 1) + ": ");
                hashArray[i].traverseInOrd();
                System.out.println();
            }
        }
    }
}

class HashChainUser {
    public static void main(String[] args) {
        int checker = 0;
        while (checker != 1) {
            try {
                System.out.print("Enter hash table size (it'll be doubled): ");
                int size = getInt();
                HashChain<Integer> hash = new HashChain<>(size);

                System.out.print("Enter a number of random elements in table for start (can be 0): ");
                int[] array = new int[getInt()];
                for (int i = 0; i < array.length; ) {
                    int key = (int) (Math.random() * 10000);
                    int j;
                    for (j = 0; j < i; j++) {
                        if (array[j] == key)
                            break;
                    }
                    if (j == i) {
                        array[i] = key;
                        i++;
                    }
                }
                for (int i = 0; i < array.length; i++) {
                    hash.insert(new DataItem<>(array[i], (int) (Math.random() * 1000)));
                }
                System.out.println();
                checker++;
                while (true) {
                    try {
                        System.out.print("Enter first letter of " +
                                "\"show\", \"delete\", \"insert\", \"find\", or \"close\": ");
                        char command = getChar();
                        switch (command) {
                            case 's':
                                hash.displayTable();
                                System.out.println();
                                break;
                            case 'i':
                                System.out.print("Enter key (can't be < 0): ");
                                int iKey = getInt();
                                if (iKey < 0) {
                                    System.out.println("KEY CAN'T BE LESS THEN 0!\n");
                                    break;
                                }
                                System.out.print("Enter intData (-1 for random): ");
                                int data = getInt();
                                if (data == -1) {
                                    data = (int) (Math.random() * 1000);
                                }
                                hash.insert(new DataItem<>(iKey, data));
                                System.out.println();
                                break;
                            case 'f':
                                System.out.print("Enter key: ");
                                int fKey = getInt();
                                if (fKey < 0) {
                                    System.out.println("There's no negative keys in table\n");
                                    break;
                                }
                                DataItem<Integer> item = hash.find(fKey);
                                if (item == null)
                                    System.out.println("Item with key " + fKey + " not found.\n");
                                else
                                    System.out.println("Found: " + item + "\n");
                                break;
                            case 'd':
                                System.out.print("Enter key: ");
                                int del = getInt();
                                if (del < 0) {
                                    System.out.println("There's no negative keys in table\n");
                                    break;
                                }
                                DataItem<Integer> delItem = hash.delete(del);
                                if (delItem == null) {
                                    System.out.println("Item with key " + del + " not found.\n");
                                } else {
                                    System.out.println(delItem + " deleted\n");
                                }
                                break;
                            case 'c':
                                System.out.println("Closing...");
                                return;
                            default:
                                System.out.println("Wrong command!\n");
                        }
                    } catch (NumberFormatException ex) {
                        System.out.println("oops, looks like that's not a number\n");
                    }
                }
            } catch (NumberFormatException ex) {
                System.out.println("oops, looks like that's not a number\n");
            } catch (NegativeArraySizeException ex1) {
                System.out.println("duuude, array size or number of elements can't be negative!\n");
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }

    private static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }

    private static int getInt() throws IOException {
        String s = getString();
        s = s.replaceAll(" ", "");
        s = s.replaceAll("\u0009", "");
        return Integer.parseInt(s);
    }

    private static char getChar() throws IOException {
        String s = getString();
        s = s.replaceAll(" ", "");
        s = s.replaceAll("\u0009", "");
        if (s.equals(""))
            return '\u0001';
        return s.charAt(0);
    }
}
