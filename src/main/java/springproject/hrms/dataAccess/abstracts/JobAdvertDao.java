package springproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import springproject.hrms.entities.concretes.JobAdvert;
import springproject.hrms.entities.dtos.JobAdvertDto;

import java.util.List;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer> {

    List<JobAdvert> getByIsActiveTrue();
    List<JobAdvert> getByIsActiveTrueOrderByCreateDateDesc();
    List<JobAdvert> getByIsActiveTrueOrderByCreateDateAsc();
    List<JobAdvert> getByIsActiveTrueAndEmployer_Id(int employerId);

    @Query("Select new springproject.hrms.entities.dtos.JobAdvertDto(e.companyName,jp.name,j.numberOfOpenPositions,j.createDate,j.deadline)"
            + "From Employer e Inner Join e.jobAdverts j Inner Join j.jobPosition jp where j.isActive = true")
    List<JobAdvertDto> getActiveJobAdvertDetails();

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("Update JobAdvert j Set j.isActive = false Where j.id = :adId")
    void deactivateJobAdvert(@Param("adId") int id);
}
