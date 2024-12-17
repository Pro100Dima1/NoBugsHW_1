package org.example.ui.test;

import com.codeborne.selenide.*;
import org.example.ui.datas.BankAccount;
import org.example.ui.pages.RegistrationPage;
import org.example.ui.utils.RandomData;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.element;

public class ParaBankUiTest {
    @BeforeAll
    public static void setUpUiTest(){
        Configuration.baseUrl = "https://parabank.parasoft.com";
        //Configuration.browser = "firefox";
        //Configuration.timeout = 10;
    }
    @Test
    @DisplayName("Проверка, что нельзя зарегестрироваться только с именем и фамилией")
    public void userCanNotCreateAccountWithNameAndSurnameOnly(){
        RegistrationPage.selenideOpen();

        BankAccount bankAccount = BankAccount.builder()
                .firstName(RandomData.randomString()).lastName(RandomData.randomString())
                .address("").city("")
                .state("").zipCode("").phone("").ssn("")
                .userName("").password("").confirm("")
                .build();

        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.registryAccount(bankAccount);

        registrationPage.getAdressErrorStreet().shouldHave(Condition.exactText("Address is required."));
    }
    @Test
    @DisplayName("Проверка, что нельзя зарегестрироваться без имени и фамилии")
    public void userCanNotCreateAccountWithoutNameAndSurname(){
        RegistrationPage.selenideOpen();

        BankAccount bankAccount = BankAccount.builder()
                .firstName("").lastName("")
                .address("Dom 10").city("Moscow")
                .state("Nope").zipCode("001-120-000").phone("88005553535").ssn("9344541")
                .userName("Pro100Dima").password("Qwerty").confirm("Qwerty")
                .build();

        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.registryAccount(bankAccount);

        registrationPage.getAdressErrorName().shouldHave(Condition.exactText("First name is required."));
    }
    @Test
    @DisplayName("Проверка успешной регистрации")
    public void userCreateAccountSucsess(){
        RegistrationPage.selenideOpen();

        BankAccount bankAccount = BankAccount.builder()
                .firstName(RandomData.randomString()).lastName(RandomData.randomString()).address("Dom 10").city("Moscow")
                .state("Nope").zipCode("001-120-000").phone("88005553535").ssn("9344541")
                .userName("Pro100Dima").password("Qwerty").confirm("Qwerty")
                .build();

        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.registryAccount(bankAccount);

        registrationPage.getSucsess().isDisplayed();
    }

}
