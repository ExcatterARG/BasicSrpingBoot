package com.example.springbootvalidation.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class User {
    @NotBlank(message = "username cannot be empty")
    private String name;

    @NotBlank(message = "password cannot be empty")
    @Length(max = 8 , min = 4, message = "Password must be between 4 and 8 characters")
    private String password;

    @NotNull(message = "Grade cannot be empty")
    @Max(value = 100, message = "Max value of a grade is 100")
    @Min(value= 0, message = "Min value of a grade is 0")
    private Double grade;

    public User(String name, String password, Double grade) {
        this.name = name;
        this.password = password;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

}
