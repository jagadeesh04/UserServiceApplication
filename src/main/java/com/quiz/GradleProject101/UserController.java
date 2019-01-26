package com.quiz.GradleProject101;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }


    @PutMapping(value = "/{userId}")
    ResponseEntity updateUser(@PathVariable("userId") int id, @Valid @RequestBody User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors())
            return new ResponseEntity(getErrorMessage(bindingResult), HttpStatus.BAD_REQUEST);
        user.setId(id);

        return new ResponseEntity(userService.updateUser(user), HttpStatus.OK);
    }

    private String getErrorMessage(BindingResult bindingResult) {
        return bindingResult.getAllErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.toList()).toString();
    }

}
