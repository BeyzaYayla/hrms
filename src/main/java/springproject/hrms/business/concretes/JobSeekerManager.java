package springproject.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springproject.hrms.business.abstracts.JobSeekerService;
import springproject.hrms.core.utilities.results.DataResult;
import springproject.hrms.core.utilities.results.Result;
import springproject.hrms.core.utilities.results.SuccessDataResult;
import springproject.hrms.core.utilities.results.SuccessResult;
import springproject.hrms.dataAccess.abstracts.JobSeekerDao;
import springproject.hrms.entities.concretes.JobSeeker;

import java.util.List;

@Service
public class JobSeekerManager implements JobSeekerService {

    private JobSeekerDao jobSeekerDao;

    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao) {
        this.jobSeekerDao = jobSeekerDao;
    }

    @Override
    public DataResult<JobSeeker> getByNationalityId(long nationalityId) {
        return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.findByNationalityId(nationalityId));
    }

    @Override
    public DataResult<List<JobSeeker>> getAll() {
        return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), "Job seekers listed");
    }

    @Override
    public Result add(JobSeeker jobSeeker) {
        this.jobSeekerDao.save(jobSeeker);
        return new SuccessResult("Job seeker added");
    }
}
