package edu.datastructures.Trees.HuffmanCode;

import edu.datastructures.Trees.BinarySearchTreeApp;
import edu.datastructures.Trees.Node;

public class HuffmanCode {
    public static PriorityQueue<Integer, BinarySearchTreeApp<Integer, Character>> queue = new PriorityQueue<>();
    public static String[] codeArray = new String[256];

    public static void symbolsFreq(String text) {
        char ch;
        int freq;
        while (!text.isEmpty()) {
            ch = text.charAt(0);
            freq = 1;
            for (int i = 1; i < text.length(); i++) {
                if (text.charAt(i) == ch) {
                    freq++;
                }
            }
            Node<Integer, Character> node = new Node<>(freq, ch);
            BinarySearchTreeApp<Integer, Character> huffTree = new BinarySearchTreeApp<>();
            huffTree.insert(node);
            queue.insert(freq, huffTree);
            text = text.replaceAll(Character.toString(ch), "");
        }
    }

    public static void createTree() {
        while (true) {
            BinarySearchTreeApp<Integer, Character> newTree = new BinarySearchTreeApp<>();
            Node<Integer, Character> node1 = queue.remove().getData().getRoot();
            if (queue.isEmpty()) {
                newTree.insert(node1);
                queue.insert(node1.getKey(), newTree);
                break;
            }
            Node<Integer, Character> node2 = queue.remove().getData().getRoot();
            newTree.insert(new Node<>((node1.getKey() + node2.getKey()), null));
            newTree.getRoot().setLeft(node1);
            newTree.getRoot().setRight(node2);
            queue.insert(newTree.getRoot().getKey(), newTree);
        }
    }

    public static String encodeMessage(String message) {
        symbolsFreq(message);
        createTree();
        traverseAndFillArray(queue.peek().getData().getRoot(), "");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            sb.append(codeArray[message.charAt(i)]);
        }
        return sb.toString();
    }

    public static void traverseAndFillArray(Node<Integer, Character> localRoot, String code) {
        if (localRoot.getData() != null) {
            codeArray[localRoot.getData()] = code;
            return;
        }
        String thisCode;
        thisCode = code + "0";
        traverseAndFillArray(localRoot.getLeft(), thisCode);
        thisCode = code + "1";
        traverseAndFillArray(localRoot.getRight(), thisCode);
    }

    public static String decodeMessage(String message) {
        StringBuilder sb = new StringBuilder();
        Node<Integer, Character> root = queue.peek().getData().getRoot();
        Node<Integer, Character> node = root;
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == '0')
                node = node.getLeft();
            else
                node = node.getRight();

            if (node.getData() != null) {
                sb.append(node.getData());
                node = root;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("Susie says it is easy\n");
        String codedMsg = encodeMessage("Susie says it is easy\n");
        String decodedMsg = decodeMessage(codedMsg);
        System.out.println("Encoded message: ");
        System.out.println(codedMsg);
        System.out.println("Decoded message: ");
        System.out.print(decodedMsg);

        System.out.println();
        for (int i = 0; i < codeArray.length; i++) {
            if (codeArray[i] != null)
                if ((char) i == '\n')
                    System.out.println("\\n " + codeArray[i]);
                else if ((char) i == ' ')
                    System.out.println("space " + codeArray[i]);
                else
                    System.out.println((char) i + " " + codeArray[i]);

        }
    }
}

