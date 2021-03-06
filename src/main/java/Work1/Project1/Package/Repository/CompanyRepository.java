package Work1.Project1.Package.Repository;

import Work1.Project1.Package.Entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository   //so that this is scanned during classpath
public interface CompanyRepository extends JpaRepository<CompanyEntity, String> {

}
