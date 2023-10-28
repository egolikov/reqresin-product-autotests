package in.regres.models.authorization;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AuthorizationBodyModel {
    String email;
    String password;
}