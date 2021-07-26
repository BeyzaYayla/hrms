package springproject.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springproject.hrms.business.abstracts.AuthService;
import springproject.hrms.core.utilities.results.Result;
import springproject.hrms.entities.concretes.Employer;
import springproject.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/employer_register")
    public Result employerRegister(@RequestBody Employer employer, @RequestParam String passwordRepeat){
        return this.authService.employerRegister(employer, passwordRepeat);
    }

    @PostMapping("/job_seeker_register")
    public Result jobSeekerRegister(@RequestBody JobSeeker jobSeeker, @RequestParam String passwordRepeat) throws Exception {
        return this.authService.jobSeekerRegister(jobSeeker, passwordRepeat);
    }
}
