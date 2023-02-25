package springproject.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="links")
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "url")
    private String url;

    @ManyToOne
    @JoinColumn(name="resume_id",referencedColumnName = "id")
    private Resume resume;
}
