package ch.portfolio.portfoliobackend.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("programs")
public class Program {
    private String title;
    private int rating;

    public Program(String title, int rating) {
        this.title = title;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public int getRating() {
        return rating;
    }
}
