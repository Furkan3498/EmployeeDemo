package net.EmployeeDemo.springbootbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2
public class EmployeeDto {

    private EmployeeDurum EmployeeDurumEnum;
    private Long id;
    private String name;
    private String lastName;
    private Integer age;
    private  String email;
}