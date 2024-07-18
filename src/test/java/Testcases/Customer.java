package Testcases;

import Commons.BaseSetUp;
import Pages.LoginPage;
import org.testng.annotations.Test;

public class Customer extends BaseSetUp {
    LoginPage loginPage;

    @Test
    public void testAddNewCustomer() {
        String CUSTOMER_NAME = "Đồ Án Tốt Nghiệp - Kiều Ngọc Sơn - 2051067583";

        loginPage = new LoginPage(driver);

        //Fluent design pattern
        loginPage.loginCRM("admin@example.com", "123456")
                .openCustomerPage()
                .verifyRedirectToCustomerPage()
                .addNewCustomer(CUSTOMER_NAME)
                .verifyAddNewCustomer(CUSTOMER_NAME);
    }

}