package me.devMuscle.unittesting.crm.domain.company;

import lombok.RequiredArgsConstructor;
import me.devMuscle.unittesting.crm.CrmContext;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class CompanyRepository {

    private final CrmContext crmContext;
    private final List<Company> companyStorage = new ArrayList<>();

    public Company getCompany() {
       return companyStorage.get(0);
    }

    public void saveCompany(Company company) {
        for(int i=0; i<companyStorage.size(); i++) {
            if(companyStorage.get(i).getDomainName().equals(company.getDomainName())) {
                companyStorage.set(i, company);
                return;
            }
        }
        companyStorage.add(company);
    }
}
