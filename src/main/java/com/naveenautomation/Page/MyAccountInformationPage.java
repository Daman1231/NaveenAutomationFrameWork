package com.naveenautomation.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Base.TestBase;

public class MyAccountInformationPage extends TestBase {
	public MyAccountInformationPage() {
		PageFactory.initElements(local.get(), this);
	}

	@FindBy(css = "#content h1")
	WebElement myAccountInformationText;

	@FindBy(css = "#input-firstname")
	WebElement firstName;

	@FindBy(css = "#input-lastname")
	WebElement lastName;

	@FindBy(css = "#input-email")
	WebElement email;

	@FindBy(css = "#input-telephone")
	WebElement telePhone;

	@FindBy(css = "input.btn")
	WebElement continueBtn;

	public String getMyAccountInformationText() {
		return myAccountInformationText.getText();
	}

	public String getFirstName() {
		return firstName.getAttribute("value");
	}

	public String getLastName() {
		return lastName.getAttribute("value");
	}

	public String getEmail() {
		return email.getAttribute("value");
	}

	public String getTelephone() {
		return telePhone.getAttribute("value");
	}

	private void inputPhoneNumber(String number) {
		telePhone.clear();
		telePhone.sendKeys(number);
	}

	public MyAccountPage clickContinueBtn(String phoneNumber) {
		inputPhoneNumber(phoneNumber);
		continueBtn.click();
		return new MyAccountPage();
	}

}
