package com.sofiqul54.util;

import com.sofiqul54.entity.User;
import com.sofiqul54.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class MyGlobalControllerAdvice {
    @Autowired
    private UserRepo userRepo;

    @ModelAttribute
    public User getUserDetails(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user=this.userRepo.findByUserName(auth.getName());
        return user;
    }
}
