package Testcases;

import Commons.BaseSetUp;
import Pages.DashboardPage;
import Pages.LoginPage;
import org.testng.annotations.Test;

public class Dashboard extends BaseSetUp {
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test
    public void testOpenPage() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM("admin@example.com", "123456");
        dashboardPage.openPage("Customers");
        sleep(2);
        dashboardPage.openPage("Sales");
        sleep(2);
        dashboardPage.openPage("Proposals");
        sleep(2);
        dashboardPage.openPage("Estimates");
        sleep(2);
        dashboardPage.openPage("Invoices");
        sleep(2);
        dashboardPage.openPage("Payments");
        sleep(2);
        dashboardPage.openPage("Credit Notes");
        sleep(2);
        dashboardPage.openPage("Subscriptions");
        sleep(2);
        dashboardPage.openPage("Expenses");
        sleep(2);
        dashboardPage.openPage("Contracts");
        sleep(2);
        dashboardPage.openPage("Projects");
        sleep(2);
        dashboardPage.openPage("Tasks");
        sleep(2);
    }

    @Test
    public void testLogout() {
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin@example.com", "123456");
        loginPage.logout();
        loginPage.verifyRedirectToLoginPage();
    }

    @Test
    public void testTotalOfTasksNotFinished() {
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin@example.com", "123456");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.verifyRedirectToDashboardPage();
    }
}
