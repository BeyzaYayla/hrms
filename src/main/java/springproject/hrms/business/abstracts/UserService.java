package springproject.hrms.business.abstracts;

import springproject.hrms.entities.concretes.User;

import java.util.List;

public interface UserService {

    List<User> getAll();
}
