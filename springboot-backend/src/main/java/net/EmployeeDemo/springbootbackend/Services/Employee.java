package net.EmployeeDemo.springbootbackend.Services;

import net.EmployeeDemo.springbootbackend.Model.EmployeeEntity;
import net.EmployeeDemo.springbootbackend.dto.EmployeeDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface Employee {


    //CRUD
    public List<EmployeeDto> getAllEmployee();
    public  EmployeeDto createNewEmploye(EmployeeDto employeeDto);
    public ResponseEntity<EmployeeDto> getEmployeeById(Long id) throws Throwable;
    public  ResponseEntity<EmployeeDto> updateEmployee(Long id ,EmployeeDto employeeDto ) throws Throwable;
    public  ResponseEntity<Map<String,Boolean>> deleteEmployee(Long id) throws Throwable;


    //Model Mapper

    public  EmployeeDto entityToDto(EmployeeEntity employeeEntity);
    public  EmployeeEntity dtoToEntity(EmployeeDto employeeDto);
}

