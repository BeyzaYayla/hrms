package springproject.hrms.business.abstracts;

import springproject.hrms.core.utilities.results.Result;
import springproject.hrms.entities.concretes.Employer;
import springproject.hrms.entities.concretes.JobSeeker;

public interface AuthService {

    Result employerRegister(Employer employer, String passwordRepeat);
    Result jobSeekerRegister(JobSeeker jobSeeker, String passwordRepeat) throws Exception;
}
