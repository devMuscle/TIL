package me.devMuscle.unittesting.crm.domain.user;

import lombok.RequiredArgsConstructor;
import me.devMuscle.unittesting.crm.*;
import me.devMuscle.unittesting.crm.bus.MessageBus;
import me.devMuscle.unittesting.crm.domain.company.Company;
import me.devMuscle.unittesting.crm.domain.company.CompanyFactory;
import me.devMuscle.unittesting.crm.domain.event.EventDispatcher;

@RequiredArgsConstructor
public class UserController {

    // 프로세스 외부 의존성이 직접 인스턴스화 - 테스트 작성시 문제 발생
    private final Database database;
    private final EventDispatcher eventDispatcher;

    public UserController (Database database, MessageBus messageBus, IDomainLogger domainLogger) {
        this.database = database;
        this.eventDispatcher = new EventDispatcher(messageBus, domainLogger);
    }

    public String changeEmail(int userId, String newEmail) {
        // 데이터 준비
        Object[] userData = database.getUserById(userId);
        User user = UserFactory.create(userData);

        String error = user.canChangeEmail();
        if(error != null) {
            return error;
        }

        Object[] companyData = database.getCompany();
        Company company = CompanyFactory.create(companyData);

        user.changeEmail(newEmail, company);

        // 결정에 따라 실행하기
        database.saveCompany(company);
        database.saveUser(user);
        // 사용자 도메인 이벤트 전달
        eventDispatcher.dispatch(user.getDomainEvents());

        return "OK";
    }
}
