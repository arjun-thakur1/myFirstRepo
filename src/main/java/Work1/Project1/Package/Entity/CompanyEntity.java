package Work1.Project1.Package.Entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table  //(name="company_table")
public class CompanyEntity {

    @Column(name="company_name")
    private String companyName;
    @Column(name="ceo_name")
    private String ceoName;

    @Id
    @Column(name="company_id")
    private String  companyId;

    @OneToMany(mappedBy = "company_id")
    private Set<DepartmentEntity> departments;

    public CompanyEntity() {
    }

    public CompanyEntity(String companyName, String ceoName, String companyId) {
        this.companyName = companyName;
        this.ceoName = ceoName;
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCeoName() {
        return ceoName;
    }

    public void setCeoName(String ceoName) {
        this.ceoName = ceoName;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }


}
