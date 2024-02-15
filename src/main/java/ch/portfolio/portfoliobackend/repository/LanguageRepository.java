package ch.portfolio.portfoliobackend.repository;

import ch.portfolio.portfoliobackend.model.Language;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends MongoRepository<Language, String> {

    @Query("{ 'title' : ?0 }")
    String findByTitle(String title);

    @Query("{'rating' : ?0}")
    Integer findByRating(int rating);

    public long count();

    @Query(value="{ 'title' : ?0 }", delete = true)
    public void deleteByTitle(String title);
}
