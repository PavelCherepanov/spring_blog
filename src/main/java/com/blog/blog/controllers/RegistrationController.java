package com.blog.blog.controllers;

import com.blog.blog.email.EmailSenderService;
import com.blog.blog.models.Role;
import com.blog.blog.models.User;
import com.blog.blog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Collections;
import java.util.Map;


/**
 * @author Pavel
 * @version 1.0
 * @date 27.01.2023 23:43
 */
@Controller
public class RegistrationController {

    @Autowired
    private EmailSenderService senderService;
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }
    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model){
        User userFromDb = userRepository.findByUsername(user.getUsername());
        if (userFromDb != null){
            model.put("message", "Пользователь уже существует");
            return "registration";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        senderService.sendEmail("xmaksxasx@yandex.com", "Спасибо за регистрацию", "Добро пожаловать!");
        userRepository.save(user);


        return "redirect:/login";
    }



}
