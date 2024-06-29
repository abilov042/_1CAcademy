package org.example._1cacademy.mapper.concretes;

import org.example._1cacademy.dto.UserSaveDto;
import org.example._1cacademy.entity.User;
import org.example._1cacademy.mapper.abstracts.ICustomUserMapper;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

@Component
public class CustomUserMapper implements ICustomUserMapper {

    @Override
    public User userSaveDtoToUser(UserSaveDto userSaveDto) {
        return User.builder()
                .username(userSaveDto.getUsername())
                .password(userSaveDto.getPassword())
                .firstName(userSaveDto.getFirstName())
                .lastName(userSaveDto.getLastName()).build();
    }
}
