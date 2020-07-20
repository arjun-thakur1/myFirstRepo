package Work1.Project1.Package.Controller;

import Work1.Project1.Package.Entity.CompanyEntity;
import Work1.Project1.Package.Entity.DepartmentEntity;
import Work1.Project1.Package.Entity.DepartmentPK;
import Work1.Project1.Package.Services.DepartmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentServices departmentService;

    @GetMapping("/department")
    public List<DepartmentEntity> getAllDepartmentsDetail() {
        return departmentService.getAllDetails();
    }

    @RequestMapping(value = "/department_by_ids", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<DepartmentEntity> getDepartmentDetails(@RequestParam("departmentId") String departmentId,
                                                           @RequestParam("companyId") String companyId) {

        return departmentService.getDepartmentDetail(departmentId, companyId);
    }


    @DeleteMapping("/department/")
    public void deleteDepartment(@RequestParam("department_id") String department_id,
                                 @RequestParam("company_id") String company_id) throws Exception {
        DepartmentPK departmentPK = new DepartmentPK(department_id, company_id);
        departmentService.deleteDepartmentDetails(departmentPK);
        return;
    }

    @PostMapping(value = "/department", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addDepartmentDetails(@RequestBody DepartmentEntity departmentEntity) {
       return departmentService.addDepartment(departmentEntity);

    }


    @RequestMapping(value = "/department/update_details", method = RequestMethod.PUT)
    public void updateDepartmentDetails(@RequestBody DepartmentEntity departmentEntity) {

        departmentService.updateDetails(departmentEntity);

    }



    //completeOrginazation()

}
