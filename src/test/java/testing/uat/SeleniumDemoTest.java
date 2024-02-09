package testing.uat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumDemoTest {
    private RemoteWebDriver driver;

    @BeforeEach
    void init() {
    	//creates a new chrome window
    	ChromeOptions opts = new ChromeOptions();
//		opts.addArguments("--headless=new");
        this.driver = new ChromeDriver(opts);
        // sets the new window to fullscreen
        this.driver.manage().window().maximize();
    }

    @Test
    void seleniumTest() {
//        this.driver.get("http://www.bing.com");
    }


	@Test
	void textBoxTest() {
		this.driver.get("https://demoqa.com/text-box");

		WebElement consent = this.driver.findElement(By.cssSelector(
				"body > div.fc-consent-root > div.fc-dialog-container > div.fc-dialog.fc-choice-dialog > div.fc-footer-buttons-container > div.fc-footer-buttons > button.fc-button.fc-cta-consent.fc-primary-button"));
		consent.click();

		WebElement fullName = this.driver.findElement(By.id("userName"));
		fullName.sendKeys("Michaela");

		WebElement email = this.driver.findElement(By.cssSelector("#userEmail"));
		email.sendKeys("mi@hotmail.com");

		WebElement currentAddress = this.driver.findElement(By.cssSelector("#currentAddress"));
		currentAddress.sendKeys("123 fake street");

		WebElement permanentAddress = this.driver.findElement(By.cssSelector("#permanentAddress"));
		permanentAddress.sendKeys("333 real street");

		WebElement submit = this.driver.findElement(By.id("submit"));
//		this.driver.executeScript("arguments[0].scrollIntoView(true);", submit);
		submit.click();

		WebElement display = this.driver.findElement(By.id("name"));

		Assertions.assertEquals(true, display.getText().contains("Michaela"));

		WebElement emailDisplay = this.driver.findElement(By.cssSelector("#email"));
		Assertions.assertEquals("Email:mi@hotmail.com", emailDisplay.getText());

		WebElement currentAddressDisplay = this.driver.findElement(By.cssSelector("#output #currentAddress"));
		Assertions.assertEquals("Current Address :123 fake street", currentAddressDisplay.getText());

		WebElement permanentAddressDisplay = this.driver.findElement(By.cssSelector("#output #permanentAddress"));
		Assertions.assertEquals("Permananet Address :333 real street", permanentAddressDisplay.getText());

	}

	@Test
	void testCheckBox() {
		this.driver.get("https://demoqa.com/checkbox");

		WebElement consent = this.driver.findElement(By.cssSelector(
				"body > div.fc-consent-root > div.fc-dialog-container > div.fc-dialog.fc-choice-dialog > div.fc-footer-buttons-container > div.fc-footer-buttons > button.fc-button.fc-cta-consent.fc-primary-button"));
		consent.click();

		WebElement homeArrow = this.driver.findElement(By.cssSelector("#tree-node > ol > li > span > button > svg"));
		homeArrow.click();

		WebElement docsArrow = this.driver
				.findElement(By.cssSelector("#tree-node > ol > li > ol > li:nth-child(2) > span > button > svg"));
		docsArrow.click();

		WebElement workArrow = this.driver.findElement(By.cssSelector(
				"#tree-node > ol > li > ol > li.rct-node.rct-node-parent.rct-node-expanded > ol > li:nth-child(1) > span > button > svg"));
		workArrow.click();

		WebElement react = this.driver.findElement(By.cssSelector(
				"#tree-node > ol > li > ol > li.rct-node.rct-node-parent.rct-node-expanded > ol > li.rct-node.rct-node-parent.rct-node-expanded > ol > li:nth-child(1) > span > label > span.rct-checkbox > svg"));
		react.click();

		WebElement output = this.driver.findElement(By.cssSelector("#result"));

		Assertions.assertTrue(output.getText().contains("react"));

		WebElement checked = this.driver.findElement(By.cssSelector(
				"#tree-node > ol > li > ol > li.rct-node.rct-node-parent.rct-node-expanded > ol > li.rct-node.rct-node-parent.rct-node-expanded > ol > li:nth-child(1) > span > label > span.rct-checkbox > svg"));

		// check that the svg does NOT have the 'uncheck' class
		Assertions.assertFalse(checked.getAttribute("class").contains("uncheck"));
	}
    @AfterEach
    void TearDown() {
//    	this.driver.quit();
    }
}
