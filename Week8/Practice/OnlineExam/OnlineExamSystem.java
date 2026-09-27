package Week8.Practice.OnlineExam;

import java.util.Map;

/**
 * Demo class for the Online Examination System.
 */
public class OnlineExamSystem {
    public static void main(String[] args) {
        System.out.println("=== Online Examination System Demo ===\n");

        // Create Exam A
        Examination examA = new Examination("EXAM-A", "Exam A");
        Question q1 = new MultipleChoiceQuestion("Q1", "What is 2+2?", 5, "C");
        Question q2 = new TrueFalseQuestion("Q2", "The Earth is flat.", 5, false);
        examA.addQuestion(q1);
        examA.addQuestion(q2);

        System.out.println("Exam created: " + examA);
        System.out.println("Total marks available: " + examA.getTotalMarks() + "\n");

        Student student1 = new Student("S1", "Student 1");

        // Student 1 starts Exam A
        System.out.println("-- Student 1 starts Exam A --");
        Attempt attempt = examA.startAttempt(student1);
        System.out.println("Exam A started by " + student1.getName() + ".\n");

        // Answer Question 1 with option C
        System.out.println("-- Student 1 answers Q1 (MCQ) with option C --");
        attempt.recordAnswer(q1, "C");
        System.out.println("Answer recorded for Q1.\n");

        // Answer Question 2 with True
        System.out.println("-- Student 1 answers Q2 (True/False) with True --");
        attempt.recordAnswer(q2, "True");
        System.out.println("Answer recorded for Q2.\n");

        // Submit Exam A
        System.out.println("-- Student 1 submits Exam A --");
        attempt.submit();
        System.out.println("Exam A submitted by " + student1.getName() + ".\n");

        // Calculate results
        Map<String, Integer> results = attempt.getDetailedResults();
        int totalScore = attempt.calculateScore();
        int maxScore = examA.getTotalMarks();

        System.out.println("=== Result ===");
        for (Map.Entry<String, Integer> entry : results.entrySet()) {
            Question q = examA.getQuestionById(entry.getKey());
            String label = q.getQuestionType() + " [" + q.getQuestionId() + "]";
            String correct = "Correct";
            if (entry.getValue() == 0) correct = "Incorrect";
            System.out.println(label + ": " + correct + " (" + entry.getValue() + " points)");
        }
        System.out.println("Total score: " + totalScore + "/" + maxScore + "\n");

        // Attempt to change answer after submission
        System.out.println("-- Student 1 attempts to change answer for Q1 --");
        try {
            attempt.recordAnswer(q1, "A");
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n=== Demo Complete ===");
    }
}
