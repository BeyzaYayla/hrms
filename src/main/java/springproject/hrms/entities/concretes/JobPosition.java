package springproject.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="job_positions")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdverts","jobExperiences"})
public class JobPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "jobPosition")
    private List<JobAdvert> jobAdverts;

    @JsonIgnore
    @OneToMany(mappedBy = "jobPosition")
    private List<JobExperience> jobExperiences;
}
