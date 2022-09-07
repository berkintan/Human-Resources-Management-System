package kodlamaIO.HRMS.adapters.concretes;

import kodlamaIO.HRMS.adapters.abstracts.HRMSVerificationService;
import kodlamaIO.HRMS.core.utilities.results.Result;
import kodlamaIO.HRMS.core.utilities.results.SuccessResult;
import kodlamaIO.HRMS.entites.concretes.Employer;

public class HRMSVerificationManager implements HRMSVerificationService {
    @Override
    public Result verifiedByHRMS(Employer employer) {
        return new SuccessResult("Employer verified by HRMS system.");
    }
}
