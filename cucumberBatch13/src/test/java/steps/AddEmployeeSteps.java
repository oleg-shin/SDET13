package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonMethods;

public class AddEmployeeSteps extends CommonMethods {
    @When("user clicks on add employee option")
    public void user_clicks_on_add_employee_option() {
        click(dash.addEmployeeOption);
    }

    @When("user enters firstName, middleName and lastName")
    public void user_enters_first_name_middle_name_and_last_name() {
        sendText(addEmployee.firstName, "Aladin");
        sendText(addEmployee.middleName, "Abu");
        sendText(addEmployee.lastName, "Jasmin");
    }

    @When("user click on save button")
    public void user_click_on_save_button() {
        click(addEmployee.saveButton);
    }

    @Then("employee added successfully")
    public void employee_added_successfully() {
        // homework verify added employee
        System.out.println("Employee is added");
    }

    @When("user enters {string}, {string}, {string}")
    public void user_enters(String firstName, String middleName, String lastName) {
        sendText(addEmployee.firstName, firstName);
        sendText(addEmployee.middleName, middleName);
        sendText(addEmployee.lastName, lastName);
    }

    @When("user enters {string}, {string} and {string}")
    public void user_enters_and(String fn, String mn, String ln) {
        sendText(addEmployee.firstName, fn);
        sendText(addEmployee.middleName, mn);
        sendText(addEmployee.lastName, ln);
    }
}
