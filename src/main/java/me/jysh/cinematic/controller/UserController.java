package me.jysh.cinematic.controller;

import me.jysh.cinematic.model.User;
import me.jysh.cinematic.service.UserService;
import me.jysh.cinematic.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userService;

//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

//    @GetMapping("/users")
//    public List<User> getAllUsers() {
//        return userService.getAllUsers();
//    }
    @GetMapping("/login")
    public ResponseEntity<?> logi ( User user )
    {
        System.out.println(user.getUserName());
        System.out.println(user.getPassword());
        String  userName = "jysh";
        System.out.println("inside the login controller");
        try {
            userService. loadUserByUsername(userName);
            return ResponseEntity.ok("login successfully");
        }
        catch(Exception e){
        return ResponseEntity.ok("Login failed :"+e);
    }
    }

    @PostMapping("/logi")
      public ResponseEntity<?> login ( @RequestBody User user ){
        System.out.println("user name :"+user.getUserName());
        System.out.println("user password :"+user.getPassword());
        return ResponseEntity.ok("Login failed :");
    }
}
