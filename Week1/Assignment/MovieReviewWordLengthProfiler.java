// MovieReviewWordLengthProfiler.java
public class MovieReviewWordLengthProfiler {

    void classifyWordLengths(String review) {
        int shortCount = 0, mediumCount = 0, longCount = 0;

        String[] words = review.split("\\s+");
        for (String word : words) {
            int len = word.replaceAll("[^a-zA-Z]", "").length();
            if (len == 0) continue;

            if (len >= 1 && len <= 4) {
                shortCount++;
            } else if (len >= 5 && len <= 8) {
                mediumCount++;
            } else {
                longCount++;
            }
        }

        System.out.println("Short (1-4 letters): " + shortCount);
        System.out.println("Medium (5-8 letters): " + mediumCount);
        System.out.println("Long (9+ letters): " + longCount);
    }

    public static void main(String[] args) {
        MovieReviewWordLengthProfiler profiler = new MovieReviewWordLengthProfiler();

        String review = "The movie was absolutely fantastic and thoroughly entertaining.";
        System.out.println("Review: \"" + review + "\"");
        profiler.classifyWordLengths(review);
    }
}
