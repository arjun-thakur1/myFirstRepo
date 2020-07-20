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

    @GetMapping(value="/company_by_id", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<CompanyEntity> getCompanyDetails(@RequestParam("companyId") String companyId) {
        return companyService.getDetails(companyId);
    }

    @DeleteMapping("/company/{company_id}")
    public String deleteCompany(@PathVariable("company_id") String company_id) {
        return companyService.deleteCompanyDetails(company_id);


    }

    @RequestMapping(value="/company/update_details",method = RequestMethod.PUT)
     public void updateCompanyDetails(@RequestBody CompanyEntity companyEntity ) {         //@RequestParam("companyId") String companyId,@RequestParam(name="companyName", required = false)String companyName,@RequestParam(name="ceoName", required = false)String ceoName)
                                                                                           //@Pathvariable..@RequestBody....

        companyService.updateDetails(companyEntity);        //companyId, companyName, ceoName
        return;
    }


    @PostMapping(value = "/company", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addCompanyDetails(@RequestBody CompanyEntity companyEntity) {
        companyService.addCompany(companyEntity);
        return;
    }
/*
    @GetMapping (value="company_complete_details")
    public List<Object> getCompanyCompleteDetails(@RequestParam("companyId") String companyId){

        return new Object( companyService.getCompanyCompleteDetails(companyId) );
    }

*/

}











