package ch.portfolio.portfoliobackend.repository;

import ch.portfolio.portfoliobackend.model.Language;
import ch.portfolio.portfoliobackend.model.Project;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends MongoRepository<Project, String>{
    @Query("{ 'title' : ?0 }")
    Language findByTitle(String title);

    @Query("{'rating' : ?0}")
    Language findByRating(int rating);

    @Query("{'projectProvider' : ?0}")
    Language findByProjectProvider(String projectProvider);

    @Query("{'timeRange' : ?0}")
    Language findByTimeRange(String timeRange);

    @Query("{'description' : ?0}")
    Language findByDescription(String description);

    public long count();

    @Query(value="{ 'title' : ?0 }", delete = true)
    public void deleteByTitle(String title);
}
