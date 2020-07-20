package Work1.Project1.Package.Repository;

import Work1.Project1.Package.Entity.DepartmentPK;
import Work1.Project1.Package.Entity.EmployeeEntity;
import Work1.Project1.Package.Entity.EmployeePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, EmployeePK>{


    public List<EmployeeEntity> findAllByEmployeePKCompanyId(String companyId);

    //@Query("select me from EmployeeEntity me where me.EmployeePK.CompanyId = ?1 AND me.EmployeePK.DepartmentId=?2")
      public List<EmployeeEntity> findByIdCompanyIdAndIdDepartmentId(String companyId,String departmentId);

   public List<EmployeeEntity> findByEmployeePK(EmployeePK employeePK);

}
