package Work1.Project1.Package.Repository;

import Work1.Project1.Package.Entity.DepartmentEntity;
import Work1.Project1.Package.Entity.DepartmentPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, DepartmentPK> {
   // public List<DepartmentEntity> findByCompanyId(String companyId);
    public List<DepartmentEntity> findByDepartmentPKCompanyId(String companyId);
}
