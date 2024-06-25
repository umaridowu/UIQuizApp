package com.cs4md.uiquizapp;

public class Question {
    private String qText;
    private boolean correctAnswer;

    public Question (){
        qText = "this is coming";
        correctAnswer = true;
    }

    public Question(String qText, boolean correctAnswer) {
        this.qText = qText;
        this.correctAnswer = correctAnswer;
    }

    public void setqText(String qText) {
        this.qText = qText;
    }

    public boolean isCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(boolean correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getqText() {
        return qText;

    }

    @Override
    public String toString() {
        return "Question{" +
                "qText='" + qText + '\'' +
                ", correctAnswer=" + correctAnswer +
                '}';
    }
}
