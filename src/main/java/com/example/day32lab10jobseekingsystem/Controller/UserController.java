package com.example.day32lab10jobseekingsystem.Controller;

import com.example.day32lab10jobseekingsystem.Api.ApiResponse;
import com.example.day32lab10jobseekingsystem.Model.User;
import com.example.day32lab10jobseekingsystem.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/jop-seeking-system/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/get-all")
    public ResponseEntity getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }

    @PostMapping("/add-user")
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors) {
        if (errors.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));
        userService.addUser(user);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("User added successfully"));
    }

    @PutMapping("/update-user/{userId}")
    public ResponseEntity updateUser(@PathVariable Integer userId, @RequestBody @Valid User user, Errors errors) {
        if (errors.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));
        boolean updated = userService.updateUser(userId, user);
        if (updated) return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("User updated successfully"));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("User not found"));
    }

    @DeleteMapping("/delete-user/{userId}")
    public ResponseEntity deleteUser(@PathVariable Integer userId) {
        boolean deleted = userService.deleteUser(userId);
        if (deleted) return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("User deleted successfully"));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("User not found"));
    }
}
