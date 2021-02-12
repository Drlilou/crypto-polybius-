
import java.util.Scanner;

public class CaesarCipher {

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
        while (true) {
            menu();
            boolean exit = false;
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            switch (option) {
                case 1:

                    System.out.println("saisir chaine :");
                    String ch = sc
                            .next();
                    System.out.println("nbr decalage :");
                    int ec = sc.nextInt();
                    String ch3 = encryptCaesarCipher(ch, ec);
                    System.out.println(ch3);
                    String ch2;
                    break;

                case 2:
                    System.out.println("saisir chaine :");
                    ch = sc.next();

                    System.out.println("nbr decalage :");
                    ec = sc.nextInt();
                    ch3 = encryptCaesarCipher(ch, -ec);
                    System.out.println(ch3);
                    break;

                case 3:
                    exit = true;
                    break;
            }
            if (exit) {
                break;
            }
        }
    }
}
