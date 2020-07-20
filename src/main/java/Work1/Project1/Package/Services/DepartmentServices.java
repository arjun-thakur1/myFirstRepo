package Work1.Project1.Package.Services;

import Work1.Project1.Package.Entity.CompanyEntity;
import Work1.Project1.Package.Entity.DepartmentEntity;
import Work1.Project1.Package.Entity.DepartmentPK;
import Work1.Project1.Package.Entity.EmployeeEntity;
import Work1.Project1.Package.Repository.CompanyRepository;
import Work1.Project1.Package.Repository.DepartmentRepository;
import Work1.Project1.Package.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.ManyToOne;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServices {

    @Autowired
    private DepartmentRepository departmentRepository;
    private CompanyRepository companyRepository;
    private EmployeeRepository employeeRepository;
    public List<DepartmentEntity> getAllDetails() {
        return this.departmentRepository.findAll();
    }


    public String addDepartment(DepartmentEntity departmentEntity) {
        String companyId= departmentEntity.getDepartmentPK().getCompanyId();
        boolean companyPresent=companyRepository.existsById(companyId);
        if(companyPresent) {
            this.departmentRepository.save(departmentEntity);
            return "Successfully added";
        }
        return "Company Not registered";
    }

    public Optional<DepartmentEntity> getDepartmentDetail(String departmentId, String companyId) {
        DepartmentPK departmentPK = new  DepartmentPK(departmentId,companyId);

        return this.departmentRepository.findById(departmentPK);
    }

    public void deleteDepartmentDetails(DepartmentPK departmentPK) throws Exception{

            this.departmentRepository.deleteById(departmentPK);
        return;
    }


    public void updateDetails(DepartmentEntity updatedepartmentEntity) {

        Optional<DepartmentEntity> fetcheddepartmentEntity=departmentRepository.findById(updatedepartmentEntity.getDepartmentPK());

        if(fetcheddepartmentEntity.isPresent())
        {
            DepartmentEntity departmentEntity=fetcheddepartmentEntity.get();
            if(updatedepartmentEntity.getDepartmentName()==null)
            {
                updatedepartmentEntity.setDepartmentName(departmentEntity.getDepartmentName());
            }
            if(updatedepartmentEntity.getManagerId()==null)
            {
                updatedepartmentEntity.setManagerId(departmentEntity.getManagerId());
            }
        }

        departmentRepository.save(updatedepartmentEntity);
        return;
    }
/*
    public List<Object>  getAllDepartmentsOfCompany(String companyId)
      {
          List<DepartmentEntity> departmentEntityList= departmentRepository.findByDepartmentPKCompanyId(companyId);

          departmentEntityList.forEach((d) -> {
              List<EmployeeEntity> employeeEntityList= employeeRepository.findAllByEmployeePKCompanyIdAndDepartmentId(companyId,d.getDepartmentPK().getDepartmentId());

          });

          return ;
      }

 */
}
