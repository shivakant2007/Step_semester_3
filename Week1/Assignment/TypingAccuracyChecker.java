// TypingAccuracyChecker.java
public class TypingAccuracyChecker {

    void checkTypingAccuracy(String original, String typed) {
        int total = Math.max(original.length(), typed.length());
        int matched = 0;
        int firstMismatchPos = -1;
        char origChar = ' ', typedChar = ' ';

        for (int i = 0; i < total; i++) {
            char o = (i < original.length()) ? original.charAt(i) : '\0';
            char t = (i < typed.length()) ? typed.charAt(i) : '\0';
            if (o == t) {
                matched++;
            } else {
                if (firstMismatchPos == -1) {
                    firstMismatchPos = i;
                    origChar = o;
                    typedChar = t;
                }
            }
        }

        double accuracy = ((double) matched / total) * 100;
        System.out.println("Matching characters: " + matched + " / " + total);
        System.out.println("Accuracy: " + String.format("%.2f", accuracy) + "%");

        if (firstMismatchPos == -1) {
            System.out.println("No mismatch found - strings match!");
        } else {
            System.out.println("First mismatch at position: " + firstMismatchPos);
            System.out.println("Original char: '" + origChar + "', Typed char: '" + typedChar + "'");
        }
    }

    public static void main(String[] args) {
        TypingAccuracyChecker checker = new TypingAccuracyChecker();

        System.out.println("Test 1: Matching strings");
        checker.checkTypingAccuracy("hello", "hello");

        System.out.println();
        System.out.println("Test 2: First char mismatch");
        checker.checkTypingAccuracy("hello", "jello");

        System.out.println();
        System.out.println("Test 3: Partial mismatch");
        checker.checkTypingAccuracy("world", "wordz");
    }
}
