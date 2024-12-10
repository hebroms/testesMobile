package testes_mobile.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import java.time.Duration;

public class RegisterPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    private final By cpfField = By.id("net.nuvem.mobile.carguero.release:id/cpfEditText");
    private final By agreeButton = By.id("net.nuvem.mobile.carguero.release:id/btnAwareInserunce");
    private final By phoneField = By.id("net.nuvem.mobile.carguero.release:id/phoneEditText");
    private final By nextButton = By.id("net.nuvem.mobile.carguero.release:id/nextButton");
    private final By codeSMSField = By.id("net.nuvem.mobile.carguero.release:id/smsEditText");
    private final By validCodeSMSButton = By.id("net.nuvem.mobile.carguero.release:id/verifyButton");
    private final By messageErrorAlert = By.id("net.nuvem.mobile.carguero.release:id/textinput_error");

    public By getMessageErrorAlertLocator() {
        return messageErrorAlert;
    }

    public void submitAgree() {
        wait.until(ExpectedConditions.elementToBeClickable(agreeButton));
        driver.findElement(agreeButton).click();
    }

    public void submitCpf(String cpf) {
        wait.until(ExpectedConditions.elementToBeClickable(cpfField));
        driver.findElement(cpfField).sendKeys(cpf);
        driver.findElement(nextButton).click();
    }

    public void submitPhone(String phone) {
        wait.until(ExpectedConditions.elementToBeClickable(phoneField));
        driver.findElement(phoneField).sendKeys(phone);
        driver.findElement(nextButton).click();
    }

    public void submitCode(String code) {
        wait.until(ExpectedConditions.elementToBeClickable(codeSMSField));
        driver.findElement(codeSMSField).sendKeys(code);
        driver.findElement(validCodeSMSButton).click();
    }

    public boolean validAlert(By element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return driver.findElement(element).isDisplayed();
    }

    public String validText(By element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return driver.findElement(element).getText();
    }

}
