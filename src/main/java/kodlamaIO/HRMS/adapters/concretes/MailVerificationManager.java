package kodlamaIO.HRMS.adapters.concretes;

import kodlamaIO.HRMS.adapters.abstracts.MailVerificationService;
import kodlamaIO.HRMS.core.utilities.results.Result;
import kodlamaIO.HRMS.core.utilities.results.SuccessResult;
import kodlamaIO.HRMS.entites.concretes.Candidate;
import kodlamaIO.HRMS.entites.concretes.Employer;

public class MailVerificationManager implements MailVerificationService {
    @Override
    public Result mailVarification(Candidate candidate) {
        return new SuccessResult("Verification e-mail sent to: " + candidate.getEmail());
    }

    @Override
    public Result mailVarificationEmployer(Employer employer) {
        return new SuccessResult("Verification e-mail sent to: " + employer.getEmail());
    }
}
