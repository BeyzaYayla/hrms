package springproject.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertDto {

    private String companyName;
    private String positionName;
    private int numberOfOpenPositions;
    private LocalDate createDate;
    private LocalDate deadline;
}
