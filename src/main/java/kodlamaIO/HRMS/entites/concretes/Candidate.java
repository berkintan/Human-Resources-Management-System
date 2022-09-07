package kodlamaIO.HRMS.entites.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="candidates")
@Data
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="id")
public class Candidate extends User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="identity_number")
    private String tcNo;
    @Column(name="birth_year")
    private int birthYear;
}


