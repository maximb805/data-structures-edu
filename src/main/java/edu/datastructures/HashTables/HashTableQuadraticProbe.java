package edu.datastructures.HashTables;


public class HashTableQuadraticProbe<T> {
    private DataItem<T>[] hashArray;
    private DataItem<T> delItem;

    public HashTableQuadraticProbe(int size) {
        hashArray = new DataItem[getPrime(size * 2)];
        delItem = new DataItem<>(-1, null);
    }

    private int hashFunc(int key) {
        return key % hashArray.length;
    }

    public DataItem<T> find(int key) {
        int hashVal = hashFunc(key);
        int step = 1;

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key)
                return hashArray[hashVal];
            hashVal += step * step;
            if (hashVal < 0) {
                System.out.println("Hash table is full!");
                break;
            }
            step++;
            hashVal %= hashArray.length;
        }
        return null;
    }

    public void insert(DataItem<T> dataItem) {
        int hashVal = hashFunc(dataItem.getKey());
        int step = 1;

        while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
            hashVal += step * step;
            if (hashVal < 0) {
                System.out.println("Can't find a place to insert!");
                return;
            }
            step++;
            hashVal %= hashArray.length;
        }
        hashArray[hashVal] = dataItem;
    }

    public DataItem<T> delete(int key) {
        int hashVal = hashFunc(key);
        int step = 1;

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                DataItem<T> temp = hashArray[hashVal];
                hashArray[hashVal] = delItem;
                return temp;
            }
            hashVal += step * step;
            if (hashVal < 0) {
                break;
            }
            step++;
            hashVal %= hashArray.length;
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
        for(int i = 0; i < hashArray.length - 1; i++) {
            System.out.print(hashArray[i] + ", ");
        }
        System.out.println(hashArray[hashArray.length - 1]);
    }

    public void extendX2() {
        reHash(getPrime(hashArray.length * 2));
    }

    public void extend(int newSize) {
        reHash(getPrime(newSize));
    }

    private void reHash(int newSize) {
        DataItem<T>[] newHashArray = new DataItem[newSize];
        for (int i = 0; i < hashArray.length; i++) {
            if (hashArray[i] != null && hashArray[i].getKey() != -1) {
                int newHashVal = hashArray[i].getKey() % newHashArray.length;
                int step = 1;

                while (newHashArray[newHashVal] != null) {
                    newHashVal += step * step;
                    if (newHashVal < 0) {
                        System.out.println("New hash table is full, rehashing not completed!");
                        return;
                    }
                    step++;
                    newHashVal %= newHashArray.length;
                }
                newHashArray[newHashVal] = hashArray[i];
            }
        }
        hashArray = newHashArray;
    }
}

class HashTableQuadraticProbeUser {
    public static void main(String[] args) {
        HashTableQuadraticProbe<Integer> hash = new HashTableQuadraticProbe<>(30);
        hash.insert(new DataItem<>(1501, 1501));
        System.out.println(hash.find(1501));
        hash.displayTable();
        hash.delete(1501);
        hash.displayTable();
    }
}

