public class WordReversalEncoder {
    String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            StringBuilder reversed = new StringBuilder(words[i]);
            reversed.reverse();
            if (i > 0) {
                result.append(" ");
            }
            result.append(reversed);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        WordReversalEncoder encoder = new WordReversalEncoder();
        System.out.println(encoder.reverseEachWord("hello"));
        System.out.println(encoder.reverseEachWord("hello club"));
    }
}
