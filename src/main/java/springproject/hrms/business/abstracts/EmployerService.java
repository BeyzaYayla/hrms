package springproject.hrms.business.abstracts;

import springproject.hrms.entities.concretes.Employer;

import java.util.List;

public interface EmployerService {

    List<Employer> getAll();
}
