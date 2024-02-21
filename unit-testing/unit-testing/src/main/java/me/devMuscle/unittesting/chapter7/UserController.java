package me.devMuscle.unittesting.chapter7;

public class UserController {

    // 프로세스 외부 의존성이 직접 인스턴스화 - 테스트 작성시 문제 발생
    private final Database database = new Database();
    private final MessageBus messageBus = new MessageBus();

    public String changeEmail(int userId, String newEmail) {
        // 데이터 준비
        Object[] userData = database.getUserById(userId);
        User user = UserFactory.create(userData);

        Object[] companyData = database.getCompany();
        Company company = CompanyFactory.create(companyData);

        user.changeEmail(newEmail, company);

        // 결정에 따라 실행하기
        database.saveCompany(company);
        database.saveUser(user);
        // 도메인 이벤트 처리
        for(EmailChangedEvent emailChangedEvent : user.getEmailChangedEvents()) {
            messageBus.sendEmailChangedMessage(emailChangedEvent.getUserId(), emailChangedEvent.getNewEmail());
        }

        return "OK";
    }
}
