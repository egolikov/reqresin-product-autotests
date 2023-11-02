package in.regres.models.updatePerson;

import lombok.Data;

@Data
public class UpdatePersonResponseModel {
    private String name;
    private String job;
    private String updatedAt;
}