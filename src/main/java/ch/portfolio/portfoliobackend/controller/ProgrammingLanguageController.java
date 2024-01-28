package ch.portfolio.portfoliobackend.controller;

import ch.portfolio.portfoliobackend.model.ProgrammingLanguage;
import ch.portfolio.portfoliobackend.repository.ProgrammingLanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
