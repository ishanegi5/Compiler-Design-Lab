import java.util.*;

public class OperatorSeparator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter an expression: ");
        String input = sc.nextLine();

        String[] operators = {
            "+", "-", "*", "/", "%",
            "=", "==", "!=", "<", ">",
            "<=", ">=", "&&", "||", "++", "--"
        };

        String[] separators = {
            ";", ",", "(", ")", "{", "}", "[", "]"
        };

        for (int i = 0; i < input.length(); i++) {

            String ch = String.valueOf(input.charAt(i));

            if (operators[0].equals(ch) || operators[1].equals(ch) ||
                operators[2].equals(ch) || operators[3].equals(ch) ||
                operators[4].equals(ch) || operators[5].equals(ch) ||
                operators[6].equals(ch) || operators[7].equals(ch) ||
                operators[8].equals(ch) || operators[9].equals(ch) ||
                operators[10].equals(ch) || operators[11].equals(ch) ||
                operators[12].equals(ch) || operators[13].equals(ch) ||
                operators[14].equals(ch) || operators[15].equals(ch)) {

                System.out.println(ch + " : Operator");
            }

            else {
                for (String separator : separators) {
                    if (separator.equals(ch)) {
                        System.out.println(ch + " : Separator");
                    }
                }
            }
        }

        sc.close();
    }
}
