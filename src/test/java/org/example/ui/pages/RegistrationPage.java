package org.example.ui.pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.element;

public class RegistrationPage {
    public static void selenideOpen(){
        Selenide.open("https://parabank.parasoft.com/parabank/register.htm");
    }
    public static void selenideClickRegistrationButton(){
        SelenideElement registrButton = element(Selectors.byValue("Register"));
        registrButton.click();
    }
}
