package Work1.Project1.Package.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table
public class EmployeeEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    public EmployeePK employeePK;

    @Getter @Setter
    @Column(name="empName")
    private String empName;

    @Getter @Setter
    @Column(name="phone")
    private String phone;

    @Getter @Setter
    @Column(name="salary")
    private int salary;

}
