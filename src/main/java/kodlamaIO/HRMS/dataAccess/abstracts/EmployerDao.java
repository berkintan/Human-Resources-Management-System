package kodlamaIO.HRMS.dataAccess.abstracts;

import kodlamaIO.HRMS.entites.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerDao extends JpaRepository<Employer, Integer> {

    Employer findByEmail(String mail);


}
