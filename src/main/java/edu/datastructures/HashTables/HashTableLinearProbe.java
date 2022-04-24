package edu.datastructures.HashTables;


public class HashTableLinearProbe<T> {
    private DataItem<T>[] hashArray;
    private DataItem<T> delItem;

    public HashTableLinearProbe(int size) {
        hashArray = new DataItem[getPrime(size * 2)];
        delItem = new DataItem<>(-1, null);
    }

    private int hashFunc(int key) {
        return key % hashArray.length;
    }

    public DataItem<T> find(int key) {
        int hashVal = hashFunc(key);
        int hashValStart = hashVal;

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key)
                return hashArray[hashVal];
            hashVal++;
            hashVal %= hashArray.length;
            if(hashVal == hashValStart)
                break;
        }
        return null;
    }

    public void insert(DataItem<T> dataItem) {
        int hashVal = hashFunc(dataItem.getKey());
        int hashValStart = hashVal;

        while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
            hashVal++;
            hashVal %= hashArray.length;
            if(hashVal == hashValStart) {
                System.out.println("Hash table is full!");
                return;
            }
        }
        hashArray[hashVal] = dataItem;
    }

    public DataItem<T> delete(int key) {
        int hashVal = hashFunc(key);
        int hashValStart = hashVal;

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                DataItem<T> temp = hashArray[hashVal];
                hashArray[hashVal] = delItem;
                return temp;
            }
            hashVal++;
            hashVal %= hashArray.length;
            if(hashVal == hashValStart)
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
                int startVal = newHashVal;

                while (newHashArray[newHashVal] != null) {
                    newHashVal++;
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

class HashTableLinearProbeUser {
    public static void main(String[] args) {
        HashDouble<Integer> hash = new HashDouble<>(30);
        hash.insert(new DataItem<>(1501, 1501));
        System.out.println(hash.find(1501));
        hash.displayTable();
        hash.delete(1501);
        hash.displayTable();
        hash.extendX2();
        hash.displayTable();
    }
}
