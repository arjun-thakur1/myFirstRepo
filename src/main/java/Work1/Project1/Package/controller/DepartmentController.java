package Work1.Project1.Package.controller;

import Work1.Project1.Package.entity.DepartmentEntity;
import Work1.Project1.Package.entity.DepartmentPK;
import Work1.Project1.Package.services.DepartmentServices;
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
    public Optional<DepartmentEntity> getDepartmentDetails(@RequestParam("departmentId") Long departmentId,
                                                           @RequestParam("companyId") Long companyId) {

        return departmentService.getDepartmentDetail(departmentId, companyId);
    }


    @DeleteMapping("/department/")
    public String deleteDepartment(@RequestParam("department_id") Long department_id,
                                 @RequestParam("company_id") Long company_id) throws Exception {
        DepartmentPK departmentPK = new DepartmentPK(department_id, company_id);
        departmentService.deleteDepartmentDetails(departmentPK);
        return "Deleted successfully";
    }

    @PostMapping(value = "/department", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addDepartmentDetails(@RequestBody DepartmentEntity departmentEntity) {
       return departmentService.addDepartment(departmentEntity);

    }


    @RequestMapping(value = "/department/update_details", method = RequestMethod.PUT)
    public String updateDepartmentDetails(@RequestBody DepartmentEntity departmentEntity) {

        departmentService.updateDetails(departmentEntity);
       return "Updated Successfully";
    }



    //completeOrginazation()

}
