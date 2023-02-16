package com.company.summative.controller;
import com.company.summative.model.Definition;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.company.summative.model.Answer;
import com.company.summative.model.Quote;
import java.util.List;
import java.util.Arrays;
import java.util.Random;

@RestController
public class AnswerController {
    private List<Answer> answerList;

    public AnswerController() {
        Answer a1 = new Answer("What color is the Sky?", "Blue");
        Answer a2 = new Answer("What is the capital of Maryland?", "Annapolis");
        Answer a3 = new Answer("How many stars are on the American Flag?", "50 stars");
        Answer a4 = new Answer("Who is the NBA logo?", "Jerry West");
        Answer a5 = new Answer("What year was Netflix founded?", "Netflix was founded in the year 1997");
        Answer a6 = new Answer("What is the loudest animal on earth?", "A whale");
        Answer a7 = new Answer("In what city is the University of Maryland located?", "College Park");
        Answer a8 = new Answer("What is the tiny piece at the end of your shoe lace called?", "An aglet");
        Answer a9 = new Answer("Oh say can you see... What is the name of this song?", "The national Anthem");
        Answer a10 = new Answer("What eye color do most humans have?", "Brown");

        answerList = Arrays.asList(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10);
    }
    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Answer postQuestionAndAnswer(@RequestBody Answer question) {

        if (question.getQuestion().equals("") && question.getAnswer().equals("")) {
            Random rand = new Random();
            String newAnswer = answerList.get(rand.nextInt(10)).getAnswer();
            String newQuestion = answerList.get(rand.nextInt(10)).getQuestion();
            Answer answer = new Answer(newQuestion, newAnswer);
            return answer;
        }else if(!question.getQuestion().equals("")){
            Random rand = new Random();
            String newAnswer = answerList.get(rand.nextInt(10)).getAnswer();
            Answer answer = new Answer (question.getQuestion(), newAnswer);
            return answer;
        }else{
            Random rand = new Random();
            String newAnswer = answerList.get(rand.nextInt(10)).getAnswer();
            String newQuestion = answerList.get(rand.nextInt(10)).getQuestion();
            Answer answer = new Answer(newQuestion, newAnswer);
            return answer;
        }
    }
}