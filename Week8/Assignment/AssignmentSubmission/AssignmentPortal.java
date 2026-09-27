package Week8.Assignment.AssignmentSubmission;

import java.time.LocalDate;

/**
 * Core assignment submission portal workflow.
 * Adding a new assignment type does NOT require modifying this class.
 */
public class AssignmentPortal {
    /**
     * Submits work for an assignment.
     */
    public Submission submitWork(Student student, Assignment assignment, LocalDate submissionDate) {
        Submission sub = new Submission(student, assignment, submissionDate);
        String timing = submissionDate.isAfter(assignment.getDueDate())
                ? calculateDaysLate(submissionDate, assignment.getDueDate()) + " days late"
                : "on time";
        System.out.println(student.getName() + "'s submission for " + assignment.getTitle()
                + " received (" + timing + ").");
        System.out.println("Status: " + sub.getStatus());
        return sub;
    }

    /**
     * Grades a submission with awarded marks.
     */
    public void gradeSubmission(Submission submission, int awardedMarks) {
        submission.grade(awardedMarks);
        System.out.println("Graded: " + awardedMarks + "/" + submission.getAssignment().getMaxMarks());
        System.out.println("Final marks: " + submission.getFinalMarks() + "/" + submission.getAssignment().getMaxMarks());
        System.out.println("Status: " + submission.getStatus());
    }

    /**
     * Attempts to grade a submission, printing full results.
     */
    public void reviewAndGrade(Student student, Submission submission, int awardedMarks) {
        int lateDays = calculateDaysLate(submission.getSubmissionDate(), submission.getAssignment().getDueDate());
        submission.grade(awardedMarks);
        System.out.println("\nGrading " + student.getName() + "'s " + submission.getAssignment().getTitle() + ":");
        System.out.println("Awarded: " + awardedMarks + "/" + submission.getAssignment().getMaxMarks());
        System.out.println("Late days: " + lateDays + ", Penalty: " + (int)(submission.getAssignment().calculateLatePenalty(lateDays) * 100) + "%");
        System.out.println("Final marks: " + submission.getFinalMarks() + "/" + submission.getAssignment().getMaxMarks());
        System.out.println("Status: " + submission.getStatus());
    }

    private int calculateDaysLate(LocalDate date, LocalDate dueDate) {
        if (date.isAfter(dueDate)) {
            return (int) java.time.temporal.ChronoUnit.DAYS.between(dueDate, date);
        }
        return 0;
    }
}
