package springproject.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerForRegisterDto {

    private String companyName;
    private String website;
    private String email;
    private String phone;
    private String password;
    private String passwordAgain;
}
