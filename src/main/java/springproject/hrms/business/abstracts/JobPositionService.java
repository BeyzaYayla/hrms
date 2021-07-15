package springproject.hrms.business.abstracts;

import springproject.hrms.entities.concretes.JobPosition;

import java.util.List;

public interface JobPositionService {

    List<JobPosition> getAll();
}
