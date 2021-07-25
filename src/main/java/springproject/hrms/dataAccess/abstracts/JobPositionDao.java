package springproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import springproject.hrms.entities.concretes.JobPosition;

import java.util.List;

public interface JobPositionDao extends JpaRepository<JobPosition,Integer> {

    List<JobPosition> findJobPositionByNameEqualsIgnoreCase(String name);
}
