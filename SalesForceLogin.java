package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class SalesForceLogin {
	public ChromeDriver driver;
	public WebDriverWait wait;
	String Account_holder;
	
	@Given("Launch the browser")
	public void launch_the_browser1() {
		driver=new ChromeDriver();
	}
	
	@Given("Load the URL")
	public void load_the_url1() {
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	@Given("Enter the username as vidyar@testleaf.com")
	public void enter_the_username_as_vidyar_testleaf_com() {
		driver.findElement(By.id("username")).sendKeys("vidyar@testleaf.com");

	}
	@Given("Enter the Password as {string}")
	public void enter_the_password_as_sales(String pwd) {
		driver.findElement(By.id("password")).sendKeys(pwd);
	}
	@When("Click on the Login button")
	public void click_on_the_login_button1() {
		driver.findElement(By.id("Login")).click();
	}

@When("Click on toggle menu button from the left corner")
public void click_on_toggle_menu_button_from_the_left_corner() {
	driver.findElement(By.xpath(" //div[@class='slds-icon-waffle']")).click();
}
@When("Click view All and click Sales from App Launcher")
public void click_view_all_and_click_sales_from_app_launcher() {
	WebElement viewall = driver.findElement(By.xpath("(//button[@class='slds-button'])[2]"));
	Actions a=new Actions(driver);
	a.moveToElement(viewall).click().perform();
	driver.findElement(By.xpath("(//div[@class='slds-truncate'])[8]")).click();
}
@When("Click on Accounts tab")
public void click_on_accounts_tab() {
	wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.xpath("//span[text()='Accounts' and @class='slds-truncate']")));
	WebElement accountsTab = wait.until(ExpectedConditions
			.presenceOfElementLocated(By.xpath("//span[text()='Accounts' and @class='slds-truncate']")));
	driver.executeScript("arguments[0].click();", accountsTab);

}
@When("Click on New button")
public void click_on_new_button() {
   driver.findElement(By.xpath("//div[@title='New']")).click();
}
@Given("Enter {string} as account name")
public void enter_as_account_name(String name) {
	Account_holder=name;
    driver.findElement(By.xpath("(//input[@class='slds-input'])[5]")).sendKeys(name);
}
@When("Select Ownership as Public")
public void select_ownership_as_public() {
    WebElement dropdown = driver.findElement(By.xpath("(//div[@class='slds-combobox__form-element slds-input-has-icon slds-input-has-icon_right'])[5]"));
    driver.executeScript("arguments[0].click();", dropdown);
    WebElement public_op = driver.findElement(By.xpath("(//div[@class='slds-listbox slds-listbox_vertical slds-dropdown slds-dropdown_fluid slds-dropdown_left slds-dropdown_length-with-icon-7']//lightning-base-combobox-item)[2]"));
    driver.executeScript("arguments[0].click();", public_op);
}
@When("Click save and verify Account name")
public void click_save_and_verify_account_name() {
    //click on save button
	driver.findElement(By.xpath("(//button[@class='slds-button slds-button_brand'])[3]")).click();
	//retrive success message from toast
	String succ_msg = driver.findElement(By.xpath("(//div[@class='slds-theme--success slds-notify--toast slds-notify slds-notify--toast forceToastMessage']//div//div)[3]")).getText();
	System.out.println(succ_msg);
	String[] split = succ_msg.split(" ");
	System.out.println(split[1].replace("\"", ""));
	String replace = split[1].replace("\"", "");
	System.out.println(replace.equalsIgnoreCase(Account_holder));
    
}

}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	