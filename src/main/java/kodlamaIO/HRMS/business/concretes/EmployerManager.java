package kodlamaIO.HRMS.business.concretes;

import kodlamaIO.HRMS.adapters.abstracts.CheckService;
import kodlamaIO.HRMS.adapters.abstracts.HRMSVerificationService;
import kodlamaIO.HRMS.adapters.abstracts.MailVerificationService;
import kodlamaIO.HRMS.business.abstracts.EmployerService;
import kodlamaIO.HRMS.core.utilities.results.*;
import kodlamaIO.HRMS.dataAccess.abstracts.EmployerDao;
import kodlamaIO.HRMS.entites.concretes.Employer;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EmployerManager implements EmployerService {

    private HRMSVerificationService hrmsVerificationService;
    private EmployerDao employerDao;
    private MailVerificationService mailVerificationService;
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public EmployerManager(EmployerDao employerDao) {
        this.employerDao = employerDao;
    }

    private Result isMailandDomainValid(String mail, String webAdress) throws URISyntaxException {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(mail);
        if(matcher.find()) {
            String mailDomain = mail.substring(mail.indexOf("@") + 1);
            URI uri = new URI(webAdress);
            String webAd = uri.getHost();
            String webDomain = webAd.startsWith("www.") ? webAd.substring(4) : webAd;
            if(mailDomain.equals(webDomain)) {
                return new SuccessResult();
            } else {
                return new ErrorResult("The mail and the web adress domain should be same!");
            }
        } else {
            return new ErrorResult("Please provide a authentic e-mail!");
        }
    }

    private Result isMailInUse(String mail) {
        if(this.employerDao.findByEmail(mail) == null) {
            return new SuccessResult();
        } else {
            return new ErrorResult("This e-mail is already in use!");
        }
    }

    @Override
    public Result register(Employer employer) throws URISyntaxException {
        if(employer.getEmail() == null || employer.getWebAdress() == null || employer.getPassword() == null || employer.getPhoneNumber() == null ||
            employer.getCompanyName() == null) {
            return new ErrorResult("Please fill all the fields!");
        } else if(isMailInUse(employer.getEmail()).isSuccess() && isMailandDomainValid(employer.getEmail(), employer.getWebAdress()).isSuccess()) {
            hrmsVerificationService.verifiedByHRMS(employer);
            mailVerificationService.mailVarificationEmployer(employer);
            this.employerDao.save(employer);
            return new SuccessResult("Registration successfull!");
        } else {
            return new ErrorResult("Registration not successful!" + isMailandDomainValid(employer.getEmail(), employer.getWebAdress()) + " " + isMailInUse(employer.getEmail()));
        }
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<>(this.employerDao.findAll(), "Data listed.");
    }
}
