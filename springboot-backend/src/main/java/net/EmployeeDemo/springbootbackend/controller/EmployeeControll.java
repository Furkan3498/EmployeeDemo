package net.EmployeeDemo.springbootbackend.controller;


import net.EmployeeDemo.springbootbackend.Services.Employee;
import net.EmployeeDemo.springbootbackend.dto.EmployeeDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")

public class EmployeeControll {

    private Employee employee;

    public EmployeeControll(Employee employee) {
        this.employee = employee;
    }


    @GetMapping("/employees")
    public List<EmployeeDto> getAllEmployees(){
        List<EmployeeDto> employeeDtos = employee.getAllEmployee();
        return employeeDtos;
    }
    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id){
        List<EmployeeDto> employeeDtoList = employee.getAllEmployee();


        return ResponseEntity.ok(employeeDtoList.get(0));
    }
    @PostMapping("/employees")
    public EmployeeDto creatEmployee(@RequestBody EmployeeDto employeeDto){

        employee.createNewEmploye(employeeDto);
        return employeeDto;
    }
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id) throws Throwable {
        employee.deleteEmployee(id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("Deleted" , Boolean.TRUE);
        return  ResponseEntity.ok(response);
    }
    @PutMapping("/employees/{id}")
    public  ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, EmployeeDto employeeDto) throws Throwable{
        employee.updateEmployee(id,employeeDto);
        return ResponseEntity.ok(employeeDto);
    }


}
