package net.EmployeeDemo.springbootbackend.Services.ServicesImple;

import net.EmployeeDemo.springbootbackend.Bean.ModelMapperBean;
import net.EmployeeDemo.springbootbackend.Model.EmployeeEntity;
import net.EmployeeDemo.springbootbackend.Services.Employee;
import net.EmployeeDemo.springbootbackend.dto.EmployeeDto;
import net.EmployeeDemo.springbootbackend.exception.ResourceNotFoundException;
import net.EmployeeDemo.springbootbackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public  class EmployeeImpl implements Employee {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ModelMapperBean modelMapperBean;
    @Override
    public List<EmployeeDto> getAllEmployee() {

        List<EmployeeDto> employeeDtos = new ArrayList<>();
        Iterable<EmployeeEntity> entitiesList = employeeRepository.findAll();
        for (EmployeeEntity employeeEntity : entitiesList){
            EmployeeDto employeeDto = entityToDto(employeeEntity);
            employeeDtos.add(employeeDto);
        }
        return employeeDtos;
    }

    @Override
    public EmployeeDto createNewEmploye(@RequestBody EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = dtoToEntity(employeeDto);
        employeeRepository.save(employeeEntity);

        return employeeDto;
    }

    @Override
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) throws Throwable {
        EmployeeEntity employeeEntity = (EmployeeEntity) employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id" + id));
        EmployeeDto employeeDto = entityToDto(employeeEntity);
        return ResponseEntity.ok(employeeDto);
    }

    @Override
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id,@RequestBody EmployeeDto employeeDetails) throws Throwable {

        EmployeeEntity employeeEntity = dtoToEntity(employeeDetails);
        EmployeeEntity employee = (EmployeeEntity) employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id " + id));
        employee.setName(employeeEntity.getName());
        employee.setLastName(employeeEntity.getLastName());
        employee.setAge(employeeEntity.getAge());
        employee.setEmail(employeeEntity.getEmail());
        employee.setEmployeeDurumu(employeeEntity.getEmployeeDurumu());
        EmployeeEntity updateEmployee = (EmployeeEntity) employeeRepository.save(employee);
        EmployeeDto employeeDto = entityToDto(updateEmployee);


        return ResponseEntity.ok(employeeDto);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) throws Throwable {

        EmployeeEntity employeeEntity = (EmployeeEntity) employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id " + id));
        employeeRepository.delete(employeeEntity);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @Override
    public EmployeeDto entityToDto(EmployeeEntity employeeEntity) {
        EmployeeDto employeeDto = modelMapperBean.modelMapper().map(employeeEntity,EmployeeDto.class);
        return employeeDto;
    }

    @Override
    public EmployeeEntity dtoToEntity(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity= modelMapperBean.modelMapper().map(employeeDto,EmployeeEntity.class);
        return employeeEntity;
    }
}
