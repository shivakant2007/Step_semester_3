package Week8.Assignment.AssignmentSubmission;

import java.time.LocalDate;

/**
 * Abstract base class for assignments.
 * Each assignment type implements its own late penalty rule.
 */
public abstract class Assignment {
    private final String assignmentId;
    private final String title;
    private final int maxMarks;
    private final LocalDate dueDate;

    public Assignment(String assignmentId, String title, int maxMarks, LocalDate dueDate) {
        this.assignmentId = assignmentId;
        this.title = title;
        this.maxMarks = maxMarks;
        this.dueDate = dueDate;
    }
    public String getAssignmentId() { return assignmentId; }
    public String getTitle() { return title; }
    public int getMaxMarks() { return maxMarks; }
    public LocalDate getDueDate() { return dueDate; }
    public abstract double calculateLatePenalty(int lateDays);
    public int calculateFinalMarks(int awardedMarks, int lateDays) {
        double penaltyRatio = calculateLatePenalty(lateDays);
        return (int) Math.round(awardedMarks * (1.0 - penaltyRatio));
    }
    @Override
    public String toString() { return title + " [" + assignmentId + "] (max " + maxMarks + " marks)"; }
}

/**
 * Coding assignment: 10% penalty per day late.
 */
class CodingAssignment extends Assignment {
    public CodingAssignment(String assignmentId, String title, int maxMarks, LocalDate dueDate) {
        super(assignmentId, title, maxMarks, dueDate);
    }
    @Override
    public double calculateLatePenalty(int lateDays) { return 0.10 * lateDays; }
}

/**
 * Written assignment: 20% penalty per day late.
 */
class WrittenAssignment extends Assignment {
    public WrittenAssignment(String assignmentId, String title, int maxMarks, LocalDate dueDate) {
        super(assignmentId, title, maxMarks, dueDate);
    }
    @Override
    public double calculateLatePenalty(int lateDays) { return 0.20 * lateDays; }
}
