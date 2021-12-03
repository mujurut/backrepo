package com.example.getmeapi.resource;

import java.util.List;
import java.util.NoSuchElementException;

import com.example.getmeapi.exception.RestrictedInfoException;
import com.example.getmeapi.model.User;
import com.example.getmeapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseBody
    public User saveUser(@RequestBody @Valid User user){
        return userService.saveUser(user);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();// us
    }



    @GetMapping("/find")
    public List<User> getByAddress(@RequestParam(name = "address") String address) throws RestrictedInfoException{
        if(address.equals("daledale")){
            throw new RestrictedInfoException();
        }
        return userService.getByAddress(address);// us
    }

//    @ExceptionHandler(RestrictedInfoException.class)
//    public String restricedInfoException(RestrictedInfoException ex){
//        return ex.getMessage();
//    }


    @PutMapping//("/user/{userId}")
    public User updateUser(@RequestBody User user){//@PathVariable("userId")int userId,
        return userService.updateUser(user);
    }

//    @ExceptionHandler(NoSuchElementException.class)
//    public String noSuchElementException(){
//        return "No such element found";
//    }
        @DeleteMapping//("/user")
    public void deleteUser(@RequestParam(name = "userId") String userId){
         userService.deleteUser(userId);
    }
//
//    @GetMapping("/user")
//    public User getUser(){
//        return userService.getUser();
//    }
//
//
//    @GetMapping("/allUsers")
//    public List<User> getAllUsers(){
//        return userService.getAllUsers();// us
//    }
//
//    @GetMapping("/user/{userId}")
//    public User getUserById(@PathVariable("userId")int userId){
//        return userService.getUserById(userId);
//    }
//
//    @PutMapping("/user/{userId}")
//    public User updateUser(@PathVariable("userId")int userId,@RequestBody User user){
//        return userService.updateUser(userId,user);
//    }
//
//    @DeleteMapping("/user")
//    public User deleteUser(@RequestParam(name = "userId") int userId){
//        return userService.deleteUser(userId);
//    }

}
