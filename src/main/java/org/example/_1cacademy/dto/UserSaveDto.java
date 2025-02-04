package org.example._1cacademy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSaveDto {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
}
