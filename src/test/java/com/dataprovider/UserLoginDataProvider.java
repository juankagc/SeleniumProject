package com.dataprovider;

import org.testng.annotations.DataProvider;

public class UserLoginDataProvider {

    @DataProvider(name = "login valid credentials")
        public Object[][] validCredentials(){
        return new Object[][]{
                {"juan.gimenez+test398@test.com", "VeryStrongPassword123!"},
                {"juan.gimenez+test987@test.com", "VeryStrongPassword123!"},
                {"juan.gimenez+test5@test.com", "VeryStrongPassword123!"}
        };
    }
    @DataProvider(name = "login invalid credentials")
    public Object[][] invalidCredentials(){
        return new Object[][]{
                {"juan.gimenez+test398@test.com", "VeryStrongPassword123"},
                {"juan.gimenez+test987@test.com", "VeryStrongPassword123"},
                {"juan.gimenez+test5@test.com", "VeryStrongPassword123"}
        };
    }
}
