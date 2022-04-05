package edu.datastructures.Recursion;

import edu.datastructures.ArrayBasedStackAndQueues.ArrayStackApp;
import edu.datastructures.ArrayBasedStackAndQueues.StackException;

public class SimpleKnapsackProblem {
    static int[] items, fullPack;
    static int maxPackWeight;

    public static void main(String[] args) throws StackException {
        doFullPack(5, 20);
    }

    static void makeItems(int itemCount) {
        items = new int[itemCount];
        int item, i = 0;
        point:
        while (i < itemCount) {
            item = (int) (Math.random() * itemCount * 2 + 5);
            for (int j = 0; j < i; j++) {
                if (item == items[j])
                    continue point;
            }
            items[i] = item;
            i++;
        }
        System.out.println("All available items (weights): ");
        showItems(items);
    }

    static void showItems(int[] itemArray) {
        int counter = 0;
        for (int x : itemArray) {
            if (x != 0) {
                counter++;
                System.out.print(x + " ");
            }
        }
        if (counter == 0) {
            System.out.print("Ohh it's empty... \nIt looks like pack can't " +
                    "be filled to its full capacity with that item set");
        }
        System.out.println("\n");
    }

    static void doFullPack(int itemCount, int maxWeight) throws StackException {
        makeItems(itemCount);
        ArrayStackApp stack = new ArrayStackApp(items.length);
        fullPack = new int[items.length];
        maxPackWeight = maxWeight;
        doPack(0, 1, maxWeight, stack);
        System.out.println("Your pack (weights): ");
        showItems(fullPack);
    }

    static void doPack(int i, int j, int aim, ArrayStackApp stack) throws StackException {
        if (j >= items.length) {
            if (i == items.length - 1 && items[i] <= aim) {
                aim -= items[i];
                if (aim == 0)
                    fullPack[0] = items[i];
            }
            return;
        }
        int k = j;
        if (stack.isEmpty() && items[i] <= aim) {
            stack.push(items[i]);
            aim -= items[i];
        }
        while (k < items.length) {
            if (aim >= items[k]) {
                stack.push(items[k]);
                aim -= items[k];
                if (aim == 0)
                    break;
            }
            k++;
        }
        if (aim == 0) {
            int m = 0;
            while (!stack.isEmpty()) {
                fullPack[m] = (int) stack.pop();
                m++;
            }
            return;
        } else {
            while (!stack.isEmpty())
                stack.pop();
            stack.push(items[i]);
            aim = maxPackWeight - items[i];
            doPack(i, j + 1, aim, stack);
        }
        if (fullPack[0] > 0)
            return;
        if (j > i + 1)
            return;
        stack.pop();
        doPack(++i, i + 1, maxPackWeight, stack);
    }
}
