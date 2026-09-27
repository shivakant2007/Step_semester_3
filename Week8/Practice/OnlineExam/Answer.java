package Week8.Practice.OnlineExam;

/**
 * Records a student's answer to a question.
 */
public class Answer {
    private final Question question;
    private final String studentAnswer;

    public Answer(Question question, String studentAnswer) {
        this.question = question;
        this.studentAnswer = studentAnswer;
    }

    public Question getQuestion() { return question; }
    public String getStudentAnswer() { return studentAnswer; }
    public int getPointsEarned() { return question.evaluate(studentAnswer); }
}
