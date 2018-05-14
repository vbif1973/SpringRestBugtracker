package com.epam.springrestservice.dao.impl;

import com.epam.springrestservice.dao.AbstractDao;
import com.epam.springrestservice.dao.IssueDAO;
import com.epam.springrestservice.dto.AssignedToEmployee;
import com.epam.springrestservice.model.Employee;
import com.epam.springrestservice.model.Issue;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public class IssueDAOImpl extends AbstractDao<Integer, Issue> implements IssueDAO {

    @Autowired
    private AssignedToEmployee assignedToEmployee;

    public List<Issue> listIssues() {
        Criteria criteria = createEntityCriteria();
        List<Issue> issues = (List<Issue>) criteria.list();
        return issues;
    }

    public Issue getIssueById(Integer issueId) {
        Issue issue = getByKey(issueId);
        return issue;
    }

    public Issue deleteIssueById(Integer issueId) {
        Issue issue = getByKey(issueId);
        delete(issue);
        return issue;
    }

    public Issue addIssue(String description, Integer urgency) {
        Issue issue = new Issue();
        issue.setDescription(description);
        issue.setUrgency(urgency);
        save(issue);
        return getByKey(issue.getIssue_id());
    }

    public AssignedToEmployee assignToEmployee(Integer issueId, Integer empId) {
        Issue issue = getByKey(issueId);
        Employee employee = getSession().get(Employee.class, empId);
        issue.setEmployee(employee);
        assignedToEmployee.setMessage("Issue "+issueId+" assigned to employee "+employee.getEmp_name());
        return assignedToEmployee;
    }
}
