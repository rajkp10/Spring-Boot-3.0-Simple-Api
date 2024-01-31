package com.practiceproject1.simpleapi.user.helper;

import com.practiceproject1.simpleapi.student.Student;
import com.practiceproject1.simpleapi.user.User;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserDtoMapper implements Function<User, UserDto> {

    @Override
    public UserDto apply(User user) {
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getRole()
        );
    }
}
