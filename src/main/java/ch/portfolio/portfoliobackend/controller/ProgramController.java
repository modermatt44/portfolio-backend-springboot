package ch.portfolio.portfoliobackend.controller;

import ch.portfolio.portfoliobackend.model.Program;
import ch.portfolio.portfoliobackend.repository.ProgramRepository;
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
    public String deleteProgram(@RequestBody Program program) {
        // Delete a program object from the database
        if (programRepository.findById(program.getId()).isPresent()) {
            programRepository.deleteById(program.getId());
            return "Program deleted";
        } else {
            return "Program not found";
        }
    }
}
