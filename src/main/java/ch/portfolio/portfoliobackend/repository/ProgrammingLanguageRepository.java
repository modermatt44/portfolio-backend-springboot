package ch.portfolio.portfoliobackend.repository;

import ch.portfolio.portfoliobackend.model.Language;
import ch.portfolio.portfoliobackend.model.ProgrammingLanguage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ProgrammingLanguageRepository extends MongoRepository<ProgrammingLanguage, String> {
    @Query("{ 'title' : ?0 }")
    Language findByTitle(String title);

    @Query("{'rating' : ?0}")
    Language findByRating(int rating);

    public long count();
}
