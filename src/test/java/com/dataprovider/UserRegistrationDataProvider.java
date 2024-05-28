package com.dataprovider;

import com.luma.utilities.RandomEmail;
import org.testng.annotations.DataProvider;

import static com.luma.utilities.RandomEmail.randomEmail;

public class UserRegistrationDataProvider {

    @DataProvider(name = "valid data")
    public Object[][] userRegValidData() {
        return new Object[][]{
                {"Juan", "Gimenez", randomEmail(), "VeryStrongPassword123!"},
                {"Roberto", "Bolaños", randomEmail(), "VeryStrongPassword123!"},
                {"Erick", "Roro", randomEmail(), "VeryStrongPassword123!"}
        };
    }
    @DataProvider(name = "missing first name")
    public Object[][] userRegMissingFirstName() {
        return new Object[][]{
                {"","Gimenez",randomEmail(), "VeryStrongPassword123!"},
                {"","Bolaños",randomEmail(), "VeryStrongPassword123!"},
                {"", "Roro", randomEmail(), "VeryStrong123!"}
        };
    }
    @DataProvider(name = "missing last name")
    public Object[][] userRegMissingLastName() {
        return new Object[][]{
                {"Juan","",randomEmail(), "VeryStrongPassword123!"},
                {"Roberto","",randomEmail(), "VeryStrongPassword123!"},
                {"Erick", "", randomEmail(), "VeryStrong123!"}
        };
    }
    @DataProvider(name = "invalid email")
    public Object[][] userRegInvalidEmail() {
        return new Object[][]{
                {"Juan","Gimenez","null", "VeryStrongPassword123!"},
                {"Roberto","Bolaños","null", "VeryStrongPassword123!"},
                {"Erick","Roro", "null", "VeryStrong123!"}
        };
    }
    @DataProvider(name = "weak password password")
    public Object[][] userRegWeakPassword() {
        return new Object[][]{
                {"Juan", "Gimenez", randomEmail(), "Weak"},
                {"Roberto", "Bolaños", randomEmail(), "Weak1"},
                {"Erick", "Roro", randomEmail(), "12345"}
        };
    }
}
