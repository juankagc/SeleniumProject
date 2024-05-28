package com.dataprovider;

import com.luma.utilities.RandomEmail;
import org.testng.annotations.DataProvider;

import static com.luma.utilities.RandomEmail.randomEmail;

public class UserAddressDataProvider {

    @DataProvider(name = "Valid Data")
    public Object[][] checkoutValidData() {
        return new Object[][]{
                {"Juan", "Gimenez" ,randomEmail(), "Okt", "Fake Address1234", "New York", "Alabama", "US", "94404", "123456789"},
                {"Roberto", "Bolaños", randomEmail(), "Okt2", "Fake Address321","New Orleans", "NO", "US", "94402", "123456889"},
                {"Juan", "Roberto" ,randomEmail(), "Okt", "Fake Address1234", "California", "Alabama", "US", "94403", "123456989"}
        };
    }
    @DataProvider(name="Missing Zip Code")
    public Object[][] missingFields() {
        return new Object[][]{
                {"Juan", "Gimenez" ,randomEmail(), "Okt2", "Fake Address1234", "New York", "Alabama", "US", "94404", "123456789"},
                {"Roberto", "Bolaños", randomEmail(), "Okt2", "Fake Address1234","New Orleans", "NO", "US", "94402", "123456889"},
                {"Juan", "Roberto" ,randomEmail(), "Okt", "Fake Address1234", "California", "Alabama", "US", "94402", "123456989"}
        };
    }
}
