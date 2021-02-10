package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }


    @FindBy(xpath = "//*[@id=\"login_username\"]")
    private WebElement loginField;

    @FindBy(xpath = "//*[@id=\"login_password\"]")
    private WebElement passwrdField;

    @FindBy(xpath = "//*[@id=\"login\"]/div[4]/input")
    private WebElement passBtn;

    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    public void inputPassword(String password) {
        passwrdField.sendKeys(password);
    }

    public void clickPassBtn() {
        passBtn.click();
    }
}
