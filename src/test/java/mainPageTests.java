import com.utilities.RandomEmail;
import org.testng.annotations.Test;

public class mainPageTests extends BaseTest {

    @Test
    public void verifyPageLoadsSuccessfully() throws InterruptedException {
        mainPage.verifyPageLogo();
    }

    @Test
    public void createNewAccount() throws InterruptedException {
        mainPage.clickOnRegisterButton();
        signUpFormPage.createNewAccount("Juan","Gimenez","VeryStrongPassword123!", RandomEmail.randomEmail());
        accountPage.verifyAccountCreated();
    }
}
