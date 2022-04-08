package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name="firstName")
    private WebElement firstNameTxt;

    @FindBy(name="lastName")
    private WebElement lastNameTxt;

    @FindBy(name="email")
    private WebElement usernameTxt;

    @FindBy(name="password")
    private WebElement passwordTxt;

    @FindBy(name="confirmPassword")
    private WebElement confirmPasswordTxt;

    @FindBy(name="submit")
    private WebElement submitBtn;

    public RegistrationPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void goTo(){
        this.driver.get("https://demo.guru99.com/selenium/newtours/register.php");
        this.wait.until(ExpectedConditions.visibilityOf(this.firstNameTxt));
        try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Navigating to site https://demo.guru99.com/selenium/newtours/register.php");
    }

    public void enterUserDetails(String firstName, String lastName){
        this.firstNameTxt.sendKeys(firstName);
        this.lastNameTxt.sendKeys(lastName);
        System.out.println("Enter User Details as First Name = "+firstName+". Last Name = "+lastName);
    }

    public void enterUserCredentials(String username, String password){
        this.usernameTxt.sendKeys(username);
        this.passwordTxt.sendKeys(password);
        this.confirmPasswordTxt.sendKeys(password);
        System.out.println("Enter User Details as Username = "+username+". password = "+password);
    }

    public void submit(){
        this.submitBtn.click();
        System.out.println("Submit --------");
    }
}
