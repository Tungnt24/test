package com.example.test.service;

import javax.mail.MessagingException;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import com.example.test.dto.UserRequest;
import com.example.test.entity.TemplateMailEntity;

public interface UserService {
    void createUser(UserRequest userRequest);

    TemplateMailEntity getTemplateByCode(String code) throws NotFoundException;

    void approve(Long userId) throws NotFoundException, MessagingException;

    void deleteUser(Long userId);
}
