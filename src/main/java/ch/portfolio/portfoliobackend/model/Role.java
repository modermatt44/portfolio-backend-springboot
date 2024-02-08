package ch.portfolio.portfoliobackend.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document("roles")
public class Role {

    @Id
    private ObjectId id;

    private String role;

    @DBRef
    private List<UserModel> users;

    public Role(String role) {
        this.role = role;
    }

    public ObjectId getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public List<UserModel> getUsers() {
        return users;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setUsers(List<UserModel> users) {
        this.users = users;
    }
}
