package al.sda.finalproject.bakeoff.entity;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String state;
    private String city;
    private String street;
    @Column(name = "postal_code")
    private String postalCode;
}
