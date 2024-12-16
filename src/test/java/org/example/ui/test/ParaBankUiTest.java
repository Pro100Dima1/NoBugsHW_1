package org.example.ui.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.example.ui.pages.RegistrationPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.element;

public class ParaBankUiTest {
    @Test
    @DisplayName("Проверка, что нельзя зарегестрироваться только с именем и фамилией")
    public void userCanNotCreateAccountWithNameAndSurnameOnly(){
        RegistrationPage.selenideOpen();

        SelenideElement firstName = element(Selectors.byId("customer.firstName"));
        firstName.sendKeys("Dmitry");

        SelenideElement lastName = element(Selectors.byId("customer.lastName"));
        lastName.sendKeys("Petrov");

        RegistrationPage.selenideClickRegistrationButton();

        SelenideElement adressError = element(Selectors.byId("customer.address.street.errors"));
        adressError.shouldHave(Condition.exactText("Address is required."));
    }
    @Test
    @DisplayName("Проверка, что нельзя зарегестрироваться без имени и фамилии")
    public void userCanNotCreateAccountWithoutNameAndSurname(){
        RegistrationPage.selenideOpen();

        SelenideElement address = element(Selectors.byId("customer.address.street"));
        address.sendKeys("Dom 8");

        SelenideElement city = element(Selectors.byId("customer.address.city"));
        city.sendKeys("Moscow");

        SelenideElement state = element(Selectors.byId("customer.address.state"));
        state.sendKeys("Yeaa");

        SelenideElement zipCode = element(Selectors.byId("customer.address.zipCode"));
        zipCode.sendKeys("234");

        SelenideElement phone = element(Selectors.byId("customer.phoneNumber"));
        phone.sendKeys("88005553535");

        SelenideElement ssn = element(Selectors.byId("customer.ssn"));
        ssn.sendKeys("Dmitry");

        SelenideElement userName = element(Selectors.byId("customer.username"));
        userName.sendKeys("Pro100Dima");

        SelenideElement password = element(Selectors.byId("customer.password"));
        password.sendKeys("Dmitry");

        SelenideElement confirm = element(Selectors.byId("repeatedPassword"));
        confirm.sendKeys("Dmitry");

        RegistrationPage.selenideClickRegistrationButton();

        SelenideElement adressError = element(Selectors.byId("customer.firstName.errors"));
        adressError.shouldHave(Condition.exactText("First name is required."));
    }
    @Test
    @DisplayName("Проверка успешной регистрации")
    public void userCreateAccountSucsess(){
        RegistrationPage.selenideOpen();

        SelenideElement firstName = element(Selectors.byId("customer.firstName"));
        firstName.sendKeys("Dmitry");

        SelenideElement lastName = element(Selectors.byId("customer.lastName"));
        lastName.sendKeys("Petrov");

        SelenideElement address = element(Selectors.byId("customer.address.street"));
        address.sendKeys("Dom 8");

        SelenideElement city = element(Selectors.byId("customer.address.city"));
        city.sendKeys("Moscow");

        SelenideElement state = element(Selectors.byId("customer.address.state"));
        state.sendKeys("Moscow");

        SelenideElement zipCode = element(Selectors.byId("customer.address.zipCode"));
        zipCode.sendKeys("934");

        SelenideElement phone = element(Selectors.byId("customer.phoneNumber"));
        phone.sendKeys("88005553535");

        SelenideElement ssn = element(Selectors.byId("customer.ssn"));
        ssn.sendKeys("000-00-0000");

        SelenideElement userName = element(Selectors.byId("customer.username"));
        userName.sendKeys("Pro100Dimaaa");

        SelenideElement password = element(Selectors.byId("customer.password"));
        password.sendKeys("Pro100Dima!");

        SelenideElement confirm = element(Selectors.byId("repeatedPassword"));
        confirm.sendKeys("Pro100Dima!");

        RegistrationPage.selenideClickRegistrationButton();

        SelenideElement sucsess = element(Selectors.byId("headerPanel"));
        sucsess.isDisplayed();
    }

}
