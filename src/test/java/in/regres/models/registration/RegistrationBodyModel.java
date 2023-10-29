package in.regres.models.registration;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RegistrationBodyModel {
    String email;
    String password;
}
