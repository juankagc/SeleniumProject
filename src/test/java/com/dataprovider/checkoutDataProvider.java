package com.dataprovider;

import com.luma.utilities.RandomEmail;
import org.testng.annotations.DataProvider;

public class checkoutDataProvider {

    @DataProvider(name = "checkout valid data")
    public Object[][] validData() {
        String email = RandomEmail.randomEmail();
        return new Object[][]{
                {"Juan", "Gimenez" ,email, "Okt", "Fake Address1234", "New York", "Alabama", "US", "94404", "123456789"},
                {"Roberto", "Bolaños", email, "Okt2", "Fake Address321","New Orleans", "NO", "US", "94404", "123456789"},
        };
    }
}
