package springproject.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="job_adverts")
public class JobAdvert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="min_salary", nullable = true)
    private int minSalary;

    @Column(name="max_salary", nullable = true)
    private int maxSalary;

    @Column(name="number_of_open_positions")
    private int numberOfOpenPositions;

    @Column(name="job_description")
    private String jobDescription;

    @Column(name="create_date")
    private LocalDate createDate = LocalDate.now();

    @Column(name="deadline")
    private LocalDate deadline;

    @Column(name="is_active")
    private boolean isActive=true;

    @ManyToOne
    @JoinColumn(name="employer_id",referencedColumnName = "user_id")
    private Employer employer;

    @ManyToOne
    @JoinColumn(name="job_position_id",referencedColumnName = "id")
    private JobPosition jobPosition;

    @ManyToOne
    @JoinColumn(name="city_id",referencedColumnName = "id")
    private City city;
}
