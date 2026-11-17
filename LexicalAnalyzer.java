import java.util.*;

public class LexicalAnalyzer {
    public static void main(String[] args) {

        String input = "int a = 10 + 20;";

        String[] tokens = input.split("(?=[;=+])|(?<=[;=+])|\\s+");

        for (String token : tokens) {

            if (token.matches("[a-zA-Z]+")) {
                if (token.equals("int"))
                    System.out.println(token + " : Keyword");
                else
                    System.out.println(token + " : Identifier");
            }

            else if (token.matches("[0-9]+")) {
                System.out.println(token + " : Number");
            }

            else if (token.matches("[=+;]")) {
                System.out.println(token + " : Operator/Special Symbol");
            }
        }
    }
}
