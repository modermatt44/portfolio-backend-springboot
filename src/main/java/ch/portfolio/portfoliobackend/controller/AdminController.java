package ch.portfolio.portfoliobackend.controller;

import ch.portfolio.portfoliobackend.model.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import ch.portfolio.portfoliobackend.repository.LanguageRepository;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class AdminController {

    @Autowired
    public LanguageRepository languageRepository;

    @GetMapping("/admin")
    public String showAdmin(Model model, String title){

        //model.addAttribute("language", title);

        return "AdminPage";
    }

    @DeleteMapping("/delete_language_ui")
    public String deleteLanguage(@ModelAttribute("language") String title) {
        // Delete a language object from the database by title
        languageRepository.deleteByTitle(title);
        return "redirect:/admin";
    }
}
