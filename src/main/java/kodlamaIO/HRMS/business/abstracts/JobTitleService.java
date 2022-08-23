package kodlamaIO.HRMS.business.abstracts;

import kodlamaIO.HRMS.entites.concretes.JobTitle;

import java.util.List;

public interface JobTitleService {
    List<JobTitle> getAll();
}
