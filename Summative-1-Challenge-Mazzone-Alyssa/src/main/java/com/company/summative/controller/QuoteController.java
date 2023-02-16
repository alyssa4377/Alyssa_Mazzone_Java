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
public class QuoteController {
    private List<Quote> quoteList;
    public QuoteController() {

        Quote q1 = new Quote("Michael Jordan", "I can accept failure, everyone fails at something. But I can't accept not trying");
        Quote q2 = new Quote("Michael Jordan", "My attitude is that if you push me towards something that you think is a weakness, then I will turn that perceived weakness into a strength");
        Quote q3 = new Quote("Michael Jordan", "Talent wins games, but teamwork and intelligence wins championships");
        Quote q4 = new Quote("Michael Jordan", "Heart is what separates the good from the great.");
        Quote q5 = new Quote("Michael Jordan", "Enjoy every minute of life. Never second-guess life.");
        Quote q6 = new Quote("Betty Reese", "If you think you are too small to be effective, you have never been in the dark with a mosquito.");
        Quote q7 = new Quote("Lisa Lieberman", "It’s okay to look at the past and the future. Just don’t stare.");
        Quote q8 = new Quote("Tina Fey", "My ability to turn good news into anxiety is rivaled only by my ability to turn anxiety into chin acne.");
        Quote q9 = new Quote("Unknown", "If we’re not meant to have midnight snacks, why is there a light in the fridge?");
        Quote q10 = new Quote("Abraham Lincoln", "The best thing about the future is that it comes one day at a time");

        quoteList = Arrays.asList(q1, q2, q3, q4, q5, q6, q7, q8, q9, q10);
    }
    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Quote getQuote() {
        Random rand = new Random();
        return quoteList.get(rand.nextInt(10));
    }
}
