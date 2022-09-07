package kodlamaIO.HRMS.business.abstracts;

import kodlamaIO.HRMS.core.utilities.results.DataResult;
import kodlamaIO.HRMS.core.utilities.results.Result;
import kodlamaIO.HRMS.entites.concretes.Employer;

import java.net.URISyntaxException;
import java.util.List;

public interface EmployerService {
    Result register(Employer employer) throws URISyntaxException;
    DataResult<List<Employer>> getAll();
}
