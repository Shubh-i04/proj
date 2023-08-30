import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
public class QuizApplication extends Frame {
    private int currentQuestionIndex = 0;
    private int score = 0;
    private String[] questions = {
            "What is the capital of France?",
            "What is the largest mammal?",
            "What is 3 + 5?",
    };
    private String[] correctAnswers = {
            "Paris",
            "Blue Whale",
            "8",
    };
    private Label questionLabel;
    private TextField answerField;
    private Button submitButton;

    public QuizApplication() {
        setTitle("Quiz Application");
        setSize(400, 200);
        setLayout(new FlowLayout());

        questionLabel = new Label();
        add(questionLabel, BorderLayout.CENTER);

        Panel answerPanel = new Panel();
        answerField = new TextField(20);
        answerPanel.add(answerField);

        submitButton = new Button("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
            }
        }
             addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
};
        answerPanel.add(submitButton);

        add(answerPanel, BorderLayout.SOUTH);

        updateQuestion();
    }

    private void updateQuestion() {
        if (currentQuestionIndex < questions.length) {
            questionLabel.setText(questions[currentQuestionIndex]);
            answerField.setText("");
        } else {
            showResult();
        }
    }

    private void checkAnswer() {
        String userAnswer = answerField.getText().trim();
        if (userAnswer.equalsIgnoreCase(correctAnswers[currentQuestionIndex])) {
            score++;
        }
        currentQuestionIndex++;
        updateQuestion();
    }

    private void showResult() {
        remove(questionLabel);
        remove(answerField);
        remove(submitButton);

        Label resultLabel = new Label("Quiz completed! Your score: " + score + "/" + questions.length);
        add(resultLabel, BorderLayout.CENTER);

        validate();
    }

    public static void main(String[] args) {
        QuizApplication quizApp = new QuizApplication();
        quizApp.setVisible(true);
    }
}
