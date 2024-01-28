package ch.portfolio.portfoliobackend;

import ch.portfolio.portfoliobackend.model.*;
import ch.portfolio.portfoliobackend.repository.*;
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

	@Autowired
	public ProgramRepository programRepository;

	@Autowired
	public ProgrammingLanguageRepository programmingLanguageRepository;

	@Autowired
	public ProjectRepository projectRepository;

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

		Language language2 = new Language("Französisch", 4);
		languageRepository.save(language2);

		programRepository.deleteAll();
		Program program1 = new Program("Docker", 5);
		Program program2 = new Program("Windows", 4);
		Program program3 = new Program("Ubuntu", 3);
		programRepository.save(program1);
		programRepository.save(program2);
		programRepository.save(program3);

		programmingLanguageRepository.deleteAll();
		ProgrammingLanguage programmingLanguage1 = new ProgrammingLanguage("Java", 5);
		ProgrammingLanguage programmingLanguage2 = new ProgrammingLanguage("C#", 4);
		ProgrammingLanguage programmingLanguage3 = new ProgrammingLanguage("C++", 3);
		programmingLanguageRepository.save(programmingLanguage1);
		programmingLanguageRepository.save(programmingLanguage2);
		programmingLanguageRepository.save(programmingLanguage3);

		projectRepository.deleteAll();
		Project project1 = new Project("Minion", "Minion Things", "Elma", "20 bis 30", 4);
		Project project2 = new Project("Minion2", "Minion Things2", "Elma2", "20 bis 302", 4);
		Project project3 = new Project("Minion3", "Minion Things3", "Elma3", "20 bis 330", 4);
		projectRepository.save(project1);
		projectRepository.save(project2);
		projectRepository.save(project3);

		// GroceryItem item3 = new GroceryItem("3", "Banana", 15, "Fruit");
		// GroceryItem item4 = new GroceryItem("4", "Tomato", 20, "Vegetable");
		// GroceryItem item5 = new GroceryItem("5", "Potato", 25, "Vegetable");
	}
}
