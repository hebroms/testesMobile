package testes_mobile.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import testes_mobile.config.BaseTest;
import testes_mobile.pages.HomePage;
import testes_mobile.pages.RegisterPage;
import testes_mobile.utils.ConfigUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Mobile Tests")
@Feature("Register Tests")
public class MobileTest extends BaseTest {

    @Test
    @Description("Test to try register but invalid sms")
    @Severity(SeverityLevel.NORMAL)
    public void testSendSMSInvalid(){

        HomePage homePage = new HomePage(driver);
        homePage.submitRegister();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.submitAgree();
        registerPage.submitCpf(ConfigUtil.get("cpf"));
        registerPage.submitPhone(ConfigUtil.get("phone"));
        registerPage.submitCode(ConfigUtil.get("code"));
        assertTrue(registerPage.validAlert(registerPage.getMessageErrorAlertLocator()));
        assertEquals(registerPage.validText(registerPage.getMessageErrorAlertLocator()), ConfigUtil.get("messageSMSInvalid"));
    }
}
