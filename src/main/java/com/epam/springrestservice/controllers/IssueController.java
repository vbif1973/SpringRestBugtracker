package com.epam.springrestservice.controllers;

import com.epam.springrestservice.dto.AssignedToEmployee;
import com.epam.springrestservice.dto.EmployeeDTO;
import com.epam.springrestservice.dto.IssueDTO;
import com.epam.springrestservice.model.Employee;
import com.epam.springrestservice.model.Issue;
import com.epam.springrestservice.service.IssueService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value ="/issue")
public class IssueController {

    private static final Logger logger = Logger.getLogger(IssueController.class);

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

    @RequestMapping(value="/deleteissuebyid/{issueId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Issue deleteIssueById(@PathVariable Integer issueId) {
        logger.info("IssueController.deleteIssueById called");
        return issueService.deleteIssueById(issueId);
    }

    @RequestMapping(value="/addissue", method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public Issue addIssue(@RequestBody IssueDTO issueDTO) {
        logger.info("IssueController.addIssue called");
        String description = issueDTO.getDescription();
        Integer urgency = issueDTO.getUrgency();
        return issueService.addIssue(description, urgency);
    }

    @RequestMapping(value="/updateissue", method = RequestMethod.PUT, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public Issue updateIssue(@RequestBody IssueDTO issueDTO) {
        logger.info("IssueController.updateIssue called");
        Integer issueId = issueDTO.getIssueId();
        String description = issueDTO.getDescription();
        Integer urgency = issueDTO.getUrgency();
        Integer assignedTo = issueDTO.getAssignedTo();
        return issueService.updateIssue(issueId, description, urgency, assignedTo);
    }
}
