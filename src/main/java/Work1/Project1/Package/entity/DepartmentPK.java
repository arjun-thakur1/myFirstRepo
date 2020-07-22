package Work1.Project1.Package.entity;

import lombok.Data;


import java.io.Serializable;
import javax.persistence.Embeddable;
//import javax.persistence.ManyToOne;

import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@Embeddable
public class DepartmentPK implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long companyId;
    private Long departmentId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public DepartmentPK()
    {

    }
    public DepartmentPK(Long departmentId,Long companyId)
    {
        this.companyId=companyId;
        this.departmentId=departmentId;
    }


}
