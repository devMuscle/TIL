package me.devMuscle.unittesting.chapter7;

public class UserController {

    // 프로세스 외부 의존성이 직접 인스턴스화 - 테스트 작성시 문제 발생
    private final Database database = new Database();
    private final MessageBus messageBus = new MessageBus();

    public void changeEmail(int userId, String newEmail) {
        Object[] data = database.getUserById(userId);
        String email = (String)data[1];
        UserType type = (UserType)data[2];
        //인스턴스화 하는 복집한 로직이므로 애플리케이션 서비스에 속하면 안됨, 오케스트레이션만 수행해야 함
        User user = new User(userId, email, type);

        Object[] companyData = database.getCompany();
        String companyDomainName = (String)companyData[0];
        int numberOfEmployees = (int)companyData[1];

        //회사 직원 수는 특정 사용자와 관련이 없다 - 책임은 다른 곳에 있어야 함
        int newNumberOfEmployees = user.changeEmail(newEmail, companyDomainName, numberOfEmployees);

        //새로운 이메일 여부에 관계 없이 무조건 데이터를 수정해서 저장하고, 메시지 버스에 알림을 보냄
        database.saveCompany(newNumberOfEmployees);
        database.saveUser(user);
        messageBus.sendEmailChangedMessage(userId, newEmail);
    }
}
