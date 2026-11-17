import java.util.*;

public class ShiftReduceParser {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter input string (a+b): ");
        String input = sc.nextLine();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {

            char ch = input.charAt(i);

            stack.push(ch);
            System.out.println("Shift: " + ch);

            if (stack.size() >= 3) {

                if (stack.get(stack.size() - 3) == 'a' &&
                    stack.get(stack.size() - 2) == '+' &&
                    stack.get(stack.size() - 1) == 'b') {

                    stack.pop();
                    stack.pop();
                    stack.pop();

                    stack.push('E');

                    System.out.println("Reduce: a+b -> E");
                }
            }
        }

        if (stack.size() == 1 && stack.peek() == 'E') {
            System.out.println("String Accepted");
        } else {
            System.out.println("String Rejected");
        }

        sc.close();
    }
}
