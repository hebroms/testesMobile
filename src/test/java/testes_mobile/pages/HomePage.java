package testes_mobile.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    private final By registerButton = By.id("net.nuvem.mobile.carguero.release:id/btnRegister");
    private final By closeWebViewButton = By.xpath("//android.widget.Image");
    private final By permissionNotification = By.id("com.android.permissioncontroller:id/permission_allow_button");

    public void agreePermissionNotification() {
        // Aguarde o botão estar clicável antes de interagir
        wait.until(ExpectedConditions.elementToBeClickable(permissionNotification));
        driver.findElement(permissionNotification).click();
    }

    public void closeWebView() {
        // Aguarde o botão estar clicável antes de interagir
        wait.until(ExpectedConditions.elementToBeClickable(closeWebViewButton));
        driver.findElement(closeWebViewButton).click();
    }

    public void submitRegister() {
        // Aguarde o botão estar clicável antes de interagir
        wait.until(ExpectedConditions.elementToBeClickable(registerButton));
        driver.findElement(registerButton).click();
    }
}
