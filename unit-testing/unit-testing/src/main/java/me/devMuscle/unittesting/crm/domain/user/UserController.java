package me.devMuscle.unittesting.crm.domain.user;

import lombok.RequiredArgsConstructor;
import me.devMuscle.unittesting.crm.*;
import me.devMuscle.unittesting.crm.bus.MessageBus;
import me.devMuscle.unittesting.crm.domain.company.Company;
import me.devMuscle.unittesting.crm.domain.company.CompanyRepository;
import me.devMuscle.unittesting.crm.domain.event.EventDispatcher;

@RequiredArgsConstructor
public class UserController {

    private final CrmContext context;
    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;
    private final EventDispatcher eventDispatcher;

    public UserController (CrmContext context, MessageBus messageBus, IDomainLogger domainLogger) {
        this.context = context;
        this.userRepository = new UserRepository(context);
        this.companyRepository = new CompanyRepository(context);
        this.eventDispatcher = new EventDispatcher(messageBus, domainLogger);
    }

    public UserController (CrmContext context, UserRepository userRepository, CompanyRepository companyRepository, MessageBus messageBus, IDomainLogger domainLogger) {
        this.context = context;
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
        this.eventDispatcher = new EventDispatcher(messageBus, domainLogger);
    }

    public String changeEmail(int userId, String newEmail) {
        // 데이터 준비
        User user = userRepository.getUserById(userId);

        String error = user.canChangeEmail();
        if(error != null) {
            return error;
        }

        Company company = companyRepository.getCompany();

        user.changeEmail(newEmail, company);

        companyRepository.saveCompany(company);
        userRepository.saveUser(user);
        // 사용자 도메인 이벤트 전달
        eventDispatcher.dispatch(user.getDomainEvents());
        // CrmContext가 트랜잭션을 대체함
        context.saveChanges();
        return "OK";
    }
}
