package com.practiceproject1.simpleapi.user;

import com.practiceproject1.simpleapi.user.helper.UserDto;
import com.practiceproject1.simpleapi.user.helper.UserDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserDtoMapper userDtoMapper;

    public List<UserDto> getAllUsers(){
        return userRepository.findAll().stream().map(userDtoMapper).collect(Collectors.toList());
    }
}
