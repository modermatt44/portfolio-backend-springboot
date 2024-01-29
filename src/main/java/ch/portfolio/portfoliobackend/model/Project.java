package ch.portfolio.portfoliobackend.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("projects")
public class Project {
    private String title;
    private String description;
    private String projectProvider;
    private String timeRange;
    private double rating;

    public Project(String title, String description, String projectProvider, String timeRange, double rating) {
        this.title = title;
        this.description = description;
        this.projectProvider = projectProvider;
        this.timeRange = timeRange;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getProjectProvider() {
        return projectProvider;
    }

    public String getTimeRange() {
        return timeRange;
    }

    public double getRating() {
        return rating;
    }
}
