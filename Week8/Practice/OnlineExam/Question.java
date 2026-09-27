package Week8.Practice.OnlineExam;

/**
 * Abstract base class for all question types.
 * Each subclass implements its own evaluation logic.
 */
public abstract class Question {
    private final String questionId;
    private final String text;
    private final int maxMarks;

    public Question(String questionId, String text, int maxMarks) {
        this.questionId = questionId;
        this.text = text;
        this.maxMarks = maxMarks;
    }

    public String getQuestionId() { return questionId; }
    public String getText() { return text; }
    public int getMaxMarks() { return maxMarks; }

    /**
     * Evaluates the given answer string and returns points earned.
     */
    public abstract int evaluate(String answer);

    /**
     * Returns a description of the question type.
     */
    public abstract String getQuestionType();
}
