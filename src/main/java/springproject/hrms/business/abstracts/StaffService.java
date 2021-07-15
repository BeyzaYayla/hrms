package springproject.hrms.business.abstracts;

import springproject.hrms.entities.concretes.Staff;

import java.util.List;

public interface StaffService {

    List<Staff> getAll();
}
