import java.util.*;

public class KeywordIdentifier {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] keywords = {
            "int", "float", "double", "char",
            "if", "else", "while", "for",
            "return", "void", "class"
        };

        System.out.print("Enter a word: ");
        String word = sc.next();

        boolean found = false;

        for (String keyword : keywords) {
            if (word.equals(keyword)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println(word + " is a Keyword");
        }

        else if (word.matches("[a-zA-Z_][a-zA-Z0-9_]*")) {
            System.out.println(word + " is an Identifier");
        }

        else {
            System.out.println(word + " is Invalid");
        }

        sc.close();
    }
}
