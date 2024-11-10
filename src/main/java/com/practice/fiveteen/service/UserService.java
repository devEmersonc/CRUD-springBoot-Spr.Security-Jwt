package com.practice.fiveteen.service;

import com.practice.fiveteen.dto.RegisterUserDTO;
import com.practice.fiveteen.dto.UserDTO;
import com.practice.fiveteen.model.User;

import java.util.List;

public interface UserService {
    List<UserDTO> getUsers();
    UserDTO getUser(Long id);
    void saveUser(RegisterUserDTO registerUserDTO);
    void updateUser(Long id, RegisterUserDTO registerUserDTO);
    void deleteUser(Long id);
    UserDTO convertEntityToDto(User user);
}
