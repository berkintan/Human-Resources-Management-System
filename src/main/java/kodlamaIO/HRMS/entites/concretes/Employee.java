package kodlamaIO.HRMS.entites.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name="employees")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name="id")
public class Employee extends User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="first_name")
    private String firstName;
    @Column(name="Last_name")
    private String lastName;
}
