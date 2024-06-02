package com.platform_analysis.pa.model.RequestDTO.System;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.mapping.Set;
import org.springframework.context.annotation.Role;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "PA_USER_MAS")
public class UserDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String username;
    private String passwordHash;
    private String email;
    private String firstName;
    private String lastName;
}
