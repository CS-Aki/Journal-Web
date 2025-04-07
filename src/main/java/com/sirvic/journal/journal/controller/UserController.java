package com.sirvic.journal.journal.controller;
import com.sirvic.journal.journal.service.UserService;
import com.sirvic.journal.journal.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

//API Layer
@CrossOrigin(origins = "http://localhost:5175", allowedHeaders = "*", allowCredentials = "true", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {
    private final UserService userService;

    @Autowired // optional if only one constructor, otherwise must specify which constructor to use by using autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<Users> displayUser(){
        return userService.displayUser();
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Users user){

        if(userService.findUsername(user) == true){
            return ResponseEntity.ok("Username taken");
        }
        
        userService.addNewUser(user);
        return ResponseEntity.ok("Registration Successfully!");
    }

    @DeleteMapping(path = "{id}")
    public void deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
    }

    @PatchMapping(path = "{id}")
    public void updateUsername(@PathVariable("id") Long id,
                               @RequestParam(required = false, defaultValue = "") String username,
                               @RequestParam(required = false, defaultValue = "") String firstName,
                               @RequestParam(required = false, defaultValue = "") String lastName
                               ){
        userService.updateUsername(id, username, firstName, lastName);
    }
    
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody Users user) {
            System.out.println("User login attempt:");
            System.out.println("Username: " + user.getUsername());
            System.out.println("Password: " + user.getPassword());
            String username = user.getUsername();
            String password = user.getPassword();

            if(userService.findUsername(user) == true){
                return ResponseEntity.ok("Match found");
            }else if(username.equals("admin") && password.equals("admin")){
                return ResponseEntity.ok("Admin Account");
            }else{
                return ResponseEntity.ok("There is no match");
            }
    }

}
