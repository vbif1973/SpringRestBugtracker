package com.epam.springrestservice.service.impl;

import com.epam.springrestservice.dao.EmployeeDAO;
import com.epam.springrestservice.dao.IssueDAO;
import com.epam.springrestservice.dto.AssignedToEmployee;
import com.epam.springrestservice.model.Employee;
import com.epam.springrestservice.model.Issue;
import com.epam.springrestservice.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IssueServiceImpl implements IssueService {

    @Autowired
    private IssueDAO issueDAO;

    @Transactional
    public List<Issue> listIssues() {
        return  issueDAO.listIssues();
    }

    @Transactional
    public Issue getIssueById(Integer issueId) {
        return issueDAO.getIssueById(issueId);
    }

    @Transactional
    public Issue deleteIssueById(Integer issueId) {
        return issueDAO.deleteIssueById(issueId);
    }

    @Transactional
    public Issue addIssue(String description, Integer urgency) {
        return issueDAO.addIssue(description, urgency);
    }

    @Transactional
    public AssignedToEmployee assignToEmployee(Integer issueId, Integer empId){
        return issueDAO.assignToEmployee(issueId, empId);
    }
}
