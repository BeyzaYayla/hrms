package springproject.hrms.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springproject.hrms.business.abstracts.JobSeekerService;
import springproject.hrms.core.utilities.results.DataResult;
import springproject.hrms.entities.concretes.JobSeeker;

import java.util.List;

@RestController
@RequestMapping("/api/job_seekers")
public class JobSeekersController {

    private JobSeekerService jobSeekerService;

    public JobSeekersController(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobSeeker>> getAll(){
        return this.jobSeekerService.getAll();
    }
}
