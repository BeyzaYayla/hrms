package springproject.hrms.business.abstracts;

import springproject.hrms.core.utilities.results.DataResult;
import springproject.hrms.core.utilities.results.Result;
import springproject.hrms.entities.concretes.Resume;
import springproject.hrms.entities.concretes.School;

import java.util.List;

public interface ResumeService {

    Result add(Resume resume);
    DataResult<Resume> getById(int resumeId);

    DataResult<List<Resume>> getResumesByUserId(int userId);

    DataResult<List<School>> getSchools(int resumeId);
}
