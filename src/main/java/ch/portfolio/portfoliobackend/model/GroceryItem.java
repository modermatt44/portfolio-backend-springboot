package ch.portfolio.portfoliobackend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.annotation.processing.Generated;

@Document("groceryItems")
public class GroceryItem {
    private String name;
    private int quantity;
    private String category;

    public GroceryItem(String name, int quantity, String category) {
        this.name = name;
        this.quantity = quantity;
        this.category = category;
    }
}
