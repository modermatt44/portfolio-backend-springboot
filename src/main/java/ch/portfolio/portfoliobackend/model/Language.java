package ch.portfolio.portfoliobackend.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("languages")
public class Language {
    private String title;
    private int rating;

    public Language(String title, int rating) {
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
