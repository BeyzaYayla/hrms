package springproject.hrms.business.abstracts;

import springproject.hrms.core.utilities.results.DataResult;
import springproject.hrms.core.utilities.results.Result;
import springproject.hrms.entities.concretes.JobSeeker;

import java.util.List;

public interface JobSeekerService {

    DataResult<JobSeeker> getByNationalityId(String nationalityId);
    DataResult<List<JobSeeker>> getAll();
    Result add(JobSeeker jobSeeker);
}
