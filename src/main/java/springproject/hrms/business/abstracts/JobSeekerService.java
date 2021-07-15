package springproject.hrms.business.abstracts;

import springproject.hrms.entities.concretes.JobSeeker;

import java.util.List;

public interface JobSeekerService {

    List<JobSeeker> getAll();
}
