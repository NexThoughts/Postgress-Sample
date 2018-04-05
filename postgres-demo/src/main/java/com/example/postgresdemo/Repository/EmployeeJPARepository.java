package com.example.postgresdemo.Repository;
import com.example.postgresdemo.com.example.postgresdemo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeJPARepository extends JpaRepository<Employee, Long>{
  Employee findByName(String name);
}
