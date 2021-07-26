package springproject.hrms.core.utilities.Verification.nationalityIdVerification;

import springproject.hrms.core.utilities.results.Result;
import springproject.hrms.entities.concretes.JobSeeker;

public interface NationalityIdVerificationService {
    Result verify(JobSeeker jobSeeker) throws Exception;
}
