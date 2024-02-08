package ch.portfolio.portfoliobackend.repository;


import ch.portfolio.portfoliobackend.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<UserModel, String> {
    @Query("{ 'username' : ?0 }")
    UserModel findByUsername(String username);

    // existsByUsername
    boolean existsByUsername(String username);
}
