import java.util.*;

public class PredictiveParser {

    static String input;
    static int pos = 0;

    // Grammar:
    // E -> TQ
    // Q -> +TQ | ε
    // T -> a

    static boolean E() {
        return T() && Q();
    }

    static boolean Q() {
        if (pos < input.length() && input.charAt(pos) == '+') {
            pos++;
            return T() && Q();
        }
        return true; // Epsilon
    }

    static boolean T() {
        if (pos < input.length() && input.charAt(pos) == 'a') {
            pos++;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter input string: ");
        input = sc.nextLine();

        if (E() && pos == input.length()) {
            System.out.println("String Accepted");
        } else {
            System.out.println("String Rejected");
        }

        sc.close();
    }
}
