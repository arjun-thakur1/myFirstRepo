package Work1.Project1.Package.Controller;

import Work1.Project1.Package.Entity.CompanyEntity;
import Work1.Project1.Package.Services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;  //CompanyRepository companyRepository;


    //get company details
    @GetMapping("/company")
    public List<CompanyEntity> getAllCompaniesDetails() {
        return companyService.getAllDetails();
    }

    @GetMapping("/company/{id}")
    public Optional<CompanyEntity> getCompaniesDetails(@RequestBody @PathVariable("id") String id) {
        return companyService.getDetails(id);
    }

    @PostMapping(value = "/company", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addCompanyDetails(@RequestBody CompanyEntity companyEntity) {
        companyService.addCompany(companyEntity);
        return;
    }



}

/*
    @GetMapping("/company")
    public String get() {
        return "hello ";
    }
    @PostMapping("/newCompany")
    String newCompany(@RequestBody CompanyEntity newCompany) throws Exception{
        try {
            this.companyRepository.save(newCompany);
            }catch(Exception e)
                {
                  System.out.println("in catch"+" "+e);
                  return "in catch";
                }
        return "Successful";
    }
}
    /*
    public List<CompanyEntity> getDetails() throws Exception{
        try  {
            return this.companyRepository.findAll();
              }
        catch (Exception e)
           {
               List<CompanyEntity> c = new ArrayList<>();
               System.out.println(e);
               return c;


           }
    }
*/
 /*   @PostMapping("/{pos}")
    public List<CompanyEntity> addData(@RequestBody CompanyEntity pos)
    {
        return this.companyRepository.;
    }
*/
