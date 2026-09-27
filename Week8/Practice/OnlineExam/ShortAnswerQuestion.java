package Week8.Practice.OnlineExam;

/**
 * Short answer question evaluated by case-insensitive equality.
 */
public class ShortAnswerQuestion extends Question {
    private final String correctAnswer;
    public ShortAnswerQuestion(String questionId, String text, int maxMarks, String correctAnswer) {
        super(questionId, text, maxMarks);
        this.correctAnswer = correctAnswer;
    }
    @Override
    public int evaluate(String answer) {
        return correctAnswer.equalsIgnoreCase(answer.trim()) ? getMaxMarks() : 0;
    }
    @Override
    public String getQuestionType() { return "ShortAnswer"; }
    public String getCorrectAnswer() { return correctAnswer; }
}
