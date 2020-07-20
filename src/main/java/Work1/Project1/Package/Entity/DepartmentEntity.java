package Work1.Project1.Package.Entity;
import lombok.Data;

import lombok.Getter;
import lombok.Setter;
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
    public DepartmentPK departmentPK;


   // @ManyToOne(fetch = FetchType.LAZY)
    //private CompanyEntity companyEntity1;

    @Getter @Setter
    @Column(name="department_name")
    private String departmentName;

    @Getter @Setter
    @Column(name="manager_id")
    private String managerId;


}
