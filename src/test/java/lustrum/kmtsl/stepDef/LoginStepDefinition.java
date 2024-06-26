//package lustrum.kmtsl.stepDef;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.junit.Assert;
//
//import java.time.Duration;
//
//public class LoginStepDefinition {
//    WebDriver driver;
//    String baseUrl = "http://localhost:3000/cia/login";
//
//    @Given("^I am on the login page$")
//    public void i_am_on_the_login_page() {
//        driver = new FirefoxDriver();
//        driver.manage().window().maximize();
//        driver.get(baseUrl);
//    }
//
//    @When("^I enter login username \"([^\"]*)\"$")
//    public void i_enter_login_username(String username) {
//        WebElement usernameInput = driver.findElement(By.xpath("//input[@placeholder='Masukkan alamat email atau username']"));
//        usernameInput.sendKeys(username);
//    }
//
//    @And("^I enter login password \"([^\"]*)\"$")
//    public void i_enter_login_password(String password) {
//        WebElement passwordInput = driver.findElement(By.xpath("//input[@placeholder='Masukkan password']"));
//        passwordInput.sendKeys(password);
//    }
//
//    @And("^I submit the login form$")
//    public void i_submit_the_login_form() {
//        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Login']"));
//        loginButton.click();
//    }
//
//    @Then("I should see an error message {string}")
//    public void i_should_see_an_error_message(String errorMessage) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + errorMessage + "')]")));
//        String actualErrorMessage = errorElement.getText();
//        Assert.assertEquals(errorMessage, actualErrorMessage);
//    }
//
//    @Then("^I should be redirected to the user dashboard$")
//    public void i_should_be_redirected_to_the_user_dashboard() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement dashboardElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'Terimakasih telah melakukan pendaftaran')]")));
//        Assert.assertTrue(dashboardElement.isDisplayed());
//    }
//
//    @And("^Close the browser login$")
//    public void close_the_browser_login() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//}
