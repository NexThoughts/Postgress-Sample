package com.example.mysqldemo.Controller;

import com.example.mysqldemo.Repository.EmployeeJPARepository;
import com.example.mysqldemo.Repository.LoanApplicationRepository;
import com.example.mysqldemo.model.Employee;
import com.example.mysqldemo.model.LoanApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/loanApplication")
public class LoanapplicationController {


    @Autowired
    private LoanApplicationRepository loanApplicationRepository;

    @Autowired
    private EmployeeJPARepository employeeJPARepository;

    @GetMapping(value = "/all")
    public List<LoanApplication> findAll(){
        return loanApplicationRepository.findAll();
    }

    @GetMapping(value = "/getByBorrower/{borrowername}")
    public LoanApplication getLoanApplicationByBorroerName(@PathVariable final String borrowername){
        Employee employee = employeeJPARepository.findByName(borrowername);
        return loanApplicationRepository.findByEmployee(employee);
    }

    @GetMapping(value = "/getById/{loanId}")
    public Object getLoanApplicationByLoanId(@PathVariable final String loanId){
        return loanApplicationRepository.findById(Long.parseLong(loanId));
    }

    @PostMapping(value = "/create")
    public LoanApplication createLoanApplication(@RequestBody final LoanApplication loan){
        System.out.println("Hit the loanApplication create endpoint");
        Employee employee = null;
        System.out.println(loan.getEmployee());
        System.out.println(loan.getEmployee().getName());
        if(loan != null && loan.getEmployee() != null && loan.getEmployee().getName() !=null){
            employee = employeeJPARepository.findByName(loan.getEmployee().getName());
            if(employee != null){
                loan.setEmployee(employee);
                loanApplicationRepository.save(loan);
            }
        }
        return loanApplicationRepository.findByEmployee(employee);
    }

}
