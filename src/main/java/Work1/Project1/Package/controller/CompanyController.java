package Work1.Project1.Package.controller;

import Work1.Project1.Package.entity.CompanyEntity;
import Work1.Project1.Package.services.CompanyService;
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
    public Optional<CompanyEntity> getCompanyDetails(@RequestParam("companyId") Long companyId) {
        return companyService.getDetails(companyId);
    }

    @DeleteMapping("/company/{company_id}")
    public String deleteCompany(@PathVariable("company_id") Long company_id) {
        return companyService.deleteCompanyDetails(company_id);


    }

    @RequestMapping(value="/company/update_details",method = RequestMethod.PUT)
     public String updateCompanyDetails(@RequestBody CompanyEntity companyEntity ) {         //@RequestParam("companyId") String companyId,@RequestParam(name="companyName", required = false)String companyName,@RequestParam(name="ceoName", required = false)String ceoName)
                                                                                           //@Pathvariable..@RequestBody....

        companyService.updateDetails(companyEntity);        //companyId, companyName, ceoName
        return "updated successfull";
    }


    @PostMapping(value = "/company", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addCompanyDetails(@RequestBody CompanyEntity companyEntity) {
        companyService.addCompany(companyEntity);
        return "Added SuccessfullY";
    }

    @GetMapping (value="/company_complete_details")
    public Object getCompanyCompleteDetails(@RequestParam("companyId") long companyId){
      return companyService.getCompanyCompleteDetails(companyId);
    }



}











