package com.example.makeupplatform.mapper;

import com.example.makeupplatform.dto.UserDto;
import com.example.makeupplatform.entity.User;

public class UserMapper {
    public static UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .fullName(user.getFullName())
                .email(user.getEmail())
                .role(user.getRoles().stream().findFirst().map(Enum::name).orElse("CLIENT"))
                .build();
    }
}
