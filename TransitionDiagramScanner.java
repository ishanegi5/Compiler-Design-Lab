import java.util.*;

public class TransitionDiagramScanner {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter an identifier: ");
        String input = sc.nextLine();

        int state = 0;

        for (int i = 0; i < input.length(); i++) {

            char ch = input.charAt(i);

            switch (state) {

                case 0:
                    if (Character.isLetter(ch) || ch == '_') {
                        state = 1;
                    } else {
                        state = -1;
                    }
                    break;

                case 1:
                    if (Character.isLetterOrDigit(ch) || ch == '_') {
                        state = 1;
                    } else {
                        state = -1;
                    }
                    break;
            }

            if (state == -1) {
                break;
            }
        }

        if (state == 1) {
            System.out.println("Valid Identifier");
        } else {
            System.out.println("Invalid Identifier");
        }

        sc.close();
    }
}
