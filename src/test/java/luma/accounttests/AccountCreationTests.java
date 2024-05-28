package luma.accounttests;

import com.dataprovider.UserRegistrationDataProvider;
import com.luma.Base;
import com.luma.utilities.RandomEmail;
import org.testng.Assert;
import org.testng.annotations.Test;
/**
 * This class contains test cases related to account functionality.
 * It extends the Base class which provides common methods and variables.
 */
public class AccountCreationTests extends Base {

    /**
     * This test verifies if the main page loads successfully by checking the presence of the page logo.
     */
    @Test
    public void verifyPageLoadsSuccessfully(){
        mainPage.verifyPageLogo();
    }
    /**
     * This test verifies the successful creation of a new account with valid data.
     *
     * @param firstName The first name of the user.
     * @param lastName The last name of the user.
     * @param email The email of the user.
     * @param password The password of the user.
     *
     */
    @Test(dataProvider = "valid data", dataProviderClass = UserRegistrationDataProvider.class)
    public void verifyAccountCreationValidData(String firstName, String lastName, String email, String password) throws InterruptedException {
        mainPage.clickOnRegisterButton();
        signUpFormPage.createNewAccount(firstName, lastName, email, password);
        Thread.sleep(10000);
        accountPage.verifyAccountCreated();
    }
    /**
     * This test verifies the account creation with missing first name.
     * It clicks on the register button, creates a new account with missing first name,
     * and verifies if the generic error message for missing fields is displayed.
     *
     * @param firstName The first name of the user. It is expected to be null or empty.
     * @param lastName The last name of the user. It is expected to be valid.
     * @param email The email of the user. It is expected to be valid.
     * @param password The password of the user. It is expected to be valid.
     */
    @Test(dataProvider = "missing first name", dataProviderClass = UserRegistrationDataProvider.class)
    public void verifyAccountCreationInvalidFirstName(String firstName, String lastName, String email, String password){
        mainPage.clickOnRegisterButton();
        signUpFormPage.createNewAccount(firstName, lastName, email, password);
        Assert.assertTrue(signUpFormPage.lblGenericErrorMissingFieldsIsDisplayed());
    }
    /**
     * This test verifies the account creation with missing last name.
     * It clicks on the register button, creates a new account with missing last name,
     * and verifies if the generic error message for missing fields is displayed.
     *
     * @param firstName The first name of the user. It is expected to be valid.
     * @param lastName The last name of the user. It is expected to be null or empty.
     * @param email The email of the user. It is expected to be valid.
     * @param password The password of the user. It is expected to be valid.
     */
    @Test(dataProvider = "missing last name", dataProviderClass = UserRegistrationDataProvider.class)
    public void verifyAccountCreationInvalidLastName(String firstName, String lastName, String email, String password){
        mainPage.clickOnRegisterButton();
        signUpFormPage.createNewAccount(firstName, lastName, email, password);
        Assert.assertTrue(signUpFormPage.lblGenericErrorMissingFieldsIsDisplayed());
    }
    /**
     * This test verifies the account creation with an invalid email.
     * It clicks on the register button, creates a new account with an invalid email,
     * and verifies if the generic error message for missing fields is displayed.
     *
     * @param firstName The first name of the user. It is expected to be valid.
     * @param lastName The last name of the user. It is expected to be valid.
     * @param email The email of the user. It is expected to be invalid.
     * @param password The password of the user. It is expected to be valid.
     */
    @Test(dataProvider = "invalid email", dataProviderClass = UserRegistrationDataProvider.class)
    public void verifyAccountCreationInvalidEmail(String firstName, String lastName, String email, String password){
        mainPage.clickOnRegisterButton();
        signUpFormPage.createNewAccount(firstName, lastName, email, password);
        Assert.assertTrue(signUpFormPage.lblGenericErrorMissingFieldsIsDisplayed());
    }
    /**
     * This test verifies the account creation with a weak password.
     * It clicks on the register button, creates a new account with a weak password,
     * and verifies if the error message for weak password is displayed.
     *
     * @param firstName The first name of the user. It is expected to be valid.
     * @param lastName The last name of the user. It is expected to be valid.
     * @param email The email of the user. It is expected to be valid.
     * @param password The password of the user. It is expected to be weak.
     *
     * @return void
     */
    @Test(dataProvider = "weak password password", dataProviderClass = UserRegistrationDataProvider.class)
    public void verifyAccountCreationWeakPassword(String firstName, String lastName, String email, String password){
        mainPage.clickOnRegisterButton();
        signUpFormPage.createNewAccount(firstName, lastName, email, password);
        Assert.assertTrue(signUpFormPage.lblErrorPasswordFieldIsDisplayed());
    }
}
