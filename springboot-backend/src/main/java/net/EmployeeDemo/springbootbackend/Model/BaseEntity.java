package net.EmployeeDemo.springbootbackend.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@MappedSuperclass

@JsonIgnoreProperties(value = {"created_date,update_date"},allowGetters = true)
public class BaseEntity {

    @Id
    @Column(name = "id" , nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "created_by")
    @CreatedBy
    private String createdBy;
    @Column(name = "created_time")
    @CreatedDate
    private Date createdTime;
    @Column(name = "updated_time")
    @LastModifiedBy
    private String updatedBy;
    @Column(name = "updated_time")
    @LastModifiedDate
    private Date updatedTime;
    @Column(name = "systems_time")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date date;
    @Enumerated(EnumType.STRING)
    private EmployeeDurumu employeeDurumu;
}
