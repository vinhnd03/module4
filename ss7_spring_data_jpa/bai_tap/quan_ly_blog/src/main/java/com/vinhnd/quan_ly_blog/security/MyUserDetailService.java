package com.vinhnd.quan_ly_blog.security;

import com.vinhnd.quan_ly_blog.entity.MyUser;
import com.vinhnd.quan_ly_blog.entity.Role;
import com.vinhnd.quan_ly_blog.entity.UserRole;
import com.vinhnd.quan_ly_blog.repository.IUserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MyUserDetailService implements UserDetailsService {

    private final IUserRepository repository;

    public MyUserDetailService(IUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MyUser> user = repository.findByUsername(username);
        if (user.isPresent()) {
            MyUser userObj = user.get();
            List<String> roles = userObj.getUserRoles().stream()
                    .map(userRole -> userRole.getRole().getName())
                    .collect(Collectors.toList());

            Set<GrantedAuthority> authorities = roles.stream()
                    .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                    .collect(Collectors.toSet());

            return new User(
                    userObj.getUsername(),
                    userObj.getPassword(),
                    authorities);
        } else {
            throw new UsernameNotFoundException(username);
        }
    }

}
