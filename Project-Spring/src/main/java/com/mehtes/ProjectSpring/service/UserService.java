package com.mehtes.ProjectSpring.service;

import com.mehtes.ProjectSpring.model.User;
import com.mehtes.ProjectSpring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    UserRepository userRepository;

    private String error;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        //exception
        return this.userRepository.findAll();
    }

    public User getById(Integer id){
        return this.userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException());
    }

    public User addUser(User user){
        //exception
        return this.userRepository.save(user);
    }


    public User updateUser(User user, Integer id){
        //todo
        User edited_user = new User("random","bruce","xdddd");
        return this.userRepository.save(edited_user);
    }

    public void deleteUser(Integer id){
        User deleted_user = this.userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException());

        this.userRepository.delete(deleted_user);
    }

    public boolean validateUser(User user){
        if(user.getName().isEmpty()){
            error = "Your name hasn't been set";
            return false;
        }
        if(user.getLastname().isEmpty()){
            error = "Your last name hasn't been set";
            return false;
        }
        if(user.getPesel().isEmpty()){
            error = "Your pesel number hasn't been set";
            return false;
        }

        if(userRepository.findUserByPesel(user.getPesel())!=null){
            error = "User already exists";
            return false;
        }
        return true;
    }

    public String getError(){
        return error;
    }
}
