package Work1.Project1.Package.services;

import Work1.Project1.Package.entity.EmployeeEntity;
import Work1.Project1.Package.entity.EmployeePK;
import Work1.Project1.Package.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@CacheConfig(cacheNames={"employee_cache"})
@Component
public class EmployeeServices {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeEntity> getAllDetails() {
        return this.employeeRepository.findAll();
    }

    @Cacheable(value="employee_cache")
    public List<EmployeeEntity> getEmployeeDetails(EmployeePK employeePK) {
        return this.employeeRepository.findByEmployeePK(employeePK);
    }
    public void addEmployee(EmployeeEntity employeeEntity) {

        this.employeeRepository.save(employeeEntity);
    }

    @CacheEvict(value = "employee_cache", allEntries=true)
    public void deleteEmployeeDetails(EmployeePK employeePK) throws Exception{
        try {
            this.employeeRepository.deleteById(employeePK);
        }catch(Exception e)
        {
            System.out.println("error ms" + e);
        }
    }

    @CachePut(value = "employee_cache")
    public void  updateDetails(EmployeeEntity updateemployeeEntity) {
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







    public void  updateSalaryByAbsoluteValue(Long companyId,Long departmentId,Long employeeId,Long increment){
        if (departmentId == 0) {
            //increment for all emp in the org
            updateAllCompanyEmployeeSalary(companyId, increment);
        }
        else if(employeeId==0)
        {
            //inc for all emp in dept in particular org
            updateCompanyAllDepartmentEmployeeSalary(companyId,departmentId,increment);
        }
        else
        {
            updateEmployeeSalary(companyId,departmentId,employeeId,increment);
        }
    }

    public void updateSalaryByPercentage(long companyId,long departmentId,long employeeId,long increment) {
        if (departmentId == 0) {
            //increment for all emp in the org
            updateAllCompanyEmployeeSalaryByPercentage(companyId, increment);
        } else if (employeeId == 0) {
            //inc for all emp in dept in particular org
            updateAllDepartmentEmployeeSalarybyPercentage(companyId, departmentId, increment);
        } else {
            updateEmployeeSalaryByPercentage(companyId, departmentId, employeeId, increment);
        }
    }
    public void updateAllCompanyEmployeeSalary(Long companyId, Long increment) {
        List<EmployeeEntity> employeeEntityList= employeeRepository.findAllByEmployeePKCompanyId(companyId);
        employeeEntityList.forEach((l) -> {
            l.setSalary(l.getSalary()+increment);
            updateDetails(l);
        });
    }

    public void updateCompanyAllDepartmentEmployeeSalary(Long companyId, Long departmentId, Long increment) {

        List<EmployeeEntity> employeeEntityList= employeeRepository.findByEmployeePKCompanyIdAndEmployeePKDepartmentId(companyId,departmentId);;
        employeeEntityList.forEach((l) -> {
           // int salary=l.getSalary();
            l.setSalary(l.getSalary()+increment);
            updateDetails(l);
        });
    }


    public void updateEmployeeSalary(Long companyId, Long departmentId, Long employeeId, Long increment) {
        EmployeePK employeePK= new EmployeePK(employeeId,departmentId,companyId);
        List<EmployeeEntity> employeeEntityList= employeeRepository.findByEmployeePK(employeePK);
        employeeEntityList.forEach((l) -> {
            l.setSalary(l.getSalary()+increment);
            updateDetails(l);
        });
    }


    public void updateAllCompanyEmployeeSalaryByPercentage(long companyId, long increment) {
        List<EmployeeEntity> employeeEntityList= employeeRepository.findAllByEmployeePKCompanyId(companyId);
        employeeEntityList.forEach((l) -> {
            Long salary=l.getSalary();
            l.setSalary(salary+((increment*salary)/100));
            updateDetails(l);
        });
    }

    public void updateAllDepartmentEmployeeSalarybyPercentage(long companyId, long departmentId, long increment) {
        List<EmployeeEntity> employeeEntityList= employeeRepository.findByEmployeePKCompanyIdAndEmployeePKDepartmentId(companyId,departmentId);;
        employeeEntityList.forEach((l) -> {
            long salary=l.getSalary();
            l.setSalary(salary+((increment*salary)/100));
            updateDetails(l);
        });
    }

    public void updateEmployeeSalaryByPercentage(long companyId, long departmentId, long employeeId, long increment) {
        EmployeePK employeePK= new EmployeePK(employeeId,departmentId,companyId);
        List<EmployeeEntity> employeeEntityList= employeeRepository.findByEmployeePK(employeePK);
        employeeEntityList.forEach((l) -> {
            long salary=l.getSalary();
            l.setSalary(salary+((increment*salary)/100));
            updateDetails(l);
        });
    }


}
