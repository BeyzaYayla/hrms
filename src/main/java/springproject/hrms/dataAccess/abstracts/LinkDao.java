package springproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import springproject.hrms.entities.concretes.Link;

public interface LinkDao extends JpaRepository<Link, Integer> {
}
