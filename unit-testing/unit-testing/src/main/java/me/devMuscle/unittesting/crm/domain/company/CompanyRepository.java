package me.devMuscle.unittesting.crm.domain.company;

import lombok.RequiredArgsConstructor;
import me.devMuscle.unittesting.crm.Transaction;
import me.devMuscle.unittesting.crm.domain.user.User;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class CompanyRepository {

    private final Transaction transaction;
    private final List<Company> companyStorage = new ArrayList<>();

    public Object[] getCompany() {
        Company company = companyStorage.get(0);
        return new Object[]{company.getDomainName(), company.getNumberOfEmployees()};
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
