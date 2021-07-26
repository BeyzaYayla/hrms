package springproject.hrms.core.utilities.Verification.EmailVerification;

import springproject.hrms.core.utilities.results.Result;

public interface EmailVerificationService {
    Result verifyEmail(String email);
}
