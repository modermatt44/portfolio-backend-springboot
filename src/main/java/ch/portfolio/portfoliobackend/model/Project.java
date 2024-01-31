package ch.portfolio.portfoliobackend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("projects")
public class Project {

    @Id
    private String id;
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

    public String getId() {
        return id;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProjectProvider(String projectProvider) {
        this.projectProvider = projectProvider;
    }

    public void setTimeRange(String timeRange) {
        this.timeRange = timeRange;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
