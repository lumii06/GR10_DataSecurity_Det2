/*
 *  File Name: Myszkowski.java
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    }
}




class Myszkowski {

    private StringBuilder builder;
    private HashTable table;
    private Queue queue;


    public Myszkowski() {
        builder = new StringBuilder();
    }

    /**
     *  Tests if a character is a letter.

     */
    private boolean isAlphabet(char character) {
        return (character >= 'a' && character <= 'z' ||
                character >= 'A' && character <= 'Z');
    }

    /**
     *  Tests if a letter is in lower case.
     *

     */
    private boolean isLowerCase(char character) {
        return (character >= 'a' && character <= 'z');
    }

    /**
     *  Converts a letter into a number.
     *

     */
    private int numberOf(char character) {
        int number = (int) (character - 65);
        return number;
    }

    /**
     *  Determines the number of possible rows.
     *

     */
    private int row(String key, String text) {
        int keyL = key.length();
        int textL = text.length();
        int row = 1;
        if(textL == keyL) {
            return row;
        }
        while (textL > keyL) {
            textL -= keyL;
            row++;
        }
        return row;
    }

    /**
     *  Determines the number of possible columns with potruding row.
     *

     */
    private int column(String key, String text) {
        int keyL = key.length();
        int textL = text.length();
        int column = 0;
        if (textL == 0 || keyL == 0 || textL == keyL) {
            return column;
        }
        else {
            column = textL % keyL;
        }
        return column;
    }

    /**
     *  Determines the frequency of each letters in the keyword.
     *

     */
    private int[] frequency(String key) {
        char[] keys = key.toCharArray();
        int[] frequency = new int[26];
        for (int i = 0; i < keys.length; i++) {
            frequency[keys[i] - 65]++;
        }
        return frequency;
    }

    /**
     *  Determines the lexicographical order of each letters in the keyword.

     */
    private int[] lexicography(String key) {
        char[] keys = key.toCharArray();
        int[] lexicography = new int[26];
        int[] frequency = frequency(key);
        int counter = 0;
        for (int i = 0; i < 26; i++) {
            if (frequency[i] != 0) {
                lexicography[i] = counter++;
            }
        }
        return lexicography;
    }

    
}
