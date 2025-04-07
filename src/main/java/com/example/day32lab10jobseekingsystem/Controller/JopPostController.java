package com.example.day32lab10jobseekingsystem.Controller;

import com.example.day32lab10jobseekingsystem.Api.ApiResponse;
import com.example.day32lab10jobseekingsystem.Model.JopPost;
import com.example.day32lab10jobseekingsystem.Service.JopPostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/jop-seeking-system/jop-post")
@RequiredArgsConstructor
public class JopPostController {
    private final JopPostService jopPostService;

    @GetMapping("/get-all")
    public ResponseEntity getAllJopPosts() {
        return ResponseEntity.status(HttpStatus.OK).body(jopPostService.getAllJopPosts());
    }

    @PostMapping("/add-jop-post")
    public ResponseEntity addJopPost(@RequestBody @Valid JopPost jopPost, Errors errors) {
        if (errors.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));
        jopPostService.addJopPost(jopPost);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Jop post added successfully"));
    }

    @PutMapping("/update-jop-post/{jopPostId}")
    public ResponseEntity updateJopPost(@PathVariable Integer jopPostId, @RequestBody @Valid JopPost jopPost, Errors errors) {
        if (errors.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));
        boolean updated = jopPostService.updateJopPost(jopPostId, jopPost);
        if (updated) return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Jop post updated successfully"));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Jop post not found"));
    }

    @DeleteMapping("/delete-jop-post/{jopPostId}")
    public ResponseEntity deleteJopPost(@PathVariable Integer jopPostId) {
        boolean deleted = jopPostService.deleteJopPost(jopPostId);
        if (deleted) return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Jop post deleted successfully"));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Jop post not found"));
    }
}
