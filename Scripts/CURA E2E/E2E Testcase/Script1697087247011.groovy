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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import MakeAppointment.HealthCareProgramEnum
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

 
WebUI.openBrowser('https://katalon-demo-cura.herokuapp.com/');
String txtUsername='John Doe'
String txtPassword='ThisIsNotAPassword'
String txtFacility='Tokyo CURA Healthcare Center'
String txtVisitDate='10/10/2023'
String txtComment='ThisIsComment'
String txtHealthcareProgram='Medicaid'

'Landing Page'
CustomKeywords.'LandingPages.clickAppointmentButton'()

'Login Page'
CustomKeywords.'LoginPages.inputLoginInformation'(txtUsername, txtPassword)
CustomKeywords.'LoginPages.isAtLoginPages'()
CustomKeywords.'LoginPages.clickLoginButton'()

'Make Appointment Page'
CustomKeywords.'MakeAppointment.isAtMakeAppointmentPages'()
CustomKeywords.'MakeAppointment.selectFacility'(txtFacility)
CustomKeywords.'MakeAppointment.clickCheckbox'();
CustomKeywords.'MakeAppointment.chooseHealthcareProgram'(HealthCareProgramEnum.radio_program_medicaid);
CustomKeywords.'MakeAppointment.inputVisitDate'(txtVisitDate)
CustomKeywords.'MakeAppointment.inputComment'(txtComment)
CustomKeywords.'MakeAppointment.clickBookAppointment'()

'Confirm Appointment Page'
CustomKeywords.'AppointmentConfirm.IsAtAppointmentConfirmPages'()
WebUI.verifyEqual(CustomKeywords.'AppointmentConfirm.getFacilityText'(),txtFacility )
WebUI.verifyEqual(CustomKeywords.'AppointmentConfirm.getCommentText'(),txtComment )
WebUI.verifyEqual(CustomKeywords.'AppointmentConfirm.getVisitDate'(),txtVisitDate )
WebUI.verifyEqual(CustomKeywords.'AppointmentConfirm.getHealthcareProgram'(),txtHealthcareProgram )
WebUI.verifyEqual(CustomKeywords.'AppointmentConfirm.getReadmissionText'(),'Yes' )
CustomKeywords.'AppointmentConfirm.clickHomepageButton'()

'Landing pages'
CustomKeywords.'LandingPages.isAtLandingPages'()

WebUI.closeBrowser();