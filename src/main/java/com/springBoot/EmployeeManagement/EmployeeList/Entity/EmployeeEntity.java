package com.springBoot.EmployeeManagement.EmployeeList.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Employee_Details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {

    @Id
    private int id;

    private String firstName;

    private String lastName;

    private String emailId;

    private String location;

    private Long mobileNo;

}
