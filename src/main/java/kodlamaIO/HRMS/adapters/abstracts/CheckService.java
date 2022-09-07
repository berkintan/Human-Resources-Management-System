package kodlamaIO.HRMS.adapters.abstracts;

import kodlamaIO.HRMS.entites.concretes.Candidate;

public interface CheckService {

    boolean checkIfRealPerson(Candidate candidate) throws Exception;
}
