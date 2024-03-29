package springproject.hrms.api.controllers;

import org.springframework.web.bind.annotation.*;
import springproject.hrms.business.abstracts.JobAdvertService;
import springproject.hrms.core.utilities.results.DataResult;
import springproject.hrms.core.utilities.results.Result;
import springproject.hrms.entities.concretes.JobAdvert;
import springproject.hrms.entities.dtos.JobAdvertDto;
import java.util.List;

@RestController
@RequestMapping("/api/job_ads")
public class JobAdvertsController {

    private JobAdvertService jobAdvertService;

    public JobAdvertsController(JobAdvertService jobAdvertService) {
        this.jobAdvertService = jobAdvertService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobAdvert>> getAll(){
        return this.jobAdvertService.getAll();
    }

    @GetMapping("/getallActive")
    public DataResult<List<JobAdvert>> getAllActive(){
        return this.jobAdvertService.getAllActive();
    }

    @GetMapping("/getallOrdered")
    public DataResult<List<JobAdvert>> getAllSortedByDateAsc(){
        return this.jobAdvertService.getAllSortedByDateAsc();
    }

    @GetMapping("/getallOrderedDesc")
    public DataResult<List<JobAdvert>> getAllSortedByDateDesc(){
        return this.jobAdvertService.getAllSortedByDateDesc();
    }

    @GetMapping("/getallActiveWithDetails")
    public DataResult<List<JobAdvertDto>> getAllActiveJobAdvertDetails(){
        return this.jobAdvertService.getAllActiveJobAdvertDetails();
    }

    @GetMapping("/getById")
    public DataResult<JobAdvert> getById(@RequestParam int id){
        return this.jobAdvertService.getById(id);
    }

    @GetMapping("/getByCompany")
    public DataResult<List<JobAdvert>> getByCompany(@RequestParam int employerId){
        return this.jobAdvertService.getByCompany(employerId);
    }

    @GetMapping("/deactivate_advert")
    public Result deactivateJobAdvert(@RequestParam int id){
        return this.jobAdvertService.deactivateJobAdvert(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobAdvert jobAdvert){
        return this.jobAdvertService.add(jobAdvert);
    }

}
