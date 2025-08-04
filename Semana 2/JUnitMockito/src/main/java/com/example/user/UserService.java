package com.example.user;

public class UserService {

    private final UserRepository userRepository;

   public UserService(UserRepository repository){
       this.userRepository = repository;
   }

   public boolean registerUser(User user) {
       if (userRepository.findByEmail(user.getEmail()).isPresent()) {
           return false; // User already exists
       }
       userRepository.save(user);
       return true; // User registered successfully
   }
}
