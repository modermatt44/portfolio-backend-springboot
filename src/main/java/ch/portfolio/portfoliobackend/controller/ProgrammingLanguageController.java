package ch.portfolio.portfoliobackend.controller;

import ch.portfolio.portfoliobackend.model.ProgrammingLanguage;
import ch.portfolio.portfoliobackend.repository.ProgrammingLanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProgrammingLanguageController {

    @Autowired
    private ProgrammingLanguageRepository programmingLanguageRepository;

    @GetMapping("/get_programming_language")
    public List<ProgrammingLanguage> getProgrammingLanguage() {
        // Return all programming languages from the database as a JSON array
        return programmingLanguageRepository.findAll();
    }

    @PostMapping("/post_programming_language")
    public ProgrammingLanguage postProgrammingLanguage(@RequestBody ProgrammingLanguage programmingLanguage) {
        // Create a new programming language object and save it to the database
        programmingLanguageRepository.save(programmingLanguage);
        return programmingLanguage;
    }

    @DeleteMapping("/delete_programming_language")
    public void deleteProgrammingLanguage(@RequestBody String title) {
        // Delete a programming language object from the database
        programmingLanguageRepository.deleteByTitle(title);
    }
}
