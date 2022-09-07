package kodlamaIO.HRMS.dataAccess.abstracts;

import kodlamaIO.HRMS.entites.concretes.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobTitleDao extends JpaRepository<JobTitle,Integer> {
}