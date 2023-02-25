package springproject.hrms.business.abstracts;

import springproject.hrms.core.utilities.results.DataResult;
import springproject.hrms.core.utilities.results.Result;
import springproject.hrms.core.entities.User;

public interface UserService {

    Result add(User user);
    DataResult<User> findByEmail(String email);
}
