public class CommentRemoval {
    public static void main(String[] args) {

        String code = """
            int a = 10; // This is a comment
            /* This is
               a multi-line comment */
            int b = 20;
            """;

        System.out.println("Original Code:");
        System.out.println(code);

        // Remove single-line comments
        code = code.replaceAll("//.*", "");

        // Remove multi-line comments
        code = code.replaceAll("(?s)/\\*.*?\\*/", "");

        // Remove extra whitespace
        code = code.replaceAll("\\s+", " ").trim();

        System.out.println("\nCode After Removing Comments:");
        System.out.println(code);
    }
}
