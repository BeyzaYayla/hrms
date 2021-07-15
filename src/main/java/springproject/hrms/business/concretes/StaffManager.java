package springproject.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springproject.hrms.business.abstracts.StaffService;
import springproject.hrms.dataAccess.abstracts.StaffDao;
import springproject.hrms.entities.concretes.Staff;

import java.util.List;

@Service
public class StaffManager implements StaffService {

    private StaffDao staffDao;

    @Autowired
    public StaffManager(StaffDao staffDao) {
        this.staffDao = staffDao;
    }

    @Override
    public List<Staff> getAll() {
        return null;
    }
}
