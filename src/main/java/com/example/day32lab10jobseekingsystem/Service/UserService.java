package com.example.day32lab10jobseekingsystem.Service;

import com.example.day32lab10jobseekingsystem.Model.User;
import com.example.day32lab10jobseekingsystem.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user){
        userRepository.save(user);
    }

    public Boolean updateUser(Integer userId, User user){
        User tempUser = userRepository.getById(userId);
        if(tempUser == null) return false;
        tempUser.setAge(user.getAge());
        tempUser.setRole(user.getRole());
        tempUser.setEmail(user.getEmail());
        tempUser.setPassword(user.getPassword());
        return true;
    }

    public Boolean deleteUser(Integer userId){
        User tempUser = userRepository.getById(userId);
        if(tempUser == null) return false;
        userRepository.delete(tempUser);
        return true;
    }
}
