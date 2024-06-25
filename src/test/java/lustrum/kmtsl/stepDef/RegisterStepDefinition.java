package lustrum.kmtsl.stepDef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class RegisterStepDefinition {
    WebDriver driver;
    String baseUrl = "http://localhost:3000/cia/register";

    @Given("^I am on the registration page$")
    public void i_am_on_the_registration_page() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @When("^I enter my email \"([^\"]*)\"$")
    public void i_enter_my_email(String email) {
        WebElement emailInput = driver.findElement(By.xpath("//input[@placeholder='Masukkan alamat email']"));
        emailInput.sendKeys(email);
    }

    @And("^I enter my username \"([^\"]*)\"$")
    public void i_enter_my_username(String username) {
        WebElement usernameInput = driver.findElement(By.xpath("//input[@placeholder='Masukkan username']"));
        usernameInput.sendKeys(username);
    }

    @And("^I enter my password \"([^\"]*)\"$")
    public void i_enter_my_password(String password) {
        WebElement passwordInput = driver.findElement(By.xpath("//input[@placeholder='Masukkan password']"));
        passwordInput.sendKeys(password);
    }

    @And("^I confirm my password \"([^\"]*)\"$")
    public void i_confirm_my_password(String confirmPassword) {
        WebElement confirmPasswordInput = driver.findElement(By.xpath("//input[@placeholder='Konfirmasi password']"));
        confirmPasswordInput.sendKeys(confirmPassword);
    }

    @And("^I submit the registration form$")
    public void i_submit_the_registration_form() {
        WebElement registerButton = driver.findElement(By.xpath("//button[text()='Register']"));
        registerButton.click();
    }

    @Then("^I should see a success message \"([^\"]*)\"$")
    public void i_should_see_a_success_message(String successMessage) {
        WebElement successElement = driver.findElement(By.xpath("//*[contains(text(), '" + successMessage + "')]"));
        Assert.assertTrue(successElement.isDisplayed());
    }

    @Then("^I should see an error message \"([^\"]*)\"$")
    public void i_should_see_an_error_message(String errorMessage) {
        WebElement errorElement = driver.findElement(By.xpath("//*[contains(text(), '" + errorMessage + "')]"));
        Assert.assertTrue(errorElement.isDisplayed());
    }

    @And("^Close the browser$")
    public void close_the_browser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
