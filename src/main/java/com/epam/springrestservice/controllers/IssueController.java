package com.epam.springrestservice.controllers;

import com.epam.springrestservice.dto.AssignedToEmployee;
import com.epam.springrestservice.model.Employee;
import com.epam.springrestservice.model.Issue;
import com.epam.springrestservice.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IssueController {

    @Autowired
    IssueService issueService;

    @RequestMapping(value ="/allissues", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Issue> getAllIssues(){
        List<Issue> issues = issueService.listIssues();
        return issues;
    }

    @RequestMapping(value="/getissuebyid/{issueId}", method = RequestMethod.GET)
    @ResponseBody
    public Issue getEmployeeById(@PathVariable Integer issueId) {
        return issueService.getIssueById(issueId);
    }

    @RequestMapping(value="/deleteissuebyid/{issueId}", method = RequestMethod.GET)
    @ResponseBody
    public Issue deleteIssueById(@PathVariable Integer issueId) {
        return issueService.deleteIssueById(issueId);
    }

    @RequestMapping(value="/addissue/{description}/{urgency}", method = RequestMethod.GET)
    @ResponseBody
    public Issue addIssue(@PathVariable String description, @PathVariable Integer urgency) {
        return issueService.addIssue(description, urgency);
    }

    @RequestMapping(value="/assigntoemployee/{issueId}/{empId}", method = RequestMethod.GET)
    @ResponseBody
    public AssignedToEmployee assigntoemployee(@PathVariable Integer issueId, @PathVariable Integer empId) {
        return issueService.assignToEmployee(issueId, empId);
    }
}
