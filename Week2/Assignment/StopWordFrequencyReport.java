import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StopWordFrequencyReport {
    void printFilteredWordFrequency(String feedback) {
        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};
        String lower = feedback.toLowerCase();
        String cleaned = lower.replace(".", "").replace(",", "");
        String[] words = cleaned.split("\\s+");
        HashMap<String, Integer> frequency = new HashMap<>();
        for (String word : words) {
            boolean isStopWord = false;
            for (String stop : stopWords) {
                if (word.equals(stop)) {
                    isStopWord = true;
                    break;
                }
            }
            if (!isStopWord && !word.isEmpty()) {
                frequency.put(word, frequency.getOrDefault(word, 0) + 1);
            }
        }
        ArrayList<Map.Entry<String, Integer>> sorted = new ArrayList<>(frequency.entrySet());
        Collections.sort(sorted, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                return b.getValue() - a.getValue();
            }
        });
        for (Map.Entry<String, Integer> entry : sorted) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        StopWordFrequencyReport report = new StopWordFrequencyReport();
        report.printFilteredWordFrequency("The quick brown fox was in the forest and the fox was fast.");
    }
}
