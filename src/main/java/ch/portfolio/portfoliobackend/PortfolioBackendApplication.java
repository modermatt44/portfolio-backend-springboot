package ch.portfolio.portfoliobackend;

import ch.portfolio.portfoliobackend.model.GroceryItem;
import ch.portfolio.portfoliobackend.model.Language;
import ch.portfolio.portfoliobackend.repository.ItemRepository;
import ch.portfolio.portfoliobackend.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PortfolioBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioBackendApplication.class, args);
	}

	@Autowired
	public ItemRepository itemRepository;

	@Autowired
	public LanguageRepository languageRepository;

	@Override
	public void run(String... args) throws Exception {
		// write data inside the database
		itemRepository.deleteAll();
		GroceryItem item1 = new GroceryItem("Apple", 5, "Fruit");
		itemRepository.save(item1);

		GroceryItem item2 = new GroceryItem("Orange", 10, "Fruit");
		itemRepository.save(item2);

		languageRepository.deleteAll();
		Language language1 = new Language("Deutsch", 5);
		languageRepository.save(language1);
		// GroceryItem item3 = new GroceryItem("3", "Banana", 15, "Fruit");
		// GroceryItem item4 = new GroceryItem("4", "Tomato", 20, "Vegetable");
		// GroceryItem item5 = new GroceryItem("5", "Potato", 25, "Vegetable");
	}
}
