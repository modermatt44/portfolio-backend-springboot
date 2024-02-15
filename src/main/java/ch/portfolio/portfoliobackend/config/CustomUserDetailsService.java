package ch.portfolio.portfoliobackend.config;

import ch.portfolio.portfoliobackend.model.Role;
import ch.portfolio.portfoliobackend.model.UserModel;
import ch.portfolio.portfoliobackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

//@Service
public class CustomUserDetailsService{ //implements UserDetailsService {

    //private final UserRepository userRepository;
//
    //@Autowired
    //public CustomUserDetailsService(UserRepository userRepository) {
    //    this.userRepository = userRepository;
    //}
//
    //@Override
    //public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    //    UserModel user = userRepository.findByUsername(username);
    //    if (user == null) {
    //        throw new UsernameNotFoundException("User not found");
    //    }
    //    return new User(user.getUsername(), user.getPassword(), mapRolesToAuthorities(user.getRole()));
    //}
//
    //private Collection<GrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
    //    return roles.stream()
    //            .map(role -> new SimpleGrantedAuthority(role.getRole()))
    //            .collect(Collectors.toList());
    //}
}
