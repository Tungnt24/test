package com.example.test.controller;


import javax.mail.MessagingException;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.test.dto.TemplateRequest;
import com.example.test.dto.UserRequest;
import com.example.test.entity.UserEntity;
import com.example.test.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public void newUser(@RequestBody @Validated UserRequest userRequest){
        userService.createUser(userRequest);
    }

    @GetMapping("approved")
    public void approved(@RequestParam Long userId) throws NotFoundException, MessagingException {
        userService.approve(userId);
    }
}
