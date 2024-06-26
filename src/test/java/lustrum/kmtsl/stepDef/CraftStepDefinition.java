package lustrum.kmtsl.stepDef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

public class CraftStepDefinition {

    WebDriver driver;
    String loginUrl = "http://localhost:3000/cia/login";
    String craftFormUrl = "http://localhost:3000/craft";

    @Given("^I am on the login page$")
    public void i_am_on_the_login_page() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(loginUrl);
    }

    @When("^I enter login username \"([^\"]*)\"$")
    public void i_enter_login_username(String username) {
        WebElement usernameInput = driver.findElement(By.xpath("//input[@placeholder='Masukkan alamat email atau username']"));
        usernameInput.sendKeys(username);
    }

    @And("^I enter login password \"([^\"]*)\"$")
    public void i_enter_login_password(String password) {
        WebElement passwordInput = driver.findElement(By.xpath("//input[@placeholder='Masukkan password']"));
        passwordInput.sendKeys(password);
    }

    @And("^I submit the login form$")
    public void i_submit_the_login_form() {
        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Login']"));
        loginButton.click();
    }

    @Then("^I should be redirected to the user dashboard$")
    public void i_should_be_redirected_to_the_user_dashboard() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dashboardElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'Terimakasih telah melakukan pendaftaran')]")));
        Assert.assertTrue(dashboardElement.isDisplayed());

        // Redirect to Craft Data Form page
        driver.get(craftFormUrl);
    }

    @Given("^I am on the Craft Data Form page$")
    public void i_am_on_the_craft_data_form_page() {
        driver.get(craftFormUrl);
    }

    @When("^the user enters \"([^\"]*)\" into the \"([^\"]*)\" field$")
    public void userEntersTextIntoField(String text, String fieldLabel) {
        By fieldLocator = null;
        switch (fieldLabel) {
            case "Nama Lengkap Peserta":
                fieldLocator = By.xpath("//input[@placeholder='Nama lengkap peserta']");
                break;
            case "Email":
                fieldLocator = By.xpath("//input[@placeholder='Alamat email anda']");
                break;
            case "Asal Instansi":
                fieldLocator = By.xpath("//input[@placeholder='Asal instansi']");
                break;
            case "Nomor Whatsapp":
                fieldLocator = By.xpath("//input[@placeholder='Nomor Whatsapp']");
                break;
        }
        driver.findElement(fieldLocator).sendKeys(text);
    }

    @When("^the user uploads \"([^\"]*)\" to the \"([^\"]*)\" field$")
    public void userUploadsFile(String filePath, String fieldLabel) {
        By uploadFieldLocator = null;
        switch (fieldLabel) {
            case "Kartu Tanda Mahasiswa":
                uploadFieldLocator = By.name("ktm");
                break;
            case "Bukti Pembayaran":
                uploadFieldLocator = By.name("payment_proof");
                break;
            case "Bukti Follow Instagram PKTSL":
                uploadFieldLocator = By.name("pktsl_follow_proof");
                break;
            case "Bukti Follow Instagram Civil In Action":
                uploadFieldLocator = By.name("cia_follow_proof");
                break;
            case "Bukti Story Instagram":
                uploadFieldLocator = By.name("craft_story_proof");
                break;
        }
        WebElement uploadField = driver.findElement(uploadFieldLocator);
        uploadField.sendKeys(System.getProperty("user.dir") + "/src/test/resources/File/" + filePath);
    }



    @When("^the user clicks \"([^\"]*)\"$")
    public void userClicksButton(String buttonText) {
        WebElement button = driver.findElement(By.xpath("//button[text()='" + buttonText + "']"));

        // Scroll the button into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);

        button.click();
    }

    @Then("^the form should be submitted successfully$")
    public void formSubmittedSuccessfully() {
        // Verify the success toast message
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Pendaftaran berhasil')]")));
        Assert.assertTrue(toastMessage.isDisplayed());
    }

    @And("^Close the browser login$")
    public void close_the_browser_login() {
        if (driver != null) {
            driver.quit();
        }
    }
}
