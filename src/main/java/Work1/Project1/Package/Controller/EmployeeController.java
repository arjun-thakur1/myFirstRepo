package Work1.Project1.Package.Controller;


import Work1.Project1.Package.Entity.DepartmentEntity;
import Work1.Project1.Package.Entity.DepartmentPK;
import Work1.Project1.Package.Entity.EmployeeEntity;
import Work1.Project1.Package.Entity.EmployeePK;
import Work1.Project1.Package.Services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeServices employeeService;

    @GetMapping("/all_employee")
    public List<EmployeeEntity> getAllEmployeesDetail() {

        return employeeService.getAllDetails();
    }

    @PostMapping(value = "/add_employee", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addEmployeeDetails(@RequestBody EmployeeEntity employeeEntity) {

        employeeService.addEmployee(employeeEntity);
    }

    @DeleteMapping("/delete_employee")
    public void deleteEmployee(@RequestParam("employeeId") String employeeId,
                                 @RequestParam("departmentId") String departmentId,
                                 @RequestParam("companyId") String companyId) throws Exception {
        EmployeePK employeePK = new EmployeePK(employeeId, departmentId, companyId);
        employeeService.deleteEmployeeDetails(employeePK);
        return;
    }

    @RequestMapping(value = "/employee/update_details", method = RequestMethod.PUT)
    public void updateDepartmentDetails(@RequestBody EmployeeEntity employeeEntity) {

        employeeService.updateDetails(employeeEntity);
    }

    @RequestMapping(value = "/update_salary_absolute", method = RequestMethod.PUT)
    public void updateSalary(@RequestParam("companyId") String companyId,
                             @RequestParam(value = "departmentId", required = false) String departmentId,
                             @RequestParam(value = "employeeId", required = false) String employeeId,
                             @RequestParam("increment") int increment) {
        if (departmentId == null) {
            //increment for all emp in the org
            employeeService.updateAllCompanyEmployeeSalary(companyId, increment);
        }
        else if(employeeId==null)
        {
            //inc for all emp in dept in particular org
    //        employeeService.updateAllDepartmentEmployeeSalary(companyId,departmentId,increment);
        }
        else
        {
            employeeService.updateEmployeeSalary(companyId,departmentId,employeeId,increment);
        }
    }
/*
    @RequestMapping(value="/update_salary_percentage",method = RequestMethod.PUT)
    public void updateSalaryByPercentage(@RequestParam("companyId") String companyId,
                             @RequestParam(value = "departmentId",required = false) String departmentId,
                             @RequestParam(value = "employeeId",required = false) String employeeId,
                             @RequestParam("increment")int increment){
        if(departmentId==null)
        {
            //increment for all emp in the org
            employeeService.updateAllCompanyEmployeeSalary(companyId,increment);
        }
        else if(employeeId==null)
        {
            //inc for all emp in dept in particular org
 //          employeeService.updateAllDepartmentEmployeeSalary(companyId,departmentId,increment);
        }
        else
        {
            employeeService.updateEmployeeSalary(companyId,departmentId,employeeId,increment);
        }
    }

*/

}