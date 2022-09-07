package kodlamaIO.HRMS.business.concretes;

import kodlamaIO.HRMS.adapters.abstracts.CheckService;
import kodlamaIO.HRMS.adapters.abstracts.MailVerificationService;
import kodlamaIO.HRMS.business.abstracts.CandidateService;
import kodlamaIO.HRMS.core.utilities.results.*;
import kodlamaIO.HRMS.dataAccess.abstracts.CandidateDao;
import kodlamaIO.HRMS.entites.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateManager implements CandidateService {

    private CandidateDao candidateDao;
    private CheckService checkService;
    private MailVerificationService mailVerificationService;

    @Autowired
    public CandidateManager(CandidateDao candidateDao, CheckService checkService) {
        this.candidateDao = candidateDao;
        this.checkService = checkService;
    }

    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<>(this.candidateDao.findAll(), "Data listed.");
    }

    private Result isMailInUse(String email) {
        if(this.candidateDao.findByEmail(email) == null) {
            return new SuccessResult("");
        } else {
            return new ErrorResult("This e-mail is already in use!");
        }
    }

    private Result isTcNoInUse(String tcNo) {
        if(this.candidateDao.findByTcNo(tcNo) == null) {
            return new SuccessResult("");
        } else {
            return new ErrorResult("This TC No is already in use!");
        }
    }

    private Result checkIfRealPerson(Candidate candidate) throws Exception {
        if(this.checkService.checkIfRealPerson(candidate)) {
            return new SuccessResult("");
        } else {
            return new ErrorResult("Mernis verification not successfull!");
        }
    }

    @Override
    public Result register(Candidate candidate) throws Exception {
        if(isMailInUse(candidate.getEmail()).isSuccess() && isTcNoInUse(candidate.getTcNo()).isSuccess() &&
                checkIfRealPerson(candidate).isSuccess())  {
            this.candidateDao.save(candidate);
            mailVerificationService.mailVarification(candidate);
            return new SuccessResult("Candidate registered successfully.");
        } else if(candidate.getEmail() == null || candidate.getTcNo() == null || candidate.getFirstName() == null
                || candidate.getLastName() == null) {
            return new ErrorResult("Please fill all the fields!");
        } else {
            return new ErrorResult("Registration not succesfull! " + isTcNoInUse(candidate.getTcNo()).getMessage() +
                    isMailInUse(candidate.getEmail()).getMessage() + checkIfRealPerson(candidate).getMessage());
        }
    }

}
