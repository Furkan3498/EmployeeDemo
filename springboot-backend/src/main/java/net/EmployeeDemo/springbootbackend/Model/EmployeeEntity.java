package net.EmployeeDemo.springbootbackend.Model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor

@Builder
@Log4j2

@Table(name = "employees")
public class EmployeeEntity extends BaseEntity implements Serializable {


    @Column(name = "first_name")
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "age")
    private Integer age;
    @Column(name = "email")
    private  String email;

    public EmployeeEntity(String name, String lastName, Integer age, String email) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }
}
