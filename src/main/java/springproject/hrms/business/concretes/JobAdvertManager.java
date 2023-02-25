package springproject.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springproject.hrms.business.abstracts.JobAdvertService;
import springproject.hrms.core.utilities.business.BusinessRules;
import springproject.hrms.core.utilities.results.*;
import springproject.hrms.dataAccess.abstracts.JobAdvertDao;
import springproject.hrms.entities.concretes.JobAdvert;
import springproject.hrms.entities.dtos.JobAdvertDto;

import java.time.LocalDate;
import java.util.List;

@Service
public class JobAdvertManager implements JobAdvertService {

    private JobAdvertDao jobAdvertDao;

    @Autowired
    public JobAdvertManager(JobAdvertDao jobAdvertDao) {
        this.jobAdvertDao = jobAdvertDao;
    }

    @Override
    public DataResult<List<JobAdvert>> getAll() {
        return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll(), "All job adverts listed");
    }

    @Override
    public DataResult<List<JobAdvert>> getAllActive() {
        return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByIsActiveTrue(), "All active job adverts listed");
    }

    @Override
    public DataResult<List<JobAdvert>> getAllSortedByDateDesc() {
        return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByIsActiveTrueOrderByCreateDateDesc(),
                "All active job adverts ordered by date descending");
    }

    @Override
    public DataResult<List<JobAdvert>> getAllSortedByDateAsc() {
        return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByIsActiveTrueOrderByCreateDateAsc(),
                "All active job adverts ordered by date ascending");
    }

    @Override
    public DataResult<List<JobAdvertDto>> getAllActiveJobAdvertDetails() {
        return new SuccessDataResult<List<JobAdvertDto>>(this.jobAdvertDao.getActiveJobAdvertDetails());
    }

    @Override
    public DataResult<JobAdvert> getById(int id) {
        return new SuccessDataResult<JobAdvert>(this.jobAdvertDao.findById(id).get());
    }

    @Override
    public DataResult<List<JobAdvert>> getByCompany(int employerId) {
        return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByIsActiveTrueAndEmployer_Id(employerId),
                "All active job adverts published by company listed");
    }

    @Override
    public Result deactivateJobAdvert(int id) {
        this.jobAdvertDao.deactivateJobAdvert(id);
        return new SuccessResult("Job advert deactivated");
    }

    @Override
    public Result add(JobAdvert jobAdvert) {

        Result result = BusinessRules.Run(checkDate(jobAdvert.getDeadline()));

        if (result != null){
            return result;
        }

        this.jobAdvertDao.save(jobAdvert);
        return new SuccessResult("Job advert added");
    }

    private Result checkDate(LocalDate deadline){
        if (deadline.isBefore(LocalDate.now())){
            return new ErrorResult("Deadline must be today or after");
        }
        return new SuccessResult();
    }
}
