package Work1.Project1.Package.Entity;
import lombok.Data;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table
@Configuration
public class DepartmentEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private DepartmentPK departmentPK;

    @ManyToOne
    @JoinColumn(name="company_id")
    private CompanyEntity companyEntity;

    @Column(name="department_name")
    private String departmentName;

    @Column(name="manager_id")
    private String managerId;



}
