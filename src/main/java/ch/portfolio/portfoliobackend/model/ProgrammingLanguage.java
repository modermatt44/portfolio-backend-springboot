package ch.portfolio.portfoliobackend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("programmingLanguages")
public class ProgrammingLanguage {

    @Id
    private String id;
    private String title;
    private int rating;

    public ProgrammingLanguage(String title, int rating) {
        this.title = title;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getRating() {
        return rating;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
