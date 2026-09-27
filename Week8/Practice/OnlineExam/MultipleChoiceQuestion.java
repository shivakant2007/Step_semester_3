package Week8.Practice.OnlineExam;

/**
 * Multiple choice question with a single correct option.
 */
public class MultipleChoiceQuestion extends Question {
    private final String correctOption;
    public MultipleChoiceQuestion(String questionId, String text, int maxMarks, String correctOption) {
        super(questionId, text, maxMarks);
        this.correctOption = correctOption;
    }
    @Override
    public int evaluate(String answer) {
        return correctOption.equalsIgnoreCase(answer.trim()) ? getMaxMarks() : 0;
    }
    @Override
    public String getQuestionType() { return "MultipleChoice"; }
    public String getCorrectOption() { return correctOption; }
}
