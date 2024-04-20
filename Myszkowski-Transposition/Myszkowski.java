/*
 *  File Name: Myszkowski.java
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter plaintext and keyword
        System.out.print("Enter plaintext: ");
        String plaintext = scanner.nextLine();

        System.out.print("Enter keyword: ");
        String keyword = scanner.nextLine();

        // Close the Scanner
        scanner.close();

        // Example usage of Myszkowski cipher
        Myszkowski myszkowski = new Myszkowski();

        // Encrypt the plaintext
        String ciphertext = myszkowski.encipher(plaintext, keyword);
        System.out.println("Encrypted text: " + ciphertext);

        // Decrypt the ciphertext
        String decryptedText = myszkowski.decipher(ciphertext, keyword);
        System.out.println("Decrypted Text: " + decryptedText);
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

    /**
     *  Generates an order for inserting characters in the hash table depending on the keyword.
     *
     */
    
    private Queue generateOrder(String key) {
        Queue queue = new Queue(key.length());
        char[] keys = key.toCharArray();
        int[] frequency = frequency(key);
        int[] lexicography = lexicography(key);
        for (char character : keys) {
            if(frequency[numberOf(character)] >= 2 ) {
                queue.offer(lexicography[numberOf(character)]);
            }
            else {
                queue.offer(lexicography[numberOf(character)]);
            }
        }
        return queue;
    }

    /**
     *  Generates a cutoff interval for inserting characters in the hash table.
     */
    
    private int[] generateCutoff(String key, int row, int column) {
        int[] interval = new int[key.length()];
        int[] cutoff = new int[length(key)];
        Queue order = generateOrder(key);
        int x = row;
        int y = column;
        int roll, index;
        for (int i = 0; i < key.length(); i++) {
            if (column == 0) {
                interval[i] = x;
            }
            else if (y > 0) {
                interval[i] = x;
                y--;
            }
            else if (y == 0) {
                interval[i] = (x-1);
            }
        }
        for (int i = 0; i < key.length(); i++) {
            roll = order.poll();
            cutoff[roll] += interval[i];
        }
        return cutoff;
    }

    /**
     *  Reduces the keyword's length by each recurring letter.
     */
    
    private int length(String key) {
        int length = key.length();
        int[] frequency = frequency(key);
        for (int i = 0; i < 26; i++) {
            if (frequency[i] >= 2) {
                length -= (frequency[i] - 1);
            }
        }
        return length;
    }

    /**
     *  Encypts the plaintext into ciphertext using Myszkowski transposition.
     *   Removes non-alphabetical characters from the original plaintext.
     */
    
    public String encipher(String text, String key) {
        table = new HashTable(length(key));
        Queue queue = generateOrder(key);
        int row;
        char character;
        for (int index = 0; index < text.length(); index++) {
            character = text.charAt(index);
            if (isAlphabet(character)) {
                row = queue.poll();
                table.insert(row, character);
                queue.offer(row);
            }
        }
        queue.sort();
        while (!table.isEmpty()) {
            row = queue.poll();
            while (!table.isRowEmpty(row)) {
                character = table.pop(row);
                builder.append(character);
            }
        }
        String ciphertext = builder.toString();
        builder.setLength(0);
        table.clear();
        return ciphertext;
    }
        
    //   Decrypts the ciphertext into plaintext using Myszkowski transposition.
    
    public String decipher(String text, String key) {
        int row = row(key, text), column = column(key, text), order = 0;;
        table = new HashTable(length(key));
        int[] cutoff = generateCutoff(key, row, column);
        char character;
        for (int index = 0; index < text.length(); index++) {
            character = text.charAt(index);
            if (isAlphabet(character)) {
                if (cutoff[order] != 0) {
                    table.insert(order, character);
                    cutoff[order] -= 1;
                }
                else {
                    cutoff[++order] -= 1;
                    table.insert(order, character);
                }
            }
        }
        Queue queue = generateOrder(key);
        while (!table.isEmpty()) {
            int roll = queue.poll();
            character = table.pop(roll);
            builder.append(character);
            queue.offer(roll);
        }
        String ciphertext = builder.toString();
        builder.setLength(0);
        table.clear();
        return ciphertext;
    }
    
}
