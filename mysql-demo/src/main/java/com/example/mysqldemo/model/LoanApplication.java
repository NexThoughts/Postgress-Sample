package com.example.mysqldemo.model;

import javax.persistence.*;

@Entity
public class LoanApplication {

    @Id
    @GeneratedValue
    private Long id;
    private Double loanAmount;
    private Long tenure;
    private Double interestRate;

    @ManyToOne(targetEntity=Employee.class,fetch=FetchType.EAGER)
    @ElementCollection(targetClass=Integer.class)
    private Employee employee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Long getTenure() {
        return tenure;
    }

    public void setTenure(Long tenure) {
        this.tenure = tenure;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_id")
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
