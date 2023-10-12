import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class LoginPages {

	@Keyword
	def isAtLoginPages() {
		return WebUI.waitForElementVisible(findTestObject('Object Repository/LoginPages/txtUserName'), 5);
	}

	@Keyword
	def inputUserNameText(String txtUsername) {
		WebUI.sendKeys(findTestObject('Object Repository/LoginPages/txtUserName'),txtUsername);
	}

	@Keyword
	def inputPasswordText(String txtPassword) {
		WebUI.sendKeys(findTestObject('Object Repository/LoginPages/txtPassword'),txtPassword);
	}

	@Keyword
	def inputLoginInformation(String txtUsername, String txtPassword) {
		inputUserNameText(txtUsername);
		inputPasswordText(txtPassword);
	}

	@Keyword
	def clickLoginButton() {
		WebUI.click(findTestObject('Object Repository/LoginPages/btnLogin'));
	}
	
	@Keyword
	def isErrorMessageDisplay() {
		WebUI.waitForElementVisible(findTestObject('Object Repository/LoginPages/txtErrorMessage'), 5);
	}
}

