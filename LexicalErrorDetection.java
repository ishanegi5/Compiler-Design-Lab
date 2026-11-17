import java.util.*;

public class LexicalErrorDetection {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter an identifier: ");
        String input = sc.nextLine();

        if (input.matches("[a-zA-Z_][a-zA-Z0-9_]*")) {
            System.out.println("Valid Identifier");
        } else {
            System.out.println("Lexical Error: Invalid Identifier");
        }

        sc.close();
    }
}
