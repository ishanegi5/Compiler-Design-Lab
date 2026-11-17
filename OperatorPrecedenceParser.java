import java.util.*;

public class OperatorPrecedenceParser {

    static char precedence(char a, char b) {

        if (a == '+' && b == '+') return '>';
        if (a == '+' && b == '*') return '<';
        if (a == '+' && b == '(') return '<';
        if (a == '+' && b == ')') return '>';
        if (a == '+' && b == 'i') return '<';
        if (a == '+' && b == '$') return '>';

        if (a == '*' && b == '+') return '>';
        if (a == '*' && b == '*') return '>';
        if (a == '*' && b == '(') return '<';
        if (a == '*' && b == ')') return '>';
        if (a == '*' && b == 'i') return '<';
        if (a == '*' && b == '$') return '>';

        if (a == '(' && b == '+') return '<';
        if (a == '(' && b == '*') return '<';
        if (a == '(' && b == '(') return '<';
        if (a == '(' && b == ')') return '=';
        if (a == '(' && b == 'i') return '<';

        if (a == ')' && b == '+') return '>';
        if (a == ')' && b == '*') return '>';
        if (a == ')' && b == '$') return '>';

        if (a == 'i' && b == '+') return '>';
        if (a == 'i' && b == '*') return '>';
        if (a == 'i' && b == ')') return '>';
        if (a == 'i' && b == '$') return '>';

        if (a == '$' && b == '+') return '<';
        if (a == '$' && b == '*') return '<';
        if (a == '$' && b == '(') return '<';
        if (a == '$' && b == 'i') return '<';
        if (a == '$' && b == '$') return '=';

        return ' ';
    }

    static char topTerminal(StringBuilder stack) {
        for (int i = stack.length() - 1; i >= 0; i--) {
            char ch = stack.charAt(i);

            if (ch != 'E') {
                return ch;
            }
        }
        return '$';
    }

    static boolean reduce(StringBuilder stack) {

        int n = stack.length();

        if (stack.toString().endsWith("i")) {
            stack.replace(n - 1, n, "E");
            System.out.println("Reduce: i -> E");
            return true;
        }

        if (stack.toString().endsWith("E+E") ||
            stack.toString().endsWith("E*E")) {

            stack.replace(n - 3, n, "E");
            System.out.println("Reduce: E+E/E*E -> E");
            return true;
        }

        if (stack.toString().endsWith("(E)")) {
            stack.replace(n - 3, n, "E");
            System.out.println("Reduce: (E) -> E");
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter expression: ");
        String input = sc.nextLine().replaceAll("\\s+", "");

        input = input.replaceAll("[a-zA-Z0-9]+", "i");

        if (!input.matches("[i+*()]+")) {
            System.out.println("Invalid Expression");
            sc.close();
            return;
        }

        input = input + "$";

        StringBuilder stack = new StringBuilder("$");

        int pos = 0;
        boolean accepted = false;

        while (pos < input.length()) {

            char current = input.charAt(pos);

            if (stack.toString().equals("$E") && current == '$') {
                accepted = true;
                break;
            }

            char top = topTerminal(stack);

            char relation = precedence(top, current);

            if (relation == '<' || relation == '=') {

                stack.append(current);
                System.out.println("Shift: " + current);
                pos++;

            } else if (relation == '>') {

                if (!reduce(stack)) {
                    break;
                }

            } else {
                break;
            }
        }

        if (accepted) {
            System.out.println("String Accepted");
        } else {
            System.out.println("String Rejected");
        }

        sc.close();
    }
}
