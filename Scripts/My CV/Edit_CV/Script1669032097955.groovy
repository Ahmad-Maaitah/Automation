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
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import groovy.json.JsonSlurper as JsonSlurper
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

//Check and Get values from App
Mobile.callTestCase(findTestCase('Login/MyAccount_Login'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.scrollToText('أكمل السيرة الذاتية')

Mobile.tap(findTestObject('JobProfile MyAccount/CompleteCV_Btn'), 0, FailureHandling.STOP_ON_FAILURE)

//Edit first and last name 

Mobile.tap(findTestObject('Edit CV/EditBtn_NameValue_CV'), 10, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Edit CV/EditFN_CV'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.clearText(findTestObject('Edit CV/SetTextFN_CV'), 0)

Mobile.setText(findTestObject('Edit CV/SetTextFN_CV'), 'Edit F N', 0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Edit CV/SetTextLN_CV'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.clearText(findTestObject('Edit CV/SetTextLN_CV'), 0)


Mobile.setText(findTestObject('Edit CV/SetTextLN_CV'), 'Edit L N', 0, FailureHandling.STOP_ON_FAILURE)

//Mobile.hideKeyboard()

Mobile.pressBack()

Mobile.tap(findTestObject('Edit CV/CV_EditNameSaveBtn'), 0, FailureHandling.STOP_ON_FAILURE)

//Edit  Bio

Mobile.tap(findTestObject('User CV Profile/CV_BioValue'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Edit CV/SetTextBio_CV'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.clearText(findTestObject('Edit CV/SetTextBio_CV'), 0)

Mobile.setText(findTestObject('Edit CV/SetTextBio_CV'), 'Looking for noew job .....', 0, FailureHandling.STOP_ON_FAILURE)

Mobile.pressBack()

Mobile.tap(findTestObject('Edit CV/SaveBtn_BioCV'), 0, FailureHandling.STOP_ON_FAILURE)




Mobile.clearText(findTestObject('Edit CV/SetTextFN_CV'), 0)