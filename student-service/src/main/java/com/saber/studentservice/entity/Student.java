package com.saber.studentservice.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

@Entity
@Table(name = "students")
@Data
@EqualsAndHashCode
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_name",length = 70)
    private String firstName;
    @Column(name = "last_name",length = 80)
    private String lastName;
    private Integer age;
    @Column(name = "email",length = 30)
    private String email;
    @Column(name = "field",length = 20)
    private String field;

}
