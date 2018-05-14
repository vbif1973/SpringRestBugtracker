package com.epam.springrestservice.service;

import com.epam.springrestservice.dto.AssignedToEmployee;
import com.epam.springrestservice.model.Employee;
import com.epam.springrestservice.model.Issue;

import java.util.List;

public interface IssueService {
    List<Issue> listIssues();

    Issue getIssueById(Integer issueId);

    Issue deleteIssueById(Integer issueId);

    Issue addIssue(String description, Integer urgency);

    AssignedToEmployee assignToEmployee(Integer issueId, Integer empId);
}
