package org.example.ui.pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.example.ui.datas.BankAccount;

import static com.codeborne.selenide.Selenide.element;

@Getter
public class RegistrationPage {

    private SelenideElement firstNameInput = element(Selectors.byId("customer.firstName"));

    private SelenideElement lastNameInput = element(Selectors.byId("customer.lastName"));

    private SelenideElement addressInput = element(Selectors.byId("customer.address.street"));

    private SelenideElement cityInput = element(Selectors.byId("customer.address.city"));

    private SelenideElement stateInput = element(Selectors.byId("customer.address.state"));

    private SelenideElement zipCodeInput = element(Selectors.byId("customer.address.zipCode"));

    private SelenideElement phoneInput = element(Selectors.byId("customer.phoneNumber"));

    private SelenideElement ssnInput = element(Selectors.byId("customer.ssn"));

    private SelenideElement userNameInput = element(Selectors.byId("customer.username"));

    private SelenideElement passwordInput = element(Selectors.byId("customer.password"));

    private SelenideElement confirmInput = element(Selectors.byId("repeatedPassword"));

    private SelenideElement registrButton = element(Selectors.byValue("Register"));

    private SelenideElement adressErrorStreet = element(Selectors.byId("customer.address.street.errors"));

    private SelenideElement adressErrorName = element(Selectors.byId("customer.firstName.errors"));

    private SelenideElement sucsess = element(Selectors.byId("headerPanel"));

    public void registryAccount(BankAccount bankAccount){
        firstNameInput.sendKeys(bankAccount.getFirstName());
        lastNameInput.sendKeys(bankAccount.getLastName());
        addressInput.sendKeys(bankAccount.getAddress());
        cityInput.sendKeys(bankAccount.getCity());
        stateInput.sendKeys(bankAccount.getState());
        zipCodeInput.sendKeys(bankAccount.getZipCode());
        phoneInput.sendKeys(bankAccount.getPhone());
        ssnInput.sendKeys(bankAccount.getSsn());
        userNameInput.sendKeys(bankAccount.getUserName());
        passwordInput.sendKeys(bankAccount.getPassword());
        confirmInput.sendKeys(bankAccount.getConfirm());
        registrButton.click();
    }

    public static void selenideOpen(){
        Selenide.open("/parabank/register.htm");
    }
    /*public static void selenideClickRegistrationButton(){
        SelenideElement registrButton = element(Selectors.byValue("Register"));
        registrButton.click();
    }*/
}
