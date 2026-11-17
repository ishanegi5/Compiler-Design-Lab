public class TokenLexemePattern {
    public static void main(String[] args) {

        String input = "int age = 20;";

        String[] words = input.split("(?=[=;])|(?<=[=;])|\\s+");

        System.out.println("Lexeme\t\tToken\t\tPattern");

        for (String word : words) {

            if (word.matches("[a-zA-Z]+")) {

                if (word.equals("int")) {
                    System.out.println(word + "\t\tKeyword\t\tint");
                } else {
                    System.out.println(word + "\t\tIdentifier\tLetter");
                }
            }

            else if (word.matches("[0-9]+")) {
                System.out.println(word + "\t\tNumber\t\tDigit");
            }

            else if (word.equals("=")) {
                System.out.println(word + "\t\tOperator\t=");
            }

            else if (word.equals(";")) {
                System.out.println(word + "\t\tSeparator\t;");
            }
        }
    }
}
