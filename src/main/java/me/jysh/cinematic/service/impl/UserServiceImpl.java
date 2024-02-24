package me.jysh.cinematic.service.impl;

import me.jysh.cinematic.exception.SeatNotFoundException;
import me.jysh.cinematic.model.User;
import me.jysh.cinematic.repository.UserRepository;
import me.jysh.cinematic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Primary
public class UserServiceImpl implements UserDetailsService {

   @Autowired
   private UserRepository userRepository;

//    public UserServiceImpl() {
//        this.userRepository = userRepository;
//    }

//    @Override
//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }
//
//    @Override
//    public User getUserById(String user) {
//       return userRepository.findByName(user);
//
//    }

//    @Override
//    public User pushUser(User newUser) {
//        return null;
//    }

//    @Override
//    public User updateUser(User updatedUser, Long user_id) {
//        return null;
//    }

//    @Override
//    public void deleteUserById(Long user_id)
//
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found for email" + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                Collections.emptyList());
    }
}
