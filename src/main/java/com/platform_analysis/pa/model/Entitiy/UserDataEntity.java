package com.platform_analysis.pa.model.Entitiy;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class UserDataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId; // USER_ID

    private String userName; // USER_NAME
    private String userEmail; // USER_EMAIL
    private String userPW; // USER_PW

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Timestamp createTM; // CREATE_TM

    private LocalDate userBirthday; // USER_BIRTHDAY
    private String userAddress; // USER_ADDRESS
}
