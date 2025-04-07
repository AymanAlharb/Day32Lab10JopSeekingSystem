package com.example.day32lab10jobseekingsystem.Service;

import com.example.day32lab10jobseekingsystem.Model.JopPost;
import com.example.day32lab10jobseekingsystem.Repository.JopPostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class JopPostService {
    private final JopPostRepository JopPostRepository;
    public List<JopPost> getAllJopPosts() {
        return JopPostRepository.findAll();
    }

    public void addJopPost(JopPost jopApplication){
        JopPostRepository.save(jopApplication);
    }

    public Boolean updateJopPost(Integer jopApplicationId, JopPost jopApplication){
        JopPost tempJopPost = JopPostRepository.getById(jopApplicationId);
        if(tempJopPost == null) return false;
        tempJopPost.setPosting_date(jopApplication.getPosting_date());
        tempJopPost.setDescription(jopApplication.getDescription());
        tempJopPost.setTitle(jopApplication.getTitle());
        tempJopPost.setLocation(jopApplication.getLocation());
        tempJopPost.setSalary(jopApplication.getSalary());
        return true;
    }

    public Boolean deleteJopPost(Integer jopApplicationId){
        JopPost tempJopPost = JopPostRepository.getById(jopApplicationId);
        if(tempJopPost == null) return false;
        JopPostRepository.delete(tempJopPost);
        return true;
    }
}
