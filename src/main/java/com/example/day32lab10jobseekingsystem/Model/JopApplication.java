package com.example.day32lab10jobseekingsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class JopApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Column(columnDefinition = "int not null")

    private Integer user_id;
    @NotNull
    @Column(columnDefinition = "int not null")

    private Integer jop_post_id;
}
