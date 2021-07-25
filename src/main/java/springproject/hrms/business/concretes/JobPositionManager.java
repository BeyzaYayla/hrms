package springproject.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springproject.hrms.business.abstracts.JobPositionService;
import springproject.hrms.core.utilities.results.*;
import springproject.hrms.dataAccess.abstracts.JobPositionDao;
import springproject.hrms.entities.concretes.JobPosition;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {

    private JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(), "Job positions listed");
    }

    @Override
    public Result add(JobPosition jobPosition) {

        if (!this.jobPositionDao.findJobPositionByNameEqualsIgnoreCase(jobPosition.getName()).isEmpty()){
            return new ErrorResult("Job position already exists");
        }

        this.jobPositionDao.save(jobPosition);
        return new SuccessResult("Job position added");
    }
}
