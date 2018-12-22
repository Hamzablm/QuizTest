package com.example.devfest.quizapp;

/**
 * This class encapsulate "text answer id" and the answer.
 */
public class Question {

    private int testResId;
    private boolean AnswerTrue;

    public Question(int testResId, boolean answerTrue) {
        this.testResId = testResId;
        AnswerTrue = answerTrue;
    }

    public int getTestResId() {
        return testResId;
    }

    public void setTestResId(int testResId) {
        this.testResId = testResId;
    }

    public boolean isAnswerTrue() {
        return AnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        AnswerTrue = answerTrue;
    }

}
