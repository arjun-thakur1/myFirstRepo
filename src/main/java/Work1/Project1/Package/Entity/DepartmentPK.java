package Work1.Project1.Package.Entity;

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

    private String companyId;
    private String departmentId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public DepartmentPK()
    {

    }
    public DepartmentPK(String departmentId,String companyId)
    {
        this.companyId=companyId;
        this.departmentId=departmentId;
    }


}
