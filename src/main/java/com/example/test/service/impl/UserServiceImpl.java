package com.example.test.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import javax.mail.MessagingException;
import org.apache.commons.text.StringSubstitutor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.test.dto.UserRequest;
import com.example.test.entity.TemplateMailEntity;
import com.example.test.entity.UserEntity;
import com.example.test.enums.TemplateCode;
import com.example.test.repo.TemplateRepository;
import com.example.test.repo.UserRepository;
import com.example.test.service.UserService;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.utility.RandomString;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final TemplateRepository templateRepository;
    private final EmailServiceImpl emailService;

    @Override
    @Transactional
    public void createUser(UserRequest userRequest) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userRequest, userEntity);
        userRepository.save(userEntity);
    }

    @Override
    public TemplateMailEntity getTemplateByCode(String code) throws NotFoundException {
        return templateRepository.findByCode(code).orElseThrow(NotFoundException::new);
    }

    @Override
    public void approve(Long userId) throws NotFoundException, MessagingException {
        UserEntity userEntity = userRepository.findById(userId).orElseThrow(NotFoundException::new);
        userEntity.setApprove(true);
        userEntity.setApprove(false);
        var code = new RandomString(6).nextString();
        userEntity.setCode(code);

        userRepository.save(userEntity);
        TemplateMailEntity mailEntity = this.getTemplateByCode(TemplateCode.TMP01.value);

        Map<String, String> lstParam = new HashMap<>();
        lstParam.put("USER_NAME", userEntity.getFullName());
        lstParam.put("POSITION", userEntity.getPosition());
        lstParam.put("CODE", userEntity.getCode());
//        lstParam.put("LINK", link);
        StringSubstitutor sub = new StringSubstitutor(lstParam);
        String resolvedString = sub.replace(new StringBuffer(mailEntity.getContent()));
        emailService.sendHtmlEmail(userEntity.getEmail(), mailEntity.getSubject(), resolvedString);
    }


    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
