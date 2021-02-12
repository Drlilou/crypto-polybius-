
import java.util.Scanner;

public class CaesarCipherV2 {

    static char getMaxOccuringChar(String str) {
        // Create array to keep the count of individual 
        // characters and initialize the array as 0 
        int count[] = new int[256];

        // Construct character count array from the input 
        // string. 
        int len = str.length();
        for (int i = 0; i < len; i++) {
            count[str.charAt(i)]++;
        }

        int max = -1;  // Initialize max count 
        char result = ' ';   // Initialize result 

        // Traversing through the string and maintaining 
        // the count of each character 
        for (int i = 0; i < len; i++) {
            if (max < count[str.charAt(i)]) {
                max = count[str.charAt(i)];
                result = str.charAt(i);
            }
        }

        return result;
    }

    public static String encryptCaesarCipher(String plaintext, int offset) {
        plaintext = plaintext.toUpperCase();

        if (offset >= 26 || offset <= -26) {
            offset = offset % 26;
        }

        if (offset == 0) {
            return plaintext;
        }

        String s = "";
        char ch;
        int chNum;
        int newChNum;

        for (int i = 0; i < plaintext.length(); i++) {
            if (plaintext.charAt(i) != 32)//if char is not a space
            {
                chNum = plaintext.charAt(i);
                newChNum = chNum + offset;

                if (newChNum > 90) {
                    newChNum -= 26;
                }

                if (newChNum < 65) {
                    newChNum += 26;
                }
                ch = (char) newChNum;

                s += ch;
            } else {
                s += " ";
            }
        }

        return s;
    }

    public static void menu() {
        System.out.println("\t1 : crypte");
        System.out.println("\t2 : decrypte ");
        System.out.println("\t3 : quit");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            menu();
            boolean exit = false;
            int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:

                    System.out.println("saisir chaine :");
                    String ch = sc
                            .nextLine();

                    System.out.println("nbr decalage :");
                    char c = getMaxOccuringChar(ch);
                    int ec = (int)c%96;
                    System.out.println(ec);

                    String ch3 = encryptCaesarCipher(ch, ec);
                    System.out.println(ch3);
                    String ch2;

                    break;

                case 2:
                    System.out.println("saisir chaine :");
                    ch = sc.nextLine();
                    System.out.println("nbr decalage :");
                    c = getMaxOccuringChar(ch);
                    ec =(int)c%96;
                    System.out.println(ec);
                    ch3 = encryptCaesarCipher(ch, -ec);
                    System.out.println(ch3);
                    break;

                case 3:
                    exit = true;
                    break;
                 default:
                    break;
            }
            if (exit) {
                break;
            }

        }
    }
}
