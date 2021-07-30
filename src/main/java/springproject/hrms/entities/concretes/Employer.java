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
@Table(name="employers")
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName="id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdverts"})
public class Employer extends User{

    @Column(name="company_name")
    private String companyName;

    @Column(name="website")
    private String website;

    @Column(name="phone")
    private String phone;

    @JsonIgnore
    @OneToMany(mappedBy = "employer")
    private List<JobAdvert> jobAdverts;

    public Employer(String email, String password, String companyName, String website, String phone) {
        super(email, password);
        this.companyName = companyName;
        this.website = website;
        this.phone = phone;
    }
}
