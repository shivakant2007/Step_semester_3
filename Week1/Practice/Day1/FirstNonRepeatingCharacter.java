import java.util.HashMap;

public class FirstNonRepeatingCharacter {

    public static char findFirstNonRepeatingChar(String text) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            freq.put(text.charAt(i), freq.getOrDefault(text.charAt(i), 0) + 1);
        }
        for (int i = 0; i < text.length(); i++) {
            if (freq.get(text.charAt(i)) == 1) {
                return text.charAt(i);
            }
        }
        return '\0';
    }

    public static void main(String[] args) {
        String[] testCases = {"stress", "aabb", "swiss", "java"};

        for (String test : testCases) {
            char result = findFirstNonRepeatingChar(test);
            if (result == '\0') {
                System.out.println("\"" + test + "\" -> No non-repeating character found.");
            } else {
                System.out.println("\"" + test + "\" -> First non-repeating character: '" + result + "'");
            }
        }
    }
}
