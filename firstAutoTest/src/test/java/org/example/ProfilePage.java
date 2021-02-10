package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    public WebDriver driver;
    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"action-menu-toggle-1\"]/span/span[1]")
    private WebElement userNameField;


    @FindBy(xpath = "//*[@id=\"actionmenuaction-6\"]")
    private WebElement logoutBtn;

    public String getUserName() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"action-menu-toggle-1\"]/span/span[1]")));
        return userNameField.getText();
    }

    public void userMenuEntry() {
        userNameField.click();
    }

    public void userLogout() {
        logoutBtn.click();
    }
}
