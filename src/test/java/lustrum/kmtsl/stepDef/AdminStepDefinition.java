//package lustrum.kmtsl.stepDef;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.When;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.And;
//import org.junit.Assert;
//
//import java.time.Duration;
//
//public class AdminStepDefinition {
//
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
//    @Then("^I should be redirected to the admin dashboard$")
//    public void i_should_be_redirected_to_the_admin_dashboard() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement dashboardElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'Dashboard Panitia Craft')]")));
//        Assert.assertTrue(dashboardElement.isDisplayed());
//    }
//
//    @When("^I click on the participant details button$")
//    public void i_click_on_the_participant_details_button() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        WebElement participantDetailsLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[3]/div/div/div[1]/table/tbody/tr[1]/td[4]/div/a")));
//        participantDetailsLink.click();
//    }
//
//    @Then("^I should see the participant details page$")
//    public void i_should_see_the_participant_details_page() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement participantDetailsPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'Detail Tim')]")));
//        Assert.assertTrue(participantDetailsPage.isDisplayed());
//    }
//
//    @When("^I select to approve a participant$")
//    public void i_select_to_approve_a_participant() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        WebElement approveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[3]/div/div/div[1]/table/tbody/tr[1]/td[4]/div/button[1]")));
//        approveButton.click();
//    }
//
//    @Then("^the participant should be approved$")
//    public void the_participant_should_be_approved() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement statusElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[3]/div/div/div[1]/table/tbody/tr[1]/td[2]")));
//        Assert.assertEquals("Sudah Terkonfirmasi", statusElement.getText());
//    }
//
//    @When("^I select to reject a participant$")
//    public void i_select_to_reject_a_participant() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement rejectButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[3]/div/div/div[1]/table/tbody/tr[2]/td[4]/div/button[2]")));
//        rejectButton.click();
//    }
//
//    @When("^I click on the download all data button$")
//    public void i_click_on_the_download_all_data_button() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement downloadButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[3]/div/div/div[2]/button")));
//        downloadButton.click();
//    }
//
//    @Then("^the data should be downloaded as a zip file$")
//    public void the_data_should_be_downloaded_as_a_zip_file() {
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    @And("^I enter reject message$")
//    public void i_enter_reject_message() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement rejectMessageInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[2]/section/div[2]/div[1]/div/div/textarea")));
//        rejectMessageInput.sendKeys("Participant rejected due to incomplete information.");
//    }
//
//
//    @And("^I click confirm reject$")
//    public void i_click_confirm_reject() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement confirmRejectButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[2]/section/footer/button[2]")));
//        confirmRejectButton.click();
//    }
//
//
//    @Then("^the participant should be rejected$")
//    public void the_participant_should_be_rejected() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement rejectionStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[3]/div/div/div[1]/table/tbody/tr[2]/td[2]")));
//        Assert.assertEquals("Pendaftaran Ditolak", rejectionStatus.getText().trim());
//    }
//
//
//
//    @And("^Close the browser$")
//    public void close_the_browser() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//}
//
