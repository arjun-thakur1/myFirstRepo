package Work1.Project1.Package.Entity;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class EmployeePK implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter private String employeeId;
    @Getter @Setter private String departmentId;
    @Getter @Setter private String companyId;


}
