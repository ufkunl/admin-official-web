package com.adminOfficialWeb.demo.util;

import com.adminOfficialWeb.demo.entity.User;
import com.adminOfficialWeb.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@Component
public class UserUtil {

    @Autowired
    private UserRepository userRepository;

    public User getAuthenticatedUser(){
        return userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication()
                .getName()).orElseThrow(() -> new EntityNotFoundException("Kullanıcı bulunamadı"));
    }

}
