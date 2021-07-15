package springproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import springproject.hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User,Integer> {
}
