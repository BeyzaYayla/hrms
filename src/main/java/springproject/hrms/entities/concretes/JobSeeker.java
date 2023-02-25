package springproject.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import springproject.hrms.core.entities.User;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="job_seekers")
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName="id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","resumes"})
public class JobSeeker extends User {

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="birth_year")
    private Integer birthYear;

    @Column(name="nationality_id")
    private long nationalityId;

    @JsonIgnore
    @OneToMany(mappedBy = "jobSeeker")
    private List<Resume> resumes;

    public JobSeeker(String email, String password, String firstName, String lastName, Integer birthYear, long nationalityId) {
        super(email, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.nationalityId = nationalityId;
    }
}
