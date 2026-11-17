import java.util.*;

public class NumberRecognition {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        String num = sc.nextLine();

        if (num.matches("[0-9]+")) {
            System.out.println("Integer Number");
        }

        else if (num.matches("[0-9]+\\.[0-9]+")) {
            System.out.println("Floating Point Number");
        }

        else if (num.matches("[0-9]+[eE][+-]?[0-9]+")) {
            System.out.println("Scientific Notation Number");
        }

        else {
            System.out.println("Invalid Number");
        }

        sc.close();
    }
}
