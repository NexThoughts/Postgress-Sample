package com.example.mysqldemo.Repository;

import com.example.mysqldemo.model.Employee;
import com.example.mysqldemo.model.LoanApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanApplicationRepository extends JpaRepository<LoanApplication,Long>{
    LoanApplication findByEmployee(Employee employee);
}
