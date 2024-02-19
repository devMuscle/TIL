package me.devMuscle.unittesting.chapter7;

public class User {

    public int userId;
    public String email;
    public UserType type;

    public void changeEmail(int userId, String newEmail) { //명시적 의존성 - userId, newEmail
        Object[] data = Database.getInstance().getUserById(userId);
        this.userId = userId;
        email = (String)data[1];
        type = (UserType)data[2];

        if(email == newEmail) {
            return;
        }

        Object[] companyData = Database.getInstance().getCompany();
        String companyDomainName = (String)companyData[0];
        int numberOfEmployees = (int)companyData[1];

        String emailDomain = newEmail.split("@")[1];
        boolean isEmailCorporate = (emailDomain.equals(companyDomainName));
        UserType newType = isEmailCorporate ? UserType.EMPLOYEE : UserType.CUSTOMER;

        if(type != newType) {
            int delta = newType == UserType.EMPLOYEE ? 1 : -1;
            int newNumber = numberOfEmployees + delta;
            Database.getInstance().saveCompany(newNumber);
        }

        email = newEmail;
        type = newType;

        // 암시적 의존성,프로세스 외부 협력자 - Database, MessageBus
        // 도메인 클래스가 데이터베이스를 검색하고 다시 저장하는 방식 - 활성화 레코드 패턴
        // 비즈니스 로직과 프로세스 외부 의존성과의 통신 사이에 분리가 없어 장기적으로 문제
        Database.getInstance().saveUser(this);
        MessageBus.getInstance().sendEmailChangedMessage(userId, newEmail);
    }
}
