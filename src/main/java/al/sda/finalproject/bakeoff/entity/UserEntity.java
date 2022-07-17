package al.sda.finalproject.bakeoff.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.management.relation.Role;
import javax.validation.constraints.NotBlank;


import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "first_name")
    @NotBlank
    @Size(max = 100)
    private String firstName;

    @Column(name = "last_name")
    @NotBlank
    @Size(max = 100)
    private String lastName;

    @Column(name = "email")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private AddressEntity address;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity role;
//@ManyToMany(fetch = FetchType.EAGER)
//private Set<RoleEntity> roles;

    private String password;

    private String username;
}
