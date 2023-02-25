package springproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import springproject.hrms.entities.concretes.Resume;
import springproject.hrms.entities.concretes.School;

import java.util.List;

public interface ResumeDao extends JpaRepository<Resume, Integer> {

    List<Resume> getResumeByJobSeeker_Id(int jobSeekerId);

    @Query("Select new springproject.hrms.entities.concretes.School(s.id, s.schoolName, s.department, s.startDate, s.graduationDate)" +
            " From School s Inner Join s.resumes r Where r.id = :resumeId Order By s.graduationDate Desc")
    List<School> getSchools(int resumeId);
}
