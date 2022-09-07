package kodlamaIO.HRMS.adapters.concretes;

import kodlamaIO.HRMS.adapters.abstracts.CheckService;
import kodlamaIO.HRMS.entites.concretes.Candidate;
import kodlamaIO.mernis.JKOKPSPublicSoap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MernisAdapter implements CheckService {

    private JKOKPSPublicSoap kpsPublic;

    @Autowired
    public MernisAdapter() {
        kpsPublic = new JKOKPSPublicSoap();
    }

    @Override
    public boolean checkIfRealPerson(Candidate candidate) throws Exception {
        return kpsPublic.TCKimlikNoDogrula(Long.parseLong(candidate.getTcNo()), candidate.getFirstName(),
                candidate.getLastName(), candidate.getBirthYear());
    }
}
