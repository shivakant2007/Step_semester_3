public class VowelConsonantCounter {

    void countVowelsAndConsonants(String text) {
        int vowels = 0;
        int consonants = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            char lower = Character.toLowerCase(ch);
            if (lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u') {
                vowels++;
            } else if (Character.isLetter(ch)) {
                consonants++;
            }
        }
        System.out.println("Vowels: " + vowels + ", Consonants: " + consonants);
    }

    public static void main(String[] args) {
        VowelConsonantCounter counter = new VowelConsonantCounter();

        System.out.println("Test 1: \"Hello World\"");
        counter.countVowelsAndConsonants("Hello World");

        System.out.println("\nTest 2: Uppercase \"AEIOU BCDFG\"");
        counter.countVowelsAndConsonants("AEIOU BCDFG");

        System.out.println("\nTest 3: Mixed Case \"Java Programming\"");
        counter.countVowelsAndConsonants("Java Programming");
    }
}
