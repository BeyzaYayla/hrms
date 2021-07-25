package springproject.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobSeekerForRegisterDto {

    private String firstName;
    private String lastName;
    private String nationalityId;
    private Date birthDate;
    private String email;
    private String password;
    private String passwordAgain;
}
