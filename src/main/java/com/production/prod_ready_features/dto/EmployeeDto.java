package com.production.prod_ready_features.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

/* DTO Stand for data transfer object, responsible for transfer data from client to Controller and then service
 * it lies between presentation layer and service layer,don't goto persistent layer at all  */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    //These are the POJO class it define some Entities in the code
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private String role;
    private Double salary;
    private String dateOfJoining;
    private Boolean isActive;
}
