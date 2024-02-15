package ch.portfolio.portfoliobackend.controller;

import ch.portfolio.portfoliobackend.config.JWTGenerator;
import ch.portfolio.portfoliobackend.dto.AuthResponseDto;
import ch.portfolio.portfoliobackend.dto.LoginDto;
import ch.portfolio.portfoliobackend.dto.RegisterDto;
import ch.portfolio.portfoliobackend.model.Role;
import ch.portfolio.portfoliobackend.model.UserModel;
import ch.portfolio.portfoliobackend.repository.RoleRepository;
import ch.portfolio.portfoliobackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthController {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    private JWTGenerator jwtGenerator;

    @Autowired
    public AuthController(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, JWTGenerator jwtGenerator) {
        //this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
    }

//    @PostMapping("/register")
//    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
//        if (userRepository.existsByUsername(registerDto.getUsername())) {
//            return ResponseEntity.badRequest().body("Username already exists");
//        }
//
//        UserModel user = new UserModel(registerDto.getUsername(), passwordEncoder.encode(registerDto.getPassword()));
//        Role roles = roleRepository.findByRole("ADMIN");
//
//        user.setRole(List.of(roles));
//
//        userRepository.save(user);
//
//        return ResponseEntity.ok("User registered successfully");
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginDto loginDto) throws Exception {
//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        String token = jwtGenerator.generateToken(authentication);
//        return ResponseEntity.ok(new AuthResponseDto(token));
//    }

    @GetMapping("/users")
    public List<UserModel> getUsers(){
        return userRepository.findAll();
    }
}
