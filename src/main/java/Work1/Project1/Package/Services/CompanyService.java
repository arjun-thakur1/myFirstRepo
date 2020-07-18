package Work1.Project1.Package.Services;

import Work1.Project1.Package.Entity.CompanyEntity;
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
}
