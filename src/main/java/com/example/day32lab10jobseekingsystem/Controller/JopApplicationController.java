package com.example.day32lab10jobseekingsystem.Controller;

import com.example.day32lab10jobseekingsystem.Api.ApiResponse;
import com.example.day32lab10jobseekingsystem.Model.JopApplication;
import com.example.day32lab10jobseekingsystem.Service.JopApplicationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/jop-seeking-system/jop-application")
@RequiredArgsConstructor
public class JopApplicationController {
    private final JopApplicationService jopApplicationService;

    @GetMapping("/get-all")
    public ResponseEntity getAllJopApplications() {
        return ResponseEntity.status(HttpStatus.OK).body(jopApplicationService.getAllJopApplications());
    }

    @PostMapping("/add-jop-post")
    public ResponseEntity addJopApplication(@RequestBody @Valid JopApplication jopApplication, Errors errors) {
        if (errors.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));
        boolean added = jopApplicationService.addJopApplication(jopApplication);
        if (added)
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Jop application added successfully"));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Jop application or user not found"));

    }


    @DeleteMapping("/delete-jop-post/{jopApplicationId}")
    public ResponseEntity deleteJopApplication(@PathVariable Integer jopApplicationId) {
        boolean deleted = jopApplicationService.deleteJopApplication(jopApplicationId);
        if (deleted) return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Jop application deleted successfully"));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Jop application not found"));
    }
}
