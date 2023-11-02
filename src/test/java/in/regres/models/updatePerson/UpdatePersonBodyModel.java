package in.regres.models.updatePerson;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UpdatePersonBodyModel {
    private String name;
    private String job;
}