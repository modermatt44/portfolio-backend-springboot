package ch.portfolio.portfoliobackend.controller;

import ch.portfolio.portfoliobackend.repository.LanguageRepository;
import ch.portfolio.portfoliobackend.model.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/delete_language")
    public String deleteLanguage(@RequestBody Language language) {
        // Delete a language object from the database
        if (languageRepository.findById(language.getId()).isPresent()) {
            languageRepository.deleteById(language.getId());
            return "Language deleted";
        } else {
            return "Language not found";
        }
    }

}
