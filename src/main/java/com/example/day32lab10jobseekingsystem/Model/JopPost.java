package com.example.day32lab10jobseekingsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class JopPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "The title can not be empty.")
    @Size(min = 4, message = "The title should be more than three characters long.")
    @Column(columnDefinition = "varchar(20) not null")

    private String title;
    @NotNull(message = "The salary can not be null.")
    @Positive
    @Column(columnDefinition = "int not null")

    private Double salary;
    @NotEmpty(message = "The location can not be empty.")
    private String location;
    @NotEmpty(message = "The description can not be empty.")
    @Column(columnDefinition = "varchar(300) not null")

    private String description;
    private LocalDateTime posting_date;
}
