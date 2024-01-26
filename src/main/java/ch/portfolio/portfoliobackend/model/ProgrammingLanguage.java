package ch.portfolio.portfoliobackend.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("programmingLanguages")
public class ProgrammingLanguage {
    private String title;
    private int rating;

    public ProgrammingLanguage(String title, int rating) {
        this.title = title;
        this.rating = rating;
    }
}
