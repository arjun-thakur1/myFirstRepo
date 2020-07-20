package Work1.Project1.Package.Services;

import Work1.Project1.Package.Entity.CompanyEntity;
import Work1.Project1.Package.Interface.IDepartmentService;
import Work1.Project1.Package.Repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;


    public List<CompanyEntity> getAllDetails() {
        return this.companyRepository.findAll();
    }

    public void addCompany(CompanyEntity companyEntity) {

        this.companyRepository.save(companyEntity);
    }

    public Optional<CompanyEntity> getDetails(String id) {
        return this.companyRepository.findById(id);
    }

    public String deleteCompanyDetails(String company_id) {
        try {
        this.companyRepository.deleteById(company_id);
        return "Successfully Deleted";
        } catch (Exception e) {
            System.out.println(e);
            return "Error occured!!";
        }
    }

    public void updateDetails(CompanyEntity updatecompanyEntity) {       //String companyId, String companyName, String ceoName) {
       // CompanyEntity updatecompanyEntity=new CompanyEntity(companyName,ceoName,companyId);
        Optional<CompanyEntity> companyEntity=companyRepository.findById(updatecompanyEntity.getCompanyId());

        if(companyEntity.isPresent())
        {
            CompanyEntity fetchedcompanyEntity=companyEntity.get();
            if(updatecompanyEntity.getCompanyName()==null)
            {
                updatecompanyEntity.setCompanyName(fetchedcompanyEntity.getCompanyName());
            }
            if(updatecompanyEntity.getCeoName()==null)
            {
                updatecompanyEntity.setCeoName(fetchedcompanyEntity.getCeoName());
            }
        }

       companyRepository.save(updatecompanyEntity);
        return;
    }

 /*   public Object getCompanyCompleteDetails(String companyId) {

      Optional<CompanyEntity> companyEntity=  companyRepository.findById(companyId);
      if(companyEntity.isPresent())
      {
          DepartmentServices departmentServices = new DepartmentServices();
          departmentServices.
      }
    }

  */
}
