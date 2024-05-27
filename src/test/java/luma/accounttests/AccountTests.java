package luma.accounttests;

import com.luma.Base;
import com.luma.utilities.RandomEmail;
import org.testng.annotations.Test;

public class AccountTests extends Base {

    @Test
    public void verifyPageLoadsSuccessfully(){
        mainPage.verifyPageLogo();
    }

    @Test
    public void createNewAccount(){
        mainPage.clickOnRegisterButton();
        signUpFormPage.createNewAccount("Juan","Gimenez","VeryStrongPassword123!", RandomEmail.randomEmail());
        accountPage.verifyAccountCreated();
    }
    @Test
    public void goToYogaShop(){
        mainPage.goToYogaShop();
    }
}
