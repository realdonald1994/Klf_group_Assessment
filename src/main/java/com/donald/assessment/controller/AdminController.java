package com.donald.assessment.controller;

import com.donald.assessment.pojo.User;
import com.donald.assessment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Donald
 * @data 02/07/2020 12:00
 */
@RestController
@RequestMapping("/api")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/admin/dashboard")
    public ResponseEntity<Void> getDashboard(){
        return ResponseEntity.ok().build();
    }

    /**
     *  User Management
    */
    @GetMapping("/admin/users")
    public ResponseEntity<Page<User>> getUsers(@PageableDefault(size = 5)Pageable pageable){
        return ResponseEntity.ok(userService.getUsers(pageable));
    }

    @PutMapping("/admin/user")
    public ResponseEntity<String> editUser(@RequestBody User updateUser){
        userService.editUser(updateUser);
        String message = "Modify user successfully";
        return ResponseEntity.ok(message);
    }

    @DeleteMapping("/admin/user/delete/{name}")
    public ResponseEntity<String> deleteUser(@RequestBody User user,@PathVariable("name") String name){
        if(userService.getByName(name).getId().intValue()==user.getId().intValue()){
            return ResponseEntity.badRequest().build();
        }
        userService.deleteUser(user.getId());
        return ResponseEntity.ok("User is deleted");
    }
}
