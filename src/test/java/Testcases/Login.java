package Testcases;

import Commons.BaseSetUp;
import Pages.CommonPage;
import Pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login extends BaseSetUp {
    CommonPage commonPage;
    LoginPage loginPage;

    @BeforeMethod
    public void setupPage(){
        commonPage = new CommonPage(driver);
    }

    @Test(priority = 1)
    public void testLoginFailWithEmailInvalid(){
        loginPage = new LoginPage(driver);

        loginPage.loginCRM("admin@example.com", "123098");
        loginPage.verifyLoginFail("Invalid email or password");
    }

    @Test(priority = 2)
    public void testLoginFailWithEmailNull(){
        loginPage = new LoginPage(driver);

        loginPage.loginCRM("", "123456");
        loginPage.verifyLoginFail("The Email Address field is required.");
    }

    @Test(priority = 3)
    public void testLoginFailWithPasswordInvalid()
    {
        loginPage = new LoginPage(driver);

        loginPage.loginCRM("admin@example.com", "123");
        loginPage.verifyLoginFail("Invalid email or password");
    }
    @Test(priority = 4)
    public void testLoginFailWithPasswordNull()
    {
        loginPage = new LoginPage(driver);

        loginPage.loginCRM("admin@example.com", "");
        loginPage.verifyLoginFail("The Password field is required.");
    }

    @Test(priority = 5)
    public void testLoginSuccess()
    {
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();
        loginPage.logout();
        loginPage.verifyRedirectToLoginPage(); //Chuyển hướng trở lại trang đăng nhập. 
    }

}