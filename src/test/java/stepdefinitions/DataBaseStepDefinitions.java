package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.Driver;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseStepDefinitions {
    @Given("connect to database")
    public void connectToDatabase() throws SQLException {
        DriverManager.getConnection("","","");
    }

    @Then("read and validate")
    public void readAndValidate() {
    }
}
