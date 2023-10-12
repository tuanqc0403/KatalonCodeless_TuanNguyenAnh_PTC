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

public class MakeAppointment {

	@Keyword
	def isAtMakeAppointmentPages() {
		return WebUI.waitForElementVisible(findTestObject('Object Repository/MakeAppointmentPages/btnBookAppointment'), 5);
	}

	@Keyword
	def selectFacility(String txtFacility) {
		WebUI.selectOptionByValue(findTestObject('Object Repository/MakeAppointmentPages/lstFacility'), txtFacility, false);
	}

	@Keyword
	def clickCheckbox() {
		WebUI.click(findTestObject('Object Repository/MakeAppointmentPages/chkReadmission'));
	}

	@Keyword
	def chooseHealthcareProgram(String healthCareProgramID) {
		WebUI.click(findTestObject('Object Repository/MakeAppointmentPages/rdoHealthcare',['id' : healthCareProgramID]));
	}

	@Keyword
	def inputVisitDate(String txtVisitDate) {
		WebUI.sendKeys(findTestObject('Object Repository/MakeAppointmentPages/txtVisitDate'), txtVisitDate);
	}

	@Keyword
	def inputComment(String txtComment) {
		WebUI.sendKeys(findTestObject('Object Repository/MakeAppointmentPages/txtComment'), txtComment);
	}

	@Keyword clickBookAppointment(){
		WebUI.click(findTestObject('Object Repository/MakeAppointmentPages/btnBookAppointment'));
	}
}
