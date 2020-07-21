package Work1.Project1.Package.controller;


import Work1.Project1.Package.entity.EmployeeEntity;
import Work1.Project1.Package.entity.EmployeePK;
import Work1.Project1.Package.services.EmployeeServices;
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
    public void deleteEmployee(@RequestParam("employeeId") Long employeeId,
                                 @RequestParam("departmentId") Long departmentId,
                                 @RequestParam("companyId") Long companyId) throws Exception {
        EmployeePK employeePK = new EmployeePK(employeeId, departmentId, companyId);
        employeeService.deleteEmployeeDetails(employeePK);
        return;
    }

    @RequestMapping(value = "/employee/update_details", method = RequestMethod.PUT)
    public void updateDepartmentDetails(@RequestBody EmployeeEntity employeeEntity) {

        employeeService.updateDetails(employeeEntity);
    }

    @RequestMapping(value = "/update_salary", method = RequestMethod.PUT)
    public void updateSalary(@RequestParam("companyId") Long companyId,
                             @RequestParam(value = "departmentId") Long departmentId,
                             @RequestParam(value = "employeeId") Long employeeId,
                             @RequestParam("increment") Long increment,
                             @RequestParam("flag") boolean flag ) {

        if(flag)
        {
            employeeService.updateSalaryByAbsoluteValue(companyId,departmentId,employeeId,increment);
            return;
        }
        else
        {
            employeeService.updateSalaryByPercentage(companyId,departmentId,employeeId,increment);
            return;
        }

    }






}