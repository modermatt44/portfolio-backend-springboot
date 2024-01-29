package ch.portfolio.portfoliobackend;

import ch.portfolio.portfoliobackend.model.*;
import ch.portfolio.portfoliobackend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class PortfolioBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioBackendApplication.class, args);
	}

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

		//programRepository.deleteAll();
		//List<Program> programs = List.of(
		//		new Program("Microsoft Office", 4),
		//		new Program("Strapi", 4),
		//		new Program("IOS", 3),
		//		new Program("Android", 4),
		//		new Program("Figma", 4),
		//		new Program("Git", 4),
		//		new Program("Powershell", 2),
		//		new Program("Passkeys", 5),
		//		new Program("Jira", 3),
		//		new Program("Visual Studio Code", 4),
		//		new Program("IntelliJ", 3),
		//		new Program("Networking", 3),
		//		new Program("Jfrog Artifactory", 3),
		//		new Program("iAPC (Internal application cloud)", 3),
		//		new Program("iKube (Internal Kubernetes)", 4),
		//		new Program("ArgoCD", 3),
		//		new Program("Docker", 5),
		//		new Program("Windows", 4),
		//		new Program("Ubuntu", 3)
		//);
		//programRepository.saveAll(programs);
//
//
		//programmingLanguageRepository.deleteAll();
		//List<ProgrammingLanguage> programmingLanguages = List.of(
		//	new ProgrammingLanguage("SQL", 4),
		//	new ProgrammingLanguage("Kubernetes", 3),
		//	new ProgrammingLanguage("Python", 3),
		//	new ProgrammingLanguage("ThreeJS", 3),
		//	new ProgrammingLanguage("JavaScript", 4),
		//	new ProgrammingLanguage("ReactJS", 2),
		//	new ProgrammingLanguage("Angular", 2),
		//	new ProgrammingLanguage("HTML/CSS", 3),
		//	new ProgrammingLanguage("Flutter", 4),
		//	new ProgrammingLanguage("C#", 4),
		//	new ProgrammingLanguage("Java", 4),
		//	new ProgrammingLanguage("VueJS", 4),
		//	new ProgrammingLanguage("Blazor", 3),
		//	new ProgrammingLanguage("NOSQL", 2),
		//	new ProgrammingLanguage("Spring Boot", 4),
		//	new ProgrammingLanguage("Spring Security", 4),
		//	new ProgrammingLanguage("Groovy", 3)
		//);
		//programmingLanguageRepository.saveAll(programmingLanguages);
//
		//projectRepository.deleteAll();
		//List<Project> projects = List.of(
		//		new Project("First Steps", "Einführung ins Office 365 und Einrichtung der Swisscom internen Passwörter und Applikationen. Kennenlernen der Werte der Swisscom und Übungen in der Gesprächsführung. Ferner haben wir unsere Rechte und Pflichten im Arbeitsalltag besprochen.",
		//				"Cristina Ernst", "02.08.2021 bis 09.08.2021", 3),
		//		new Project("Swisscom Shop Flughafen", "Kennenlernen der Produkte von Swisscom und einstieg ins Berufsleben. Verkaufen von Prepaid Abos, Handy Hüllen und Gadgets. Erstellen von Illustrationen für den Flughafen Shop. Arbeiten im Backoffice.", "Jessica Schönbächler",
		//				"19.08.2021 bis 19.11.2021", 3.5),
		//		new Project("Minion Squad", "Entwickeln der Team Management App 'MyTeams' App mit dem Framework Blazor. Arbeiten mit C#, HTML und CSS. Ebenfalls mit Angular gearbeitet.", "Hussein Mcheik", "19.11.2021 bis 17.08.2022", 3),
		//		new Project("Group Security", "Einstieg in Group Security. Entwickeln von Blueprints für Security Lösungen mit Hilfe von Spring Boot, Spring Security, Docker, Kubernetes, iKube und Jfrog Artifacotry. Forschung im Bereich Passkey, passwortlose Authentisierung.", "Simon Leo",
		//				"01.03.2023 bis 28.02.2024", 4.5)
		//);
		//projectRepository.saveAll(projects);

		// GroceryItem item3 = new GroceryItem("3", "Banana", 15, "Fruit");
		// GroceryItem item4 = new GroceryItem("4", "Tomato", 20, "Vegetable");
		// GroceryItem item5 = new GroceryItem("5", "Potato", 25, "Vegetable");
	}
}
