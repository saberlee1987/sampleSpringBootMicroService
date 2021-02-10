package com.saber.studentservice.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import net.bytebuddy.build.ToStringPlugin;
import org.springframework.boot.convert.DataSizeUnit;

@Data
@EqualsAndHashCode
@ToString
public class StudentModel {
    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
    private String field;
}
