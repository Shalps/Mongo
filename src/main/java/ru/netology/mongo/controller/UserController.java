package ru.netology.mongo.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.netology.mongo.Repository.UserRepository;
import ru.netology.mongo.model.User;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {


   private UserRepository userRepository;

   @GetMapping
   public List<User> getAllUsers(){
       return userRepository.findAll();
   }
   @GetMapping("/{id}")
   public User getUserById(@PathVariable String id){
       return userRepository.findById(id).orElse(null);
   }
   @PostMapping
   public User createUser(@RequestBody User user){
      return userRepository.save(user);
   }

   @PutMapping("/{id}")
   public User updateUser(@PathVariable String id, @RequestBody User userDetails) {
      User user = userRepository.findById(id).orElseThrow();
      user.setName(userDetails.getName());
      user.setEmail(userDetails.getEmail());
      user.setAge(userDetails.getAge());
      return userRepository.save(user);
   }
   @DeleteMapping("/{id}")
   public void deleteUser(@PathVariable String id){
       userRepository.deleteById(id);
   }
}
