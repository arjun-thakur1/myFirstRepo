package Work1.Project1.Package.Services;

import Work1.Project1.Package.Entity.DepartmentEntity;
import Work1.Project1.Package.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentServices {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<DepartmentEntity> getAllDetails() {
        return this.departmentRepository.findAll();
    }


    public void addDepartment(DepartmentEntity departmentEntity) {
        this.departmentRepository.save(departmentEntity);
    }
}
