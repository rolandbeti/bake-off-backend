package al.sda.finalproject.bakeoff.entity;

import javax.persistence.*;

@Entity
@Table(name = "account_role")
public class AccountRoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "role_name")
    private String roleName;
}
