package edu.datastructures.Recursion;

public class SimpleTasks {
    static int counter = 0;
    static String[] words = new String[10000];
    static int wordsNum = 0;

    public static void main(String[] args) {
        System.out.println(triangle(5));
        System.out.println(factorial(5));
        doAnagrams("world");
    }

    public static void doAnagrams(String word) {
        allAnagrams(word.length(), word);
        displayWord();
    }

    private static void allAnagrams(int wordLength, String word) {
        if (wordLength == 1) {
            return;
        }
        for (int i = 0; i < wordLength; i++) {
            allAnagrams(wordLength - 1, word);
            if (wordLength == 2) {
                words[wordsNum] = word;
                wordsNum++;
            }
            word = rotate(word.length() - wordLength, word);
        }
    }

    private static String rotate(int position, String word) {
        StringBuilder sb = new StringBuilder();
        char[] ch = word.toCharArray();
        char temp = ch[position];
        for (int i = position; i < word.length() - 1; i++) {
            ch[i] = ch[i + 1];
        }
        ch[word.length() - 1] = temp;
        for (char x : ch) {
            sb.append(x);
        }
        return sb.toString();
    }

    private static String[] checkEquals() {
        for (int j = 0; j < words.length; j++) {
            if (words[j] == null)
                break;
            if (words[j].equals(""))
                continue;
            for (int i = j + 1; i < words.length; i++) {
                if (words[i] == null)
                    break;
                if (words[j].equals(words[i])) {
                    words[i] = "";
                }
            }
        }
        return words;
    }

    public static void displayWord() {
        words = checkEquals();
        for (int i = 0; i < words.length; i++) {
            if (words[i] == null)
                break;
            if (!words[i].equals("")) {
                counter++;
                if (counter < 10)
                    System.out.print(" ");
                if (counter < 100)
                    System.out.print(" ");
                System.out.print(counter + ") " + words[i] + " ");
                if (counter % 6 == 0)
                    System.out.println();
            }
        }
    }

    static int triangle(int num) {
        return num == 1 ? num : num + triangle(num - 1);
    }

    static long factorial(long num) {
        return num == 0 ? 1 : num * factorial(num - 1);
    }
}
