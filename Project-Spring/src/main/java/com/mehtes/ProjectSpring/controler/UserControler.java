package com.mehtes.ProjectSpring.controler;

import com.mehtes.ProjectSpring.model.User;
import com.mehtes.ProjectSpring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserControler {

    UserService userService;

    @Autowired
    public UserControler(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable (value = "id") Integer id){
        return ResponseEntity.ok(userService.getById(id));
    }

    @PostMapping
    public ResponseEntity<User> addUser (@RequestBody User user){
        return ResponseEntity.ok(userService.addUser(user));
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable (value = "id") Integer id){
        return ResponseEntity.ok(userService.updateUser(user, id));
    }

    public ResponseEntity<String> deleteUser(@PathVariable (value = "id") Integer id){
        userService.deleteUser(id);
        return ResponseEntity.ok("User with id: "+id+" has been deleted");
    }

}
