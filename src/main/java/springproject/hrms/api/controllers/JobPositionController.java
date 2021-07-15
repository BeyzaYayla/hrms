package springproject.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springproject.hrms.business.abstracts.JobPositionService;
import springproject.hrms.core.utilities.results.DataResult;
import springproject.hrms.core.utilities.results.Result;
import springproject.hrms.entities.concretes.JobPosition;

import java.util.List;

@RestController
@RequestMapping("/api/job_positions")
public class JobPositionController {

    private JobPositionService jobPositionService;

    @Autowired
    public JobPositionController(JobPositionService jobPositionService) {
        this.jobPositionService = jobPositionService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobPosition>> getAll(){
        return this.jobPositionService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobPosition jobPosition){
        return this.jobPositionService.add(jobPosition);
    }
}
