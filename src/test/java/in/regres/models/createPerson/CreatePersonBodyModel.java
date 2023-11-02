package in.regres.models.createPerson;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CreatePersonBodyModel {
    private String name;
    private String job;
}
