package springproject.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springproject.hrms.business.abstracts.ResumeService;
import springproject.hrms.core.utilities.results.Result;
import springproject.hrms.entities.concretes.Resume;

@RestController
@RequestMapping("/api/resumes")
public class ResumesController {

    private ResumeService resumeService;

    @Autowired
    public ResumesController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody Resume resume) {
        return this.resumeService.add(resume);
    }

    @GetMapping("/getbyid")
    public ResponseEntity<?> getById(@RequestParam int resumeId){
        return ResponseEntity.ok(this.resumeService.getById(resumeId));
    }

    @GetMapping("/getbyuserid")
    public ResponseEntity<?> getResumesByUserId(@RequestParam int userId){
        return ResponseEntity.ok(this.resumeService.getResumesByUserId(userId));
    }

    @GetMapping("/getschools")
    public ResponseEntity<?> getSchools(@RequestParam int resumeId){
        return ResponseEntity.ok(this.resumeService.getSchools(resumeId));
    }
}
