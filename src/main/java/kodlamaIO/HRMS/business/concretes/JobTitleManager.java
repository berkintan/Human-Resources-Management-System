package kodlamaIO.HRMS.business.concretes;

import kodlamaIO.HRMS.business.abstracts.JobTitleService;
import kodlamaIO.HRMS.dataAccess.abstracts.JobTitleDao;
import kodlamaIO.HRMS.entites.concretes.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobTitleManager implements JobTitleService {

    private JobTitleDao jobTitleDao;

    @Autowired
    public JobTitleManager(JobTitleDao jobTitleDao) {
        this.jobTitleDao = jobTitleDao;
    }

    @Override
    public List<JobTitle> getAll() {
        return this.jobTitleDao.findAll();
    }
}
