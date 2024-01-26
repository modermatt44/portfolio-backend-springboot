package ch.portfolio.portfoliobackend.controller;

import ch.portfolio.portfoliobackend.repository.LanguageRepository;
import ch.portfolio.portfoliobackend.model.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LanguageController {

    @Autowired
    private LanguageRepository languageRepository;

    @GetMapping("/get_language")
    public List<Language> getLanguage() {
        // Return all languages from the database as a JSON array
        return languageRepository.findAll();
    }

    @PostMapping("/post_language")
    public Language postLanguage(@RequestBody Language language) {
        // Create a new language object and save it to the database
        languageRepository.save(language);
        return language;
    }
}
