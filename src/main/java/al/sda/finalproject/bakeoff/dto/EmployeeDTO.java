package al.sda.finalproject.bakeoff.dto;

import al.sda.finalproject.bakeoff.entity.AccountEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String position;
    private double wage;
    private Date startDate;
    private AccountEntity account;

}
