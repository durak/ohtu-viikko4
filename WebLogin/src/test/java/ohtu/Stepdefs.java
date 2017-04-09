package ohtu;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Stepdefs {

    WebDriver driver = new ChromeDriver();
    String baseUrl = "http://localhost:4567";

    @Given("^user with username \"([^\"]*)\" with password \"([^\"]*)\" is successfully created$")
    public void user_with_username_with_password_is_successfully_created(String username, String password) throws Throwable {
        new_user_is_selected();
        correct_new_username_and_correct_password_and_correct_password_confirmation_are_given(username, password, password);

    }

    @Given("^user with username \"([^\"]*)\" and password \"([^\"]*)\" is unsuccessfully created$")
    public void user_with_username_and_password_is_unsuccessfully_created(String username, String password) throws Throwable {
        new_user_is_selected();
        too_short_username_and_correct_password_and_correct_password_confirmation_are_given(username, password, password);
    }

    @Given("^login is selected$")
    public void login_selected() throws Throwable {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();
    }

    @Given("^new user is selected$")
    public void new_user_is_selected() throws Throwable {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
    }

    @When("^username \"([^\"]*)\" and password \"([^\"]*)\" are given$")
    public void username_and_password_are_given(String username, String password) throws Throwable {
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();
    }

    @Then("^system will respond \"([^\"]*)\"$")
    public void system_will_respond(String pageContent) throws Throwable {
        assertTrue(driver.getPageSource().contains(pageContent));
    }

    @When("^correct username \"([^\"]*)\" and password \"([^\"]*)\" are given$")
    public void username_correct_and_password_are_given(String username, String password) throws Throwable {
        logInWith(username, password);
    }

    @When("^correct username \"([^\"]*)\" and incorrect password \"([^\"]*)\" are given$")
    public void username_and_incorrect_password_are_given(String username, String password) throws Throwable {
        logInWith(username, password);
    }

    @When("^nonexistent username \"([^\"]*)\" and password \"([^\"]*)\" are given$")
    public void nonexistent_username_and_password_are_given(String username, String password) throws Throwable {
        logInWith(username, password);

    }

    @Then("^user is logged in$")
    public void user_is_logged_in() throws Throwable {
        pageHasContent("Ohtu Application main page");
    }

    @Then("^user is not logged in and error message is given$")
    public void user_is_not_logged_in_and_error_message_is_given() throws Throwable {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }

    @When("^correct new username \"([^\"]*)\" and correct password \"([^\"]*)\" and correct password confirmation \"([^\"]*)\" are given$")
    public void correct_new_username_and_correct_password_and_correct_password_confirmation_are_given(String username, String password, String passwordConfirmation) throws Throwable {
        signUpWith(username, password, passwordConfirmation);
    }

    @When("^too short username \"([^\"]*)\" and correct password \"([^\"]*)\" and correct password confirmation \"([^\"]*)\" are given$")
    public void too_short_username_and_correct_password_and_correct_password_confirmation_are_given(String username, String password, String passwordConfirmation) throws Throwable {
        signUpWith(username, password, passwordConfirmation);
    }

    @When("^correct new username \"([^\"]*)\" and too short password \"([^\"]*)\" and too short password confirmation \"([^\"]*)\" are given$")
    public void correct_new_username_and_too_short_password_and_too_short_password_confirmation_are_given(String username, String password, String passwordConfirmation) throws Throwable {
        signUpWith(username, password, passwordConfirmation);
    }

    @When("^correct new username \"([^\"]*)\" and letter-only password \"([^\"]*)\" and letter-only password confirmation \"([^\"]*)\" are given$")
    public void correct_new_username_and_letter_only_password_and_letter_only_password_confirmation_are_given(String username, String password, String passwordConfirmation) throws Throwable {
        signUpWith(username, password, passwordConfirmation);
    }

    @When("^already taken username \"([^\"]*)\" and valid password \"([^\"]*)\" and valid password confirmation \"([^\"]*)\" are given$")
    public void already_taken_username_and_valid_password_and_valid_password_confirmation_are_given(String username, String password, String passwordConfirmation) throws Throwable {
        signUpWith(username, password, passwordConfirmation);
    }

    @When("^correct new username \"([^\"]*)\" and valid password \"([^\"]*)\" and not matching password confirmation \"([^\"]*)\" are given$")
    public void correct_new_username_and_valid_password_and_not_matching_password_confirmation_are_given(String username, String password, String passwordConfirmation) throws Throwable {
        signUpWith(username, password, passwordConfirmation);

    }

    @Then("^user is created and forwarded to wellcome$")
    public void user_is_created_and_forwarded_to_wellcome() throws Throwable {
        pageHasContent("Welcome to Ohtu Application!");
    }

    @Then("^user is not created and error \"([^\"]*)\" is reported$")
    public void user_is_not_created_and_error_is_reported(String arg1) throws Throwable {
        pageHasContent(arg1);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    /* helper methods */
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }

    private void logInWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Give your credentials to login"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();
    }

    private void signUpWith(String username, String password, String passwordConfirmation) {
        assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(passwordConfirmation);
        element = driver.findElement(By.name("signup"));
        element.submit();
    }
}
