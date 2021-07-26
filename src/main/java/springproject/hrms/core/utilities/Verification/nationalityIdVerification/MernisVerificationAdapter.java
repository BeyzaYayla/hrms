package springproject.hrms.core.utilities.Verification.nationalityIdVerification;

import mernisReference.QAPKPSPublicSoap;
import org.springframework.stereotype.Service;
import springproject.hrms.core.utilities.results.ErrorResult;
import springproject.hrms.core.utilities.results.Result;
import springproject.hrms.core.utilities.results.SuccessResult;
import springproject.hrms.entities.concretes.JobSeeker;

@Service
public class MernisVerificationAdapter implements NationalityIdVerificationService{

    @Override
    public Result verify(JobSeeker jobSeeker) throws Exception {
        QAPKPSPublicSoap client = new QAPKPSPublicSoap();
        var result = client.TCKimlikNoDogrula(jobSeeker.getNationalityId(), jobSeeker.getFirstName(), jobSeeker.getLastName(), jobSeeker.getBirthYear());
        if (!result){
            return new ErrorResult("Nationality ID couldn't found in the system");
        }
        return new SuccessResult();
    }
}
