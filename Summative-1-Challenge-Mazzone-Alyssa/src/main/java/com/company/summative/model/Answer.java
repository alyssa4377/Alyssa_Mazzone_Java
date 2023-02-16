package com.company.summative.model;
import java.util.Random;
public class Answer {

    private String answer;
    private int id;
    private String question;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Answer(String question, String answer){
        this.setQuestion(question);
        this.setAnswer(answer);
        Random rand = new Random();
        this.id = rand.nextInt(10);
    }
}
