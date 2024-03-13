package com.usman.todo.service.impl;

import com.usman.todo.dto.RegisterDto;
import com.usman.todo.entity.Role;
import com.usman.todo.entity.User;
import com.usman.todo.exeption.TodoApiException;
import com.usman.todo.repository.RoleRepository;
import com.usman.todo.repository.UserRepository;
import com.usman.todo.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    @Override
    public String register(RegisterDto registerDto) {
        if(userRepository.existsByUsername(registerDto.getUsername())){
            throw new TodoApiException(HttpStatus.BAD_REQUEST , "Username already exist! ");
        }
        if(userRepository.existsByEmail(registerDto.getEmail())){
            throw new TodoApiException(HttpStatus.BAD_REQUEST,"Email already exists! ");
        }
        User user=new User();
        user.setName(registerDto.getName());
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Set<Role> roles=new HashSet<>();
        Role role=roleRepository.findByName("ROLE_USER");
        roles.add(role);
        user.setRoles(roles);
        userRepository.save(user);
        return "Successfully added ";
    }
}
