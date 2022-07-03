package al.sda.finalproject.bakeoff.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String position;
    private double wage;
    private Date startDate;
    @OneToOne
    private AccountEntity account;
}
