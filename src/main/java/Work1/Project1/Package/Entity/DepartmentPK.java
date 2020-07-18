package Work1.Project1.Package.Entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import javax.persistence.ManyToOne;
@Embeddable
@Data
public class DepartmentPK implements Serializable {

    private static final long serialVersionUID = 1L;



    @Column(name="company_id")
    private String companyId;

    @Column(name="department_id")
    private String departmentId;


}
