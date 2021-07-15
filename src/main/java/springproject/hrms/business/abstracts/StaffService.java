package springproject.hrms.business.abstracts;

import springproject.hrms.core.utilities.results.DataResult;
import springproject.hrms.entities.concretes.Staff;

import java.util.List;

public interface StaffService {

    DataResult<List<Staff>> getAll();
}
