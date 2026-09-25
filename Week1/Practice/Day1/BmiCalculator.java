public class BmiCalculator {

    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25.0) {
            return "Normal";
        } else if (bmi < 30.0) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        System.out.printf("%-10s | %-15s | %-15s | %-10s | %-12s%n", "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("--------------------------------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);
            System.out.printf("%-10d | %-15.2f | %-15.2f | %-10.2f | %-12s%n", (i + 1), heights[i], weights[i], bmi, status);
        }
    }

    public static void main(String[] args) {
        double[] heights = {1.70, 1.65, 1.80, 1.55, 1.75};
        double[] weights = {65.0, 50.0, 90.0, 45.0, 78.0};

        printWellnessReport(heights, weights);
    }
}
