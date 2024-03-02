package me.jysh.cinematic.controller;



import me.jysh.cinematic.configuration.UserServiceImpl;
import me.jysh.cinematic.model.LoginDto;
import me.jysh.cinematic.model.Users;
import me.jysh.cinematic.repository.UserRepository;
import me.jysh.cinematic.service.impl.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;



@RestController
public class UserController {

@Autowired
private UserRepository userRepository;

@Autowired
private AuthServiceImpl userService;

@Autowired
private PasswordEncoder passwordEncoder;

    @PostMapping("/user")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
        System.out.println("user name :"+loginDto.getEmail());
        System.out.println("Password :"+ loginDto.getPassword());
        System.out.println("Something working");
        String response = userService.login(loginDto);
        System.out.println("After service class");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("/register")
      public ResponseEntity<?> register ( @RequestBody Users user ){
      System.out.println("okay");
      try {
         String encodedPassword = passwordEncoder.encode(user.getPwd());
         user.setPwd(encodedPassword);
          userRepository.save(user);
          return ResponseEntity.ok("Register successfully");
      }
      catch(Exception e){
          return ResponseEntity.ok("something going fishy here");
      }
    }
}
