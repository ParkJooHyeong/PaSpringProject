package com.platform_analysis.pa.model.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long USER_ID; // USER_ID

    private String USER_NAME; // USER_NAME
    private String USER_EMAIL; // USER_EMAIL
    private String USER_PW; // USER_PW
    private Timestamp CREATE_TM; // CREATE_TM
    private LocalDate USER_BIRTHDAY; // USER_BIRTHDAY
    private String USER_ADDRESS; // USER_ADDRESS
}
