package Week8.Practice.OnlineExam;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Tracks a student's attempt on an examination.
 * State can be InProgress or Submitted.
 * Once submitted, answers cannot be changed.
 */
public class Attempt {
    public enum AttemptState { IN_PROGRESS, SUBMITTED }

    private final Student student;
    private final Examination examination;
    private final Map<String, String> answers;
    private AttemptState state;

    public Attempt(Student student, Examination examination) {
        this.student = student;
        this.examination = examination;
        this.answers = new LinkedHashMap<>();
        this.state = AttemptState.IN_PROGRESS;
    }

    public Student getStudent() { return student; }
    public Examination getExamination() { return examination; }
    public AttemptState getState() { return state; }

    /**
     * Records an answer to a question. Only allowed when InProgress.
     */
    public void recordAnswer(Question question, String answer) {
        if (state == AttemptState.SUBMITTED) {
            throw new IllegalStateException(
                    "Cannot modify answers for a submitted examination.");
        }
        answers.put(question.getQuestionId(), answer);
    }

    /**
     * Submits the attempt. Locks all answers.
     */
    public void submit() {
        if (state == AttemptState.SUBMITTED) {
            throw new IllegalStateException("Attempt already submitted.");
        }
        this.state = AttemptState.SUBMITTED;
    }

    /**
     * Returns the recorded answer for a question, or null if not answered.
     */
    public String getRecordedAnswer(String questionId) {
        return answers.get(questionId);
    }

    /**
     * Evaluates all recorded answers and returns the total score.
     */
    public int calculateScore() {
        int total = 0;
        for (Map.Entry<String, String> entry : answers.entrySet()) {
            Question q = examination.getQuestionById(entry.getKey());
            if (q != null) {
                total += q.evaluate(entry.getValue());
            }
        }
        return total;
    }

    /**
     * Returns detailed results for each question.
     */
    public Map<String, Integer> getDetailedResults() {
        Map<String, Integer> results = new LinkedHashMap<>();
        for (Map.Entry<String, String> entry : answers.entrySet()) {
            Question q = examination.getQuestionById(entry.getKey());
            if (q != null) {
                results.put(q.getQuestionId(), q.evaluate(entry.getValue()));
            }
        }
        return results;
    }

    public Map<String, String> getAllAnswers() { return answers; }
}
