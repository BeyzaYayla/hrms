package springproject.hrms.core.utilities.Verification.EmailVerification;

import fakeEmailVerification.FakeEmailVerificationManager;
import org.springframework.stereotype.Service;
import springproject.hrms.core.utilities.results.ErrorResult;
import springproject.hrms.core.utilities.results.Result;
import springproject.hrms.core.utilities.results.SuccessResult;

@Service
public class FakeEmailVerificationManagerAdapter implements EmailVerificationService{

    @Override
    public Result verifyEmail(String email) {
        FakeEmailVerificationManager verifier = new FakeEmailVerificationManager();
        var result = verifier.sendVerificationEmail(email);
        if (!result){
            return new ErrorResult("Verification failed");
        }
        return new SuccessResult("Email verified");
    }
}
