package com.company.chatterbook.model;

public class ChatterPost {
    private String text;

    public ChatterPost(String text){
        this.setText(text);
    }
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
