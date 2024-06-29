package org.example._1cacademy.mapper.abstracts;

import org.example._1cacademy.dto.UserSaveDto;
import org.example._1cacademy.entity.User;

public interface ICustomUserMapper {
    User userSaveDtoToUser(UserSaveDto userSaveDto);
}
