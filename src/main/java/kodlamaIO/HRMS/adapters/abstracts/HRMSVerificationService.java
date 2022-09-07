package kodlamaIO.HRMS.adapters.abstracts;

import kodlamaIO.HRMS.core.utilities.results.Result;
import kodlamaIO.HRMS.entites.concretes.Employer;

public interface HRMSVerificationService {
    Result verifiedByHRMS(Employer employer);
}
