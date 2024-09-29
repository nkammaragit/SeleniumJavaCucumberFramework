package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "username")
    WebElement edtUserName;

    @FindBy(name = "password")
    WebElement edtPassword;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnLogin;

    public void enterUsername(String username) {
        edtUserName.sendKeys(username);
    }

    public void enterPassword(String password) {
        edtPassword.sendKeys(password);
    }

    public void clickLogin() {
        btnLogin.click();
    }
}
