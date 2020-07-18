package Work1.Project1.Package.Controller;

import Work1.Project1.Package.Entity.CompanyEntity;
import Work1.Project1.Package.Entity.DepartmentEntity;
import Work1.Project1.Package.Services.CompanyService;
import Work1.Project1.Package.Services.DepartmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentServices departmentService;

    @GetMapping("/department")
    public List<DepartmentEntity> getAllCompaniesDetails() {
        return departmentService.getAllDetails();
    }

    @PostMapping(value = "/department", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addDepartmentDetails(@RequestBody DepartmentEntity departmentEntity) {
        departmentService.addDepartment(departmentEntity);
        return "assa";
    }


}
