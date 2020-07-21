package Work1.Project1.Package.repository;

import Work1.Project1.Package.entity.EmployeeEntity;
import Work1.Project1.Package.entity.EmployeePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, EmployeePK>{


    public List<EmployeeEntity> findAllByEmployeePKCompanyId(Long companyId);

    //@Query("select me from EmployeeEntity me where me.EmployeePK.CompanyId = ?1 AND me.EmployeePK.DepartmentId=?2")
      public List<EmployeeEntity> findByEmployeePKCompanyIdAndEmployeePKDepartmentId(Long companyId,Long departmentId);

   public List<EmployeeEntity> findByEmployeePK(EmployeePK employeePK);

}
