package kodlamaIO.HRMS.dataAccess.abstracts;

import kodlamaIO.HRMS.entites.concretes.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateDao extends JpaRepository<Candidate,Integer> {

    Candidate findByEmail(String email);
    Candidate findByTcNo(String tcNo);
}
