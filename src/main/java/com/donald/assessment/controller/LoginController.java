package com.donald.assessment.controller;

import com.donald.assessment.pojo.CustomerEmail;
import com.donald.assessment.pojo.User;
import com.donald.assessment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * @author Donald
 * @data 30/06/2020 13:51
 */
@RestController
@RequestMapping("/api")

public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user, HttpSession session){
        String name = user.getName();
        String password = user.getPassword();
        User dbUser = userService.getUser(name,password);
        if(null!=dbUser){
            session.setAttribute("user", user);
            return ResponseEntity.ok(dbUser.getName());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session){
        session.removeAttribute("user");
        String message = "Logout Successfully";
        return ResponseEntity.ok(message);
    }
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>("name or password can't be empty",HttpStatus.BAD_REQUEST);
        }
        String name = HtmlUtils.htmlEscape(user.getName());
        user.setName(name);
        boolean exist = userService.isExist(name);
        if(exist){
            return new ResponseEntity(new Error("Username already exists"), HttpStatus.BAD_REQUEST);
        }
        userService.addUser(user);
        return ResponseEntity.ok().build();
    }




}
