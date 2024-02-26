package ch.portfolio.portfoliobackend.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Objects;

@Controller
public class AdminController {

    @Value("${oauthAttribute}")
    private String oauthAttribute;

    @Value("${oauthAttributeValue}")
    private String oauthAttributeValue;

    public boolean validateUser(@AuthenticationPrincipal OAuth2User user) {
      return Objects.equals(user.getAttribute(oauthAttribute), oauthAttributeValue);
    }

    @GetMapping("/admin")
    public String showAdmin(Model model, @AuthenticationPrincipal OAuth2User user){

        if (!validateUser(user)) {
            return "error-403";
        }

        model.addAttribute("username", "Hello " + user.getAttribute("name"));

        return "AdminPage";
    }
}
