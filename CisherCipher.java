import java.util.Scanner;

public class CisherCipher {

  
    public static String encrypt(String text, int key) {
        StringBuilder result = new StringBuilder();
        System.out.println("\n--- Encryption Steps ---");
        
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                int originalPos = ch - base;
                int newPos = (originalPos + key) % 26;
                char encryptedChar = (char) (base + newPos);

                System.out.println("Char: " + ch +
                        " | OriginalPos: " + originalPos +
                        " | ShiftedPos: " + newPos +
                        " | EncryptedChar: " + encryptedChar);

                result.append(encryptedChar);
            } else {
                result.append(ch); 
            }
        }
        return result.toString();
    }

   
    public static String decrypt(String text, int key) {
        StringBuilder result = new StringBuilder();
        System.out.println("\n--- Decryption Steps ---");

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                int encryptedPos = ch - base;
                int newPos = (encryptedPos - key + 26) % 26;
                char decryptedChar = (char) (base + newPos);

                System.out.println("Char: " + ch +
                        " | EncryptedPos: " + encryptedPos +
                        " | ShiftedPos: " + newPos +
                        " | DecryptedChar: " + decryptedChar);

                result.append(decryptedChar);
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

        
        System.out.print("Enter the key (Press Enter for default key = 3): ");
        String inputKey = sc.nextLine();

        int key = inputKey.isEmpty() ? 3 : Integer.parseInt(inputKey);

        System.out.println("\nUsing Key = " + key);

        
        String encrypted = encrypt(text, key);
        System.out.println("\nEncrypted Text: " + encrypted);

        
        String decrypted = decrypt(encrypted, key);
        System.out.println("\nDecrypted Text: " + decrypted);

        sc.close();
    }
}