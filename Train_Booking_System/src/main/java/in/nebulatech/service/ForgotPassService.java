//package in.nebulatech.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import in.nebulatech.bindings.Registration;
//
//import in.nebulatech.exception.RegistrationNotFoundException;
//import in.nebulatech.repository.RegistrationRepo;
//
//public class ForgotPassService {
//	
//	@Autowired
//    private RegistrationRepo registrationRepo;
//     
// 
//    public void updateResetPasswordToken(String token, String email) throws RegistrationNotFoundException {
//        Registration registration = registrationRepo.findByEmail(email);
//        if (registration != null) {
//            registration.setResetPasswordToken(token);
//            registrationRepo.save(registration);
//        } else {
//            throw new RegistrationNotFoundException("Could not find any registration data with the email " + email);
//        }
//    }
//     
//    public Registration getByResetPasswordToken(String token) {
//        return registrationRepo.findByResetPasswordToken(token);
//    }
//     
//    public void updatePassword(Registration registration, String newPassword) {
//    //    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//    //    String encodedPassword = passwordEncoder.encode(newPassword);
//      //  registration.setPassword(encodedPassword);
//         
//        registration.setResetPasswordToken(null);
//        registrationRepo.save(registration);
//    }
//
//}
