package com.epam.springrestservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    public Employee() {

    }
    private Integer emp_id;
    private String emp_name;
    private Set<Issue> issues = new HashSet<Issue>();


    @Id
    @Column(name = "emp_id", nullable = false)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EMPLOYEE_SEQ")
    @SequenceGenerator(name="EMPLOYEE_SEQ", sequenceName="EMPLOYEE_SEQ", initialValue=4)
    public Integer getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Integer emp_id) {
        this.emp_id = emp_id;
    }

    @Basic
    @Column(name = "emp_name", nullable = false)
    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employee", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    public Set<Issue> getIssues() {
        return issues;
    }

    public void setIssues(Set<Issue> issues) {
        this.issues = issues;
    }
}
