package luma.accounttests;

import com.dataprovider.UserLoginDataProvider;
import com.luma.Base;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * This class contains test cases for account login functionality.
 * It extends the Base class which provides common methods and variables.
 */
public class AccountLoginTests extends Base {
    /**
     * This test case verifies the login functionality with valid credentials.
     *
     * @param email    The email of the user.
     * @param password The password of the user.
     * @throws Exception If an error occurs during the test.
     */
    @Test(dataProvider = "login valid credentials", dataProviderClass = UserLoginDataProvider.class)
    public void loginWithValidCredentials(String email, String password) {
        mainPage.clickOnSignInButton();
        loginPage.fillInLoginData(email, password);
        Assert.assertTrue(mainPage.verifyUserLoggedIn());
    }
    /**
     * This test case verifies the login functionality with invalid credentials.
     *
     * @param email    The email of the user.
     * @param password The password of the user.
     * @throws Exception If an error occurs during the test.
     */
    @Test(dataProvider = "login invalid credentials", dataProviderClass = UserLoginDataProvider.class)
    public void loginWithInvalidCredentials(String email, String password) {
        mainPage.clickOnSignInButton();
        loginPage.fillInLoginData(email, password);
        Assert.assertEquals(loginPage.verifyErrorMessage(),"The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.");
        System.out.println("Test Passed");
    }
}


