package com.example.day32lab10jobseekingsystem.Service;

import com.example.day32lab10jobseekingsystem.Model.JopApplication;
import com.example.day32lab10jobseekingsystem.Repository.JopApplicationRepository;
import com.example.day32lab10jobseekingsystem.Repository.JopPostRepository;
import com.example.day32lab10jobseekingsystem.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class JopApplicationService {
    private final JopApplicationRepository jopApplicationRepository;
    private final UserRepository userRepository;
    private final JopPostRepository jopPostRepository;
    public List<JopApplication> getAllJopApplications() {
        return jopApplicationRepository.findAll();
    }

    public Boolean addJopApplication(JopApplication jopApplication){
        if(jopPostRepository.getById(jopApplication.getJop_post_id()) == null) return false;
        if(userRepository.getById(jopApplication.getUser_id()) == null) return false;
        jopApplicationRepository.save(jopApplication);
        return true;
    }

    public Boolean deleteJopApplication(Integer jopApplicationId){
        JopApplication tempJopApplication = jopApplicationRepository.getById(jopApplicationId);
        if(tempJopApplication == null) return false;
        jopApplicationRepository.delete(tempJopApplication);
        return true;
    }
}
