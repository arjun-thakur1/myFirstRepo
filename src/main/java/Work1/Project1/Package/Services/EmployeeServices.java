package Work1.Project1.Package.Services;

import Work1.Project1.Package.Entity.DepartmentEntity;
import Work1.Project1.Package.Entity.DepartmentPK;
import Work1.Project1.Package.Entity.EmployeeEntity;
import Work1.Project1.Package.Entity.EmployeePK;
import Work1.Project1.Package.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServices {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeEntity> getAllDetails() {
        return this.employeeRepository.findAll();
    }

    public void addEmployee(EmployeeEntity employeeEntity) {

        this.employeeRepository.save(employeeEntity);
    }

    public void deleteEmployeeDetails(EmployeePK employeePK) throws Exception{
        try {
            this.employeeRepository.deleteById(employeePK);
        }catch(Exception e)
        {
            System.out.println("error ms" + e);
        }
    }

    public void updateDetails(EmployeeEntity updateemployeeEntity) {
        Optional<EmployeeEntity> fetchedemployeeEntity=employeeRepository.findById(updateemployeeEntity.getEmployeePK());
        if(fetchedemployeeEntity.isPresent())
        {
            EmployeeEntity employeeEntity=fetchedemployeeEntity.get();
            if(updateemployeeEntity.getEmpName()==null)
            {
                updateemployeeEntity.setEmpName(employeeEntity.getEmpName());
            }
            if(updateemployeeEntity.getPhone()==null)
            {
                updateemployeeEntity.setPhone(employeeEntity.getPhone());
            }
            if(updateemployeeEntity.getSalary()==0)
            {
                updateemployeeEntity.setSalary(employeeEntity.getSalary());
            }
        }
        employeeRepository.save(updateemployeeEntity);
        return;
    }

    public void updateAllCompanyEmployeeSalary(String companyId, int increment) {
        List<EmployeeEntity> employeeEntityList= employeeRepository.findAllByEmployeePKCompanyId(companyId);
        employeeEntityList.forEach((l) -> {
            l.setSalary(l.getSalary()+increment);
            updateDetails(l);
        });
    }


    public void updateAllDepartmentEmployeeSalary(String companyId, String departmentId, int increment) {

        List<EmployeeEntity> employeeEntityList= employeeRepository.findByIdCompanyIdAndIdDepartmentId(companyId,departmentId);;
        employeeEntityList.forEach((l) -> {
           // int salary=l.getSalary();
            l.setSalary(l.getSalary()+increment);
            updateDetails(l);
        });
    }


    public void updateEmployeeSalary(String companyId, String departmentId, String employeeId, int increment) {
        EmployeePK employeePK= new EmployeePK(employeeId,departmentId,companyId);
        List<EmployeeEntity> employeeEntityList= employeeRepository.findByEmployeePK(employeePK);
        employeeEntityList.forEach((l) -> {
            l.setSalary(l.getSalary()+increment);
            updateDetails(l);
        });
    }


}
