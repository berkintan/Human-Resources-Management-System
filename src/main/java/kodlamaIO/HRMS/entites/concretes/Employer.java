package kodlamaIO.HRMS.entites.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name="employers")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name="id")
public class Employer extends User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "web_address")
    private String webAdress;
    @Column(name="phone_number")
    private String phoneNumber;

}
