package com.example.postgresdemo.com.example.postgresdemo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {

    private Long id;
    private String name;
    private String teamName;
    private Double salary;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
