import java.util.*;

public class MonoCipher {

    
    static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

   
    static String SUB_KEY = "QWERTYUIOPASDFGHJKLZXCVBNM";

  
    public static String encrypt(String text) {
        text = text.toUpperCase();
        StringBuilder result = new StringBuilder();
        System.out.println("\n--- Encryption Steps ---");

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isLetter(ch)) {
                int pos = ALPHABET.indexOf(ch);
                char cipherChar = SUB_KEY.charAt(pos);

                System.out.println("Char: " + ch +
                        " | Pos: " + pos +
                        " | CipherChar: " + cipherChar);

                result.append(cipherChar);
            } else {
                result.append(ch); 
            }
        }
        return result.toString();
    }

   
    public static String decrypt(String text) {
        text = text.toUpperCase();
        StringBuilder result = new StringBuilder();
        System.out.println("\n--- Decryption Steps ---");

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isLetter(ch)) {
                int pos = SUB_KEY.indexOf(ch);
                char plainChar = ALPHABET.charAt(pos);

                System.out.println("Char: " + ch +
                        " | CipherPos: " + pos +
                        " | PlainChar: " + plainChar);

                result.append(plainChar);
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter the text: ");
        String text = sc.nextLine();

       
        System.out.print("Use default substitution key? (y/n): ");
        String choice = sc.nextLine();

        if (choice.equalsIgnoreCase("n")) {
            System.out.print("Enter 26-letter substitution key (permutation of A-Z): ");
            SUB_KEY = sc.nextLine().toUpperCase();
            if (SUB_KEY.length() != 26) {
                System.out.println("Invalid key length! Using default key.");
                SUB_KEY = "QWERTYUIOPASDFGHJKLZXCVBNM";
            }
        }

        System.out.println("\nSubstitution Key Used:\nPlain : " + ALPHABET);
        System.out.println("Cipher: " + SUB_KEY);

        
        String encrypted = encrypt(text);
        System.out.println("\nEncrypted Text: " + encrypted);

        
        String decrypted = decrypt(encrypted);
        System.out.println("\nDecrypted Text: " + decrypted);

        sc.close();
    }
}