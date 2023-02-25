package springproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import springproject.hrms.entities.concretes.School;

import java.util.List;

public interface SchoolDao extends JpaRepository<School,Integer> {
}
