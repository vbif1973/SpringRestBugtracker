package com.epam.springrestservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="issue")
public class Issue implements Serializable {

    private Integer issue_id;
    private String description;
    private Integer urgency;
    private Employee employee;

    public Issue() {

    }

    @Id
    @Column(name = "issue_id", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="ISSUE_SEQ")
    @SequenceGenerator(name="ISSUE_SEQ", sequenceName="ISSUE_SEQ", initialValue=6)
    public Integer getIssue_id() {
        return issue_id;
    }

    public void setIssue_id(Integer issue_id) {
        this.issue_id = issue_id;
    }


    @Basic
    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "urgency", nullable = false)
    public Integer getUrgency() {
        return urgency;
    }

    public void setUrgency(Integer urgency) {
        this.urgency = urgency;
    }

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "assigned_to", nullable = true)
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }



}
