import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable

import org.openqa.selenium.Keys as Keys
import org.apache.commons.io.FileUtils

WebUI.openBrowser('https://katalon-demo-cura.herokuapp.com/')

	TestData loginData = findTestData("Login Data")

	CustomKeywords.'LandingPages.clickAppointmentButton'()

	for(int i=1;i<=3;i++) {
		CustomKeywords.'LoginPages.inputLoginInformation'(loginData.getObjectValue('Username', i).toString(), loginData.getObjectValue('Password', i).toString());
		CustomKeywords.'LoginPages.clickLoginButton'()
		CustomKeywords.'LoginPages.isErrorMessageDisplay'()
		CustomKeywords.'LoginPages.removeData'()
	}


WebUI.closeBrowser()