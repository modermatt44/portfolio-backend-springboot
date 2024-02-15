package ch.portfolio.portfoliobackend.repository;

import ch.portfolio.portfoliobackend.model.Language;
import ch.portfolio.portfoliobackend.model.Program;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramRepository extends MongoRepository<Program, String> {
    @Query("{ 'title' : ?0 }")
    Language findByTitle(String title);

    @Query("{'rating' : ?0}")
    Language findByRating(int rating);

    public long count();

    @Query(value="{ 'title' : ?0 }", delete = true)
    public void deleteByTitle(String title);
}
