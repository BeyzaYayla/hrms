package springproject.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springproject.hrms.business.abstracts.ResumeService;
import springproject.hrms.core.utilities.results.DataResult;
import springproject.hrms.core.utilities.results.Result;
import springproject.hrms.core.utilities.results.SuccessDataResult;
import springproject.hrms.core.utilities.results.SuccessResult;
import springproject.hrms.dataAccess.abstracts.ResumeDao;
import springproject.hrms.entities.concretes.Resume;
import springproject.hrms.entities.concretes.School;

import java.util.List;

@Service
public class ResumeManager implements ResumeService {

    private ResumeDao resumeDao;

    @Autowired
    public ResumeManager(ResumeDao resumeDao) {
        this.resumeDao = resumeDao;
    }

    @Override
    public Result add(Resume resume) {
        this.resumeDao.save(resume);
        return new SuccessResult("resume added");
    }

    @Override
    public DataResult<Resume> getById(int resumeId) {
        return new SuccessDataResult<Resume>(this.resumeDao.getById(resumeId), "Resume found");
    }

    @Override
    public DataResult<List<Resume>> getResumesByUserId(int userId) {
        return new SuccessDataResult<List<Resume>>(this.resumeDao.getResumeByJobSeeker_Id(userId),"Resumes of the user found");
    }

    @Override
    public DataResult<List<School>> getSchools(int resumeId) {
        return new SuccessDataResult<List<School>>(this.resumeDao.getSchools(resumeId));
    }

}
