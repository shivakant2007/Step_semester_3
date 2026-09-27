package Week8.Practice.OnlineExam;

/**
 * True/False question.
 */
public class TrueFalseQuestion extends Question {
    private final boolean correctAnswer;
    public TrueFalseQuestion(String questionId, String text, int maxMarks, boolean correctAnswer) {
        super(questionId, text, maxMarks);
        this.correctAnswer = correctAnswer;
    }
    @Override
    public int evaluate(String answer) {
        boolean given = Boolean.parseBoolean(answer.trim());
        return given == correctAnswer ? getMaxMarks() : 0;
    }
    @Override
    public String getQuestionType() { return "TrueFalse"; }
    public boolean getCorrectAnswer() { return correctAnswer; }
}
