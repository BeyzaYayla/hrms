package springproject.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="schools")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","resumes"})
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "school_name")
    @NotBlank
    @NotNull
    private String schoolName;

    @Column(name = "department")
    @NotBlank
    @NotNull
    private String department;

    @Column(name = "start_date")
    @NotNull
    private LocalDate startDate;

    @Column(name = "graduation_date",nullable = true)
    private LocalDate graduationDate;

    @JsonIgnore
    @ManyToMany(mappedBy = "schools")
    private List<Resume> resumes;

    public School(int id, String schoolName, String department, LocalDate startDate, LocalDate graduationDate) {
        this.id = id;
        this.schoolName = schoolName;
        this.department = department;
        this.startDate = startDate;
        this.graduationDate = graduationDate;
    }
}
