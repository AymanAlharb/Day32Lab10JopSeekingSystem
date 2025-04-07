package com.example.day32lab10jobseekingsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;
import org.hibernate.validator.constraints.UniqueElements;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
//@Check(constraints = "age > 20")
//@Check(constraints = "check role = 'jop_seeker' or role = 'employer'")
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "The name can not be empty.")
    @Size(message = "The name size must be more than 4 characters long.")
    @Pattern(regexp = "[a-zA-z]+")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;
    @Email
   // @Column(columnDefinition = "unique")
    private String email;
    @NotEmpty(message = "The password can not be empty.")
    @Column(columnDefinition = "varchar(25) not null")
    private String password;
    @NotNull(message = "The age can not be null.")
    @Positive(message = "The age must be a valid positive number.")
    @Min(value = 21, message = "The user must be older than 20.")
    @Column(columnDefinition = "int not null")
    private Integer age;
    @NotEmpty(message = "The role can not be empty.")
    @Pattern(regexp = "jop_seeker|employer")
    @Column(columnDefinition = "varchar(10) not null")
    private String role;

}
