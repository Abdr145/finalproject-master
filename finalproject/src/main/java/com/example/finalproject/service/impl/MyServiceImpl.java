package com.example.finalproject.service.impl;


import com.example.finalproject.model.Permission;
import com.example.finalproject.model.User;
import com.example.finalproject.repository.PermissionRepository;
import com.example.finalproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MyServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(username);

        if (Objects.nonNull(user)){
            return user;
        }

        throw new UsernameNotFoundException("User Not Found");
    }

    public void register(User user){
        User check = userRepository.findByLogin(user.getLogin());

        if (check == null){
            List<Permission> permissions = List.of(permissionRepository.findByName("ROLE_USER"));
            user.setPermissions(permissions);
            user.setPassword(passwordEncoder.encode(user.getPassword()));

            userRepository.save(user);
        }
    }
}

