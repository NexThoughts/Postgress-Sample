package com.example.mysqldemo.Repository;

import com.example.mysqldemo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeJPARepository extends JpaRepository<Employee, Long>{
  Employee findByName(String name);
}
