package com.example.day32lab10jobseekingsystem.Repository;

import com.example.day32lab10jobseekingsystem.Model.JopApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JopApplicationRepository extends JpaRepository<JopApplication, Integer> {
}
