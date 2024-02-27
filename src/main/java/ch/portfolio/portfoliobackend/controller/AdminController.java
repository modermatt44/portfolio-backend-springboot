package ch.portfolio.portfoliobackend.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Controller
public class AdminController {

    @Value("${oauthAttribute}")
    private String oauthAttribute;

    @Value("${oauthAttributeValue}")
    private String oauthAttributeValue;

    @Value("${oauthAttributeGithub}")
    private String oauthAttributeGithub;

    @Value("${oauthAttributeValueGithub}")
    private String oauthAttributeValueGithub;

    // TODO: Add a proper implementation for the role configuration
    public void configureRoles(@AuthenticationPrincipal OAuth2User user){
        if (Objects.equals(user.getAttribute(oauthAttribute), oauthAttributeValue) || Objects.equals(user.getAttribute(oauthAttributeGithub), oauthAttributeValueGithub)){
            Collection<GrantedAuthority> authorities = new ArrayList<>(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
            GrantedAuthority targetAuthority = new SimpleGrantedAuthority("ROLE_ADMIN");
            authorities.add(targetAuthority);

            Authentication newAuth = new UsernamePasswordAuthenticationToken(
                    SecurityContextHolder.getContext().getAuthentication().getPrincipal(),
                    SecurityContextHolder.getContext().getAuthentication().getCredentials(),
                    authorities
            );

            SecurityContextHolder.getContext().setAuthentication(newAuth);
        }
    }

    public boolean validateUser(@AuthenticationPrincipal OAuth2User user){
        GrantedAuthority targetAuthority = new SimpleGrantedAuthority("ROLE_ADMIN");
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(targetAuthority);
        //return Objects.equals(user.getAttribute(oauthAttribute), oauthAttributeValue) || Objects.equals(user.getAttribute("login"), "modermatt44");
    }

    @GetMapping("/admin")
    public String showAdmin(Model model, @AuthenticationPrincipal OAuth2User user) {

        configureRoles(user);

        if (!validateUser(user)) {
            return "error-403";
        }

        model.addAttribute("username", "Hello " + user.getAttribute("name"));

        if (user.getAttribute("avatar_url") != null){
            model.addAttribute("userAvatar", user.getAttribute("avatar_url"));
            model.addAttribute("iss" , "/github.png");
        } else {
            model.addAttribute("userAvatar", user.getAttribute("picture"));
            model.addAttribute("iss" , "/google.jpg");
        }

        return "AdminPage";
    }
}
