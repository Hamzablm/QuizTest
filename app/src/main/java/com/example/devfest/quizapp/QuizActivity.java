package com.example.devfest.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private TextView testTv;
    private Button falseButton;
    private Button trueButton;
    private Button nextBtn;
    private Button previous;
    private Question[] questions = {
            new Question(R.string.test_1, true),
            new Question(R.string.test_2, false),
            new Question(R.string.test_3, true),
            new Question(R.string.test_4, true),
            new Question(R.string.test_5, true),
            new Question(R.string.test_6, true),
            new Question(R.string.test_7, false),
            new Question(R.string.test_8, true),
            new Question(R.string.test_9, true),
            new Question(R.string.test_10, true),
    };
    private int index;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        testTv = findViewById(R.id.test_tv);
        final int question= questions[index].getTestResId();
        testTv.setText(question);

        falseButton = findViewById(R.id.false_btn_id);
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        trueButton = findViewById(R.id.true_btn_id);
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             checkAnswer(true);
            }
        });

        nextBtn = findViewById(R.id.next_btn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index = (index + 1) % questions.length;
                updateQuestion();
            }
        });

        previous = findViewById(R.id.previous_btn);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index = (index - 1) % questions.length;
                if (index < 0) index = questions.length - 1;
                updateQuestion();
            }
        });

        updateQuestion();
    }

    private void checkAnswer(boolean userPressed) {
        boolean answerBool = questions[index].isAnswerTrue();

        int messageResId;

        if (userPressed == answerBool) {
            messageResId = R.string.correct_toast;
        } else {
            messageResId = R.string.incorrect_toast;
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }

    private void updateQuestion() {
        int question = questions[index].getTestResId();
        testTv.setText(question);
    }

}
