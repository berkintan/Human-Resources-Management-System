package kodlamaIO.HRMS.adapters.abstracts;

import kodlamaIO.HRMS.core.utilities.results.Result;
import kodlamaIO.HRMS.entites.concretes.Candidate;
import kodlamaIO.HRMS.entites.concretes.Employer;

public interface MailVerificationService {

    Result mailVarification(Candidate candidate);
    Result mailVarificationEmployer(Employer employer);
}
