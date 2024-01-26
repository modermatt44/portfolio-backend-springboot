package ch.portfolio.portfoliobackend.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("projects")
public class Project {
    private String title;
    private String description;
    private String projectProvider;
    private String timeRange;
    private int rating;

    public Project(String title, String description, String projectProvider, String timeRange, int rating) {
        this.title = title;
        this.description = description;
        this.projectProvider = projectProvider;
        this.timeRange = timeRange;
        this.rating = rating;
    }
}
