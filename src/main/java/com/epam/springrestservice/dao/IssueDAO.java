package com.epam.springrestservice.dao;

import com.epam.springrestservice.dto.AssignedToEmployee;
import com.epam.springrestservice.model.Employee;
import com.epam.springrestservice.model.Issue;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

public interface IssueDAO {

    List<Issue> listIssues();

    Issue getIssueById(Integer issueId);

    Issue deleteIssueById(Integer issueId);

    Issue addIssue(String description, Integer urgency);

    Issue updateIssue(Integer issueId, String description, Integer urgency, Integer assignedTo);
}
