package Week8.Assignment.AssignmentSubmission;

import java.time.LocalDate;

/**
 * Tracks a student's submission for an assignment.
 * Status must not be directly changeable from outside.
 */
public class Submission {
    private final Student student;
    private final Assignment assignment;
    private LocalDate submissionDate;
    private SubmissionStatus status;
    private int awardedMarks;

    public Submission(Student student, Assignment assignment, LocalDate submissionDate) {
        this.student = student;
        this.assignment = assignment;
        this.submissionDate = submissionDate;
        this.status = SubmissionStatus.SUBMITTED;
        this.awardedMarks = 0;
    }

    public Student getStudent() { return student; }
    public Assignment getAssignment() { return assignment; }
    public LocalDate getSubmissionDate() { return submissionDate; }
    public SubmissionStatus getStatus() { return status; }

    /**
     * Package-private: marks the submission as graded.
     * Once Graded, student cannot resubmit.
     */
    void grade(int awardedMarks) {
        if (status == SubmissionStatus.GRADED) {
            throw new IllegalStateException("Cannot grade an already graded submission.");
        }
        this.awardedMarks = awardedMarks;
        this.status = SubmissionStatus.GRADED;
    }

    /**
     * External resubmit is blocked after grading.
     */
    public void resubmit(LocalDate newDate) {
        if (status == SubmissionStatus.GRADED) {
            throw new IllegalStateException("Cannot resubmit: " + assignment.getTitle() + " has already been graded.");
        }
        this.submissionDate = newDate;
    }

    /**
     * Calculates final marks after applying the assignment's own late penalty.
     */
    public int getFinalMarks() {
        int lateDays = calculateLateDays();
        return assignment.calculateFinalMarks(awardedMarks, lateDays);
    }

    private int calculateLateDays() {
        if (!submissionDate.isAfter(assignment.getDueDate())) return 0;
        return (int) java.time.temporal.ChronoUnit.DAYS.between(assignment.getDueDate(), submissionDate);
    }

    @Override
    public String toString() {
        return student.getName() + "'s submission for " + assignment.getTitle()
                + " (" + submissionDate + "). Status: " + status
                + (status == SubmissionStatus.GRADED ? ", Awarded: " + awardedMarks + "/"+ assignment.getMaxMarks() + ", Final: " + getFinalMarks() : "");
    }
}
