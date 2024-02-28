package me.devMuscle.unittesting.crm;

import me.devMuscle.unittesting.crm.bus.BusSpy;
import me.devMuscle.unittesting.crm.bus.MessageBus;
import me.devMuscle.unittesting.crm.domain.company.Company;
import me.devMuscle.unittesting.crm.domain.company.CompanyRepository;
import me.devMuscle.unittesting.crm.domain.event.EmailChangedEvent;
import me.devMuscle.unittesting.crm.domain.user.User;
import me.devMuscle.unittesting.crm.domain.user.UserController;
import me.devMuscle.unittesting.crm.domain.user.UserRepository;
import me.devMuscle.unittesting.crm.domain.user.UserType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserTest {

    @Test
    public void changing_email_from_non_corporate_to_corporate() {
        Company company = new Company("mycorp.com", 1);
        User sut = new User(1, "user@gmail.com", UserType.CUSTOMER, false);

        sut.changeEmail("new@mycorp.com", company);

        assertEquals(2, company.getNumberOfEmployees());
        assertEquals("new@mycorp.com", sut.getEmail());
        assertEquals(UserType.EMPLOYEE, sut.getType());
    }

    @ParameterizedTest
    @CsvSource({"mycorp.com, email@mycorp.com, true", "mycorp.com, email@gamil.com, false"})
    public void differentiates_a_corporate_email_from_non_corporate (String domain, String email, boolean expectedResult) {

        Company sut = new Company(domain, 0);

        boolean isEmailCorporate = sut.isEmailCorporate(email);

        assertEquals(expectedResult, isEmailCorporate);
    }

    @Test
    public void changing_email_from_corporate_to_non_corporate_unit_test() {
        Company company = new Company("mycorp.com", 1);
        User sut = new User(1, "user@mycorp.com", UserType.EMPLOYEE, false);

        sut.changeEmail("new@gmail.com", company);

        Assertions.assertThat(company.getNumberOfEmployees()).isEqualTo(0);
        Assertions.assertThat(sut.getEmail()).isEqualTo("new@gmail.com");
        Assertions.assertThat(sut.getType()).isEqualTo(UserType.CUSTOMER);
        Assertions.assertThat(sut.getDomainEvents()).contains(new EmailChangedEvent(1, "new@gmail.com"));
    }

    @Test
    public void changing_email_from_corporate_to_non_corporate_integration_test() {
        // 컨텍스트 생성
        CrmContext context = new CrmContext();
        //준비
        UserRepository userRepository = new UserRepository(context);
        CompanyRepository companyRepository = new CompanyRepository(context);
        //데이터베이스에 사용자와 회사 생성
        User user = new User(0, "user@mycorp.com", UserType.EMPLOYEE, false);
        userRepository.saveUser(user);
        Company company = new Company("mycorp.com", 1);
        companyRepository.saveCompany(company);
        context.saveChanges();

        //메시지 버스 목 설정
        BusSpy busSpy = new BusSpy();
        MessageBus messageBus = new MessageBus(busSpy);
        IDomainLogger loggerMock = mock(IDomainLogger.class);
        UserController sut = new UserController(context, userRepository, companyRepository, messageBus, loggerMock);

        //실행
        String result = sut.changeEmail(user.getUserId(),"new@gmail.com");

        //검증
        assertEquals("OK", result);

        //사용자 상태 검증
        User userFromDb = userRepository.getUserById(user.getUserId());
        assertEquals("new@gmail.com", userFromDb.getEmail());
        assertEquals(UserType.CUSTOMER, userFromDb.getType());

        //회사 상태 검증
        Company companyFromDb = companyRepository.getCompany();
        assertEquals(0, companyFromDb.getNumberOfEmployees());

        //목 상호 작용 확인
        busSpy.shouldSendNumberOfMessages(1).withEmailChangedMessage(user.getUserId(), "new@gmail.com");
        verify(loggerMock, times(1)).userTypeHasChanged(user.getUserId(), UserType.EMPLOYEE, UserType.CUSTOMER);
    }
}
