package me.devMuscle.unittesting.crm.domain.user;

import lombok.RequiredArgsConstructor;
import me.devMuscle.unittesting.crm.*;
import me.devMuscle.unittesting.crm.bus.MessageBus;
import me.devMuscle.unittesting.crm.domain.company.Company;
import me.devMuscle.unittesting.crm.domain.company.CompanyFactory;
import me.devMuscle.unittesting.crm.domain.company.CompanyRepository;
import me.devMuscle.unittesting.crm.domain.event.EventDispatcher;

@RequiredArgsConstructor
public class UserController {

    private final Transaction transaction;
    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;
    private final EventDispatcher eventDispatcher;

    public UserController (Transaction transaction, MessageBus messageBus, IDomainLogger domainLogger) {
        this.transaction = transaction;
        this.userRepository = new UserRepository(transaction);
        this.companyRepository = new CompanyRepository(transaction);
        this.eventDispatcher = new EventDispatcher(messageBus, domainLogger);
    }

    public String changeEmail(int userId, String newEmail) {
        // 데이터 준비
        Object[] userData = userRepository.getUserById(userId);
        User user = UserFactory.create(userData);

        String error = user.canChangeEmail();
        if(error != null) {
            return error;
        }

        Object[] companyData = companyRepository.getCompany();
        Company company = CompanyFactory.create(companyData);

        user.changeEmail(newEmail, company);

        companyRepository.saveCompany(company);
        userRepository.saveUser(user);
        // 사용자 도메인 이벤트 전달
        eventDispatcher.dispatch(user.getDomainEvents());
        //성공 시 트랜잭션 커밋
        transaction.commit();
        return "OK";
    }
}
