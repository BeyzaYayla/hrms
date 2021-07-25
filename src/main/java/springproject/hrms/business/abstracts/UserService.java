package springproject.hrms.business.abstracts;

import springproject.hrms.core.utilities.results.DataResult;
import springproject.hrms.core.utilities.results.Result;
import springproject.hrms.entities.concretes.User;

import java.util.List;

public interface UserService {

    Result add(User user);
    DataResult<User> getByMail(String email);
}
