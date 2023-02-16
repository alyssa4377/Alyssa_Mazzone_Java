package com.company.summative.model;
import java.util.Random;

public class Definition {

    private String word;
    private int id;
    private String definition;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public Definition(String word, String definition){
        this.setWord(word);
        this.setDefinition(definition);
        Random rand = new Random();
        this.id = rand.nextInt(10);
    }
}
