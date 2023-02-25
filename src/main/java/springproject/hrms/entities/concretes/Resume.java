package springproject.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="resumes")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","schools","jobExperiences","links","languages","technologies"})
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "about")
    private String about;

    @ManyToOne
    @JoinColumn(name="user_id",referencedColumnName = "user_id")
    private JobSeeker jobSeeker;

    @JsonIgnore
    @ManyToMany
    @JoinTable
    private List<School> schools;

    @JsonIgnore
    @OneToMany(mappedBy = "resume")
    private List<JobExperience> jobExperiences;

    @JsonIgnore
    @OneToMany(mappedBy = "resume")
    private List<Link> links;

    @JsonIgnore
    @ManyToMany
    @JoinTable
    private List<Language> languages;

    @JsonIgnore
    @ManyToMany
    @JoinTable
    private List<Technology> technologies;
}
