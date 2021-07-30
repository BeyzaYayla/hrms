package springproject.hrms.business.abstracts;

import springproject.hrms.core.utilities.results.DataResult;
import springproject.hrms.core.utilities.results.Result;
import springproject.hrms.entities.concretes.JobAdvert;
import springproject.hrms.entities.dtos.JobAdvertDto;

import java.util.List;

public interface JobAdvertService {

    DataResult<List<JobAdvert>> getAll();
    DataResult<List<JobAdvert>> getAllActive();
    DataResult<List<JobAdvert>> getAllSortedByDateDesc();
    DataResult<List<JobAdvert>> getAllSortedByDateAsc();
    DataResult<List<JobAdvertDto>> getAllActiveJobAdvertDetails();
    DataResult<JobAdvert> getById(int id);
    DataResult<List<JobAdvert>> getByCompany(int employerId);
    Result deactivateJobAdvert(int id);
    Result add(JobAdvert jobAdvert);
}
