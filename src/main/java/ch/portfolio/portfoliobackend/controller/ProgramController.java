package ch.portfolio.portfoliobackend.controller;

import ch.portfolio.portfoliobackend.model.Program;
import ch.portfolio.portfoliobackend.repository.ProgramRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProgramController {

    @Autowired
    private ProgramRepository programRepository;

    @GetMapping("/get_program")
    public List<Program> getProgram() {
        // Return all programs from the database as a JSON array
        return programRepository.findAll();
    }

    @PostMapping("/post_program")
    public Program postProgram(@RequestBody Program program) {
        // Create a new program object and save it to the database
        programRepository.save(program);
        return program;
    }

    @DeleteMapping("/delete_program")
    public void deleteProgram(@RequestBody String title) {
        // Delete a program object from the database
        programRepository.deleteByTitle(title);
    }
}
