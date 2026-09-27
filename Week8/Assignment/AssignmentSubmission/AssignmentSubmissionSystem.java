package Week8.Assignment.AssignmentSubmission;

import java.time.LocalDate;

/**
 * Demo class for the Assignment Submission Portal.
 */
public class AssignmentSubmissionSystem {
    public static void main(String[] args) {
        System.out.println("=== Assignment Submission Portal Demo ===\n");

        AssignmentPortal portal = new AssignmentPortal();

        CodingAssignment linkedListLab = new CodingAssignment(
                "CLL", "Linked List Lab", 50, LocalDate.of(2025, 3, 10));
        WrittenAssignment designEssay = new WrittenAssignment(
                "DE", "Design Essay", 50, LocalDate.of(2025, 3, 12));

        Student asha = new Student("S1", "Asha");
        Student ravi = new Student("S2", "Ravi");

        // Asha submits Linked List Lab on Mar 10 (on time)
        System.out.println("-- Coding Assignment: Linked List Lab --");
        System.out.println("max marks = 50, due = Mar 10");
        Submission ashaSub = portal.submitWork(asha, linkedListLab, LocalDate.of(2025, 3, 10));
        System.out.println();

        // Ravi submits Design Essay on Mar 14 (2 days late? No, Mar 12 due, Mar 14 = 2 days late)
        System.out.println("-- Written Assignment: Design Essay --");
        System.out.println("max marks = 50, due = Mar 12");
        Submission raviSub = portal.submitWork(ravi, designEssay, LocalDate.of(2025, 3, 14));
        int lateDays = (int) java.time.temporal.ChronoUnit.DAYS.between(designEssay.getDueDate(), raviSub.getSubmissionDate());
        System.out.println(lateDays + " days late");
        System.out.println();

        // Faculty awards Asha 45 marks
        System.out.println("-- Faculty awards Asha 45 marks --");
        portal.reviewAndGrade(asha, ashaSub, 45);
        System.out.println();

        // Faculty awards Ravi 40 marks (2 days late, 20% * 2 = 40% penalty)
        System.out.println("-- Faculty awards Ravi 40 marks --");
        portal.reviewAndGrade(ravi, raviSub, 40);
        System.out.println();

        // Asha attempts to resubmit (should fail)
        System.out.println("-- Asha attempts to resubmit Linked List Lab --");
        try {
            ashaSub.resubmit(LocalDate.of(2025, 3, 11));
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n=== Demo Complete ===");
    }
}
