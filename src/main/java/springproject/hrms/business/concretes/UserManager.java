package springproject.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springproject.hrms.business.abstracts.UserService;
import springproject.hrms.core.utilities.results.DataResult;
import springproject.hrms.core.utilities.results.Result;
import springproject.hrms.core.utilities.results.SuccessDataResult;
import springproject.hrms.core.utilities.results.SuccessResult;
import springproject.hrms.dataAccess.abstracts.UserDao;
import springproject.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService {

    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Result add(User user) {
        this.userDao.save(user);
        return new SuccessResult("User added");
    }

    @Override
    public DataResult<User> getByMail(String email) {
        return new SuccessDataResult<User>(this.userDao.findByEmail(email));
    }
}
