package springproject.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springproject.hrms.business.abstracts.AuthService;
import springproject.hrms.business.abstracts.EmployerService;
import springproject.hrms.business.abstracts.JobSeekerService;
import springproject.hrms.business.abstracts.UserService;
import springproject.hrms.core.utilities.Verification.EmailVerification.EmailVerificationService;
import springproject.hrms.core.utilities.business.BusinessRules;
import springproject.hrms.core.utilities.Verification.nationalityIdVerification.NationalityIdVerificationService;
import springproject.hrms.core.utilities.results.ErrorResult;
import springproject.hrms.core.utilities.results.Result;
import springproject.hrms.core.utilities.results.SuccessResult;
import springproject.hrms.entities.concretes.Employer;
import springproject.hrms.entities.concretes.JobSeeker;

@Service
public class AuthManager implements AuthService {

    private UserService userService;
    private EmployerService employerService;
    private JobSeekerService jobSeekerService;
    private NationalityIdVerificationService idVerificationService;
    private EmailVerificationService emailVerificationService;

    @Autowired
    public AuthManager(UserService userService, EmployerService employerService, JobSeekerService jobSeekerService, NationalityIdVerificationService verificationService, EmailVerificationService emailVerificationService) {
        this.userService = userService;
        this.employerService = employerService;
        this.jobSeekerService = jobSeekerService;
        this.idVerificationService = verificationService;
        this.emailVerificationService = emailVerificationService;
    }

    @Override
    public Result employerRegister(Employer employer, String passwordRepeat) {

        Result result = BusinessRules.Run(nullControlForEmployer(employer),
                checkEmailDomain(employer.getEmail(),employer.getWebsite()),
                emailExists(employer.getEmail()),
                emailVerification(employer.getEmail()),
                checkPassword(employer.getPassword(),passwordRepeat));

        if (result != null){
            return result;
        }

        this.employerService.add(employer);
        return new SuccessResult("Employer registered successfully");
    }

    @Override
    public Result jobSeekerRegister(JobSeeker jobSeeker, String passwordRepeat) throws Exception {

        Result result = BusinessRules.Run(nullControlForJobSeeker(jobSeeker),
                emailExists(jobSeeker.getEmail()),
                userExists(jobSeeker.getNationalityId()),
                mernisVerification(jobSeeker),
                emailVerification(jobSeeker.getEmail()),
                checkPassword(jobSeeker.getPassword(),passwordRepeat));

        if (result != null){
            return result;
        }

        this.jobSeekerService.add(jobSeeker);

        return new SuccessResult("Job seeker registered successfully");
    }

    private Result checkEmailDomain(String email, String website){
        String domain = website;
        if (!domain.contains(email.split("@")[1])){
            return new ErrorResult("Not a company email");
        }
        return new SuccessResult();
    }

    private Result emailExists(String email){
        var user = this.userService.findByEmail(email);

        if (user.getData() != null){
            return new ErrorResult("User already exists");
        }

        return new SuccessResult();
    }

    private Result userExists(long nationalityId){
        var user = this.jobSeekerService.getByNationalityId(nationalityId);

        if (user.getData() != null){
            return new ErrorResult("User already exists");
        }

        return new SuccessResult();
    }

    private Result mernisVerification(JobSeeker jobSeeker) throws Exception {
        return idVerificationService.verify(jobSeeker);
    }

    private Result emailVerification(String email) {
        return emailVerificationService.verifyEmail(email);
    }

    private Result checkPassword(String password, String passwordRepeat){
        if (!password.equals(passwordRepeat)){
            return new ErrorResult("Password is not same");
        }
        return new SuccessResult();
    }

    private Result nullControlForEmployer(Employer employer){

        if (employer.getEmail().isBlank() && employer.getCompanyName().isBlank() && employer.getWebsite().isBlank() &&
                employer.getPhone().isBlank() && employer.getPassword().isBlank()){
            return new ErrorResult("All fields must be filled");
        }

        return new SuccessResult();
    }

    private Result nullControlForJobSeeker(JobSeeker jobSeeker){

        if (jobSeeker.getEmail().isBlank() && jobSeeker.getFirstName().isBlank() && jobSeeker.getLastName().isBlank() &&
                jobSeeker.getNationalityId() == 0 && jobSeeker.getBirthYear() == 0 &&
                jobSeeker.getPassword().isBlank()){

            return new ErrorResult("All fields must be filled");
        }

        return new SuccessResult();
    }
}
