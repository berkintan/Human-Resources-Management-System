package kodlamaIO.HRMS.business.abstracts;

import kodlamaIO.HRMS.core.utilities.results.DataResult;
import kodlamaIO.HRMS.core.utilities.results.Result;
import kodlamaIO.HRMS.entites.concretes.Candidate;

import java.util.List;

public interface CandidateService {
    DataResult<List<Candidate>> getAll();
    Result register(Candidate candidate) throws Exception;
}
