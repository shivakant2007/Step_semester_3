package Week8.Practice.OnlineExam;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an examination containing multiple questions.
 */
public class Examination {
    private final String examId;
    private final String title;
    private final List<Question> questions;

    public Examination(String examId, String title) {
        this.examId = examId;
        this.title = title;
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public List<Question> getQuestions() { return questions; }
    public String getExamId() { return examId; }
    public String getTitle() { return title; }

    public Question getQuestionById(String questionId) {
        for (Question q : questions) {
            if (q.getQuestionId().equals(questionId)) return q;
        }
        return null;
    }

    public int getTotalMarks() {
        int total = 0;
        for (Question q : questions) total += q.getMaxMarks();
        return total;
    }

    /**
     * Starts a new attempt for the given student.
     */
    public Attempt startAttempt(Student student) {
        return new Attempt(student, this);
    }

    @Override
    public String toString() { return title + " [" + examId + "] (" + questions.size() + " questions)"; }
}
