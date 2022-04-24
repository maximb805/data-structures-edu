package edu.datastructures.HashTables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HashDouble<T> {
    private DataItem<T>[] hashArray;
    private DataItem<T> delItem;
    private int hashConst;
    private double elemCount;

    public HashDouble(int size) {
        hashArray = new DataItem[getPrime(size * 2)];
        delItem = new DataItem<>(-1, null);
        hashConst = getPrime(size);
        elemCount = 0;
    }

    private int hashFunc(int key) {
        return key % hashArray.length;
    }

    private int hashFunc2(int key) {
        return hashConst - (key % hashConst);
    }

    public DataItem<T> find(int key) {
        int hashVal = hashFunc(key);
        int hashValStart = hashVal;
        int step = hashFunc2(key);

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key)
                return hashArray[hashVal];
            hashVal += step;
            hashVal %= hashArray.length;
            if (hashVal == hashValStart)
                break;
        }
        return null;
    }

    public void insert(DataItem<T> dataItem) {
        int hashVal = hashFunc(dataItem.getKey());
        int hashValStart = hashVal;
        int step = hashFunc2(dataItem.getKey());
        if (elemCount / hashArray.length >= 0.5) {
            extendX2();
        }
        while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
            hashVal += step;
            hashVal %= hashArray.length;
            if (hashVal == hashValStart) {
                System.out.println("Hash table is full!");
                return;
            }
        }
        hashArray[hashVal] = dataItem;
        elemCount++;
    }

    public DataItem<T> delete(int key) {
        int hashVal = hashFunc(key);
        int hashValStart = hashVal;
        int step = hashFunc2(key);

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                DataItem<T> temp = hashArray[hashVal];
                hashArray[hashVal] = delItem;
                return temp;
            }
            hashVal += step;
            hashVal %= hashArray.length;
            if (hashVal == hashValStart)
                break;
        }
        return null;
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
        System.out.print("Table: ");
        for (int i = 0; i < hashArray.length - 1; i++) {
            System.out.print(hashArray[i] + ", ");
        }
        System.out.println(hashArray[hashArray.length - 1]);
    }

    public void extendX2() {
        reHash(getPrime(hashArray.length * 2));
    }

    public void extend(int additionalSize) {
        reHash(getPrime(hashArray.length + additionalSize));
    }

    private void reHash(int newSize) {
        DataItem<T>[] newHashArray = new DataItem[newSize];
        hashConst = getPrime(newSize / 2);
        for (int i = 0; i < hashArray.length; i++) {
            if (hashArray[i] != null && hashArray[i].getKey() != -1) {
                int newHashVal = hashArray[i].getKey() % newHashArray.length;
                int startVal = newHashVal;
                int step = hashFunc2(hashArray[i].getKey());

                while (newHashArray[newHashVal] != null) {
                    newHashVal += step;
                    newHashVal %= newHashArray.length;
                    if (startVal == newHashVal) {
                        System.out.println("New hash table is full, rehashing not completed!");
                        return;
                    }
                }
                newHashArray[newHashVal] = hashArray[i];
            }
        }
        hashArray = newHashArray;
    }
}

class HashDoubleUser {
    public static void main(String[] args) {
        int checker = 0;
        while (checker != 1) {
            try {
                System.out.print("Enter hash table size (it'll be doubled): ");
                int size = getInt();
                HashDouble<Integer> hash = new HashDouble<>(size);

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
                                "\"show\", \"delete\", \"insert\", \"find\", \"extend\" or \"close\": ");
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
                                System.out.println();
                                hash.insert(new DataItem<>(iKey, data));
                                break;
                            case 'f':
                                System.out.print("Enter key: ");
                                int fKey = getInt();
                                if (fKey < 0) {
                                    System.out.println("There's no negative keys in table (except deleted)\n");
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
                                    System.out.println("There's no negative keys in table (except deleted)\n");
                                    break;
                                }
                                DataItem<Integer> delItem = hash.delete(del);
                                if (delItem == null) {
                                    System.out.println("Item with key " + del + " not found.\n");
                                } else {
                                    System.out.println(delItem + " deleted\n");
                                }
                                break;
                            case 'e':
                                System.out.print("Ender extension size (0 for double extension, can't be < 0): ");
                                int ext = getInt();
                                if (ext < 0) {
                                    System.out.println("Can't decrease table!\n");
                                    break;
                                }
                                if (ext == 0) {
                                    hash.extendX2();
                                } else {
                                    hash.extend(ext);
                                }
                                System.out.println();
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

