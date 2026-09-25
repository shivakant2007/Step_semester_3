// TrafficSignalStreakAnalyzer.java
public class TrafficSignalStreakAnalyzer {

    void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.length() == 0) {
            System.out.println("Empty signal log.");
            return;
        }

        char longestColor = signalLog.charAt(0);
        int longestStreak = 1;
        char currentColor = signalLog.charAt(0);
        int currentStreak = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == currentColor) {
                currentStreak++;
            } else {
                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                    longestColor = currentColor;
                }
                currentColor = signalLog.charAt(i);
                currentStreak = 1;
            }
        }

        if (currentStreak > longestStreak) {
            longestStreak = currentStreak;
            longestColor = currentColor;
        }

        String colorName = "";
        switch (longestColor) {
            case 'R': colorName = "Red"; break;
            case 'G': colorName = "Green"; break;
            case 'Y': colorName = "Yellow"; break;
            default: colorName = String.valueOf(longestColor); break;
        }

        System.out.println("Longest streak: " + colorName + " (" + longestColor + ")");
        System.out.println("Streak length: " + longestStreak);
    }

    public static void main(String[] args) {
        TrafficSignalStreakAnalyzer analyzer = new TrafficSignalStreakAnalyzer();

        System.out.println("Test 1: \"RRGGGYRR\"");
        analyzer.findLongestStreak("RRGGGYRR");

        System.out.println();
        System.out.println("Test 2: Single char \"R\"");
        analyzer.findLongestStreak("R");

        System.out.println();
        System.out.println("Test 3: Longest at beginning \"RRRGGGY\"");
        analyzer.findLongestStreak("RRRGGGY");

        System.out.println();
        System.out.println("Test 4: Longest at end \"GGGRRRR\"");
        analyzer.findLongestStreak("GGGRRRR");
    }
}
