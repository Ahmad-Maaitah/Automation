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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import groovy.json.JsonSlurper as JsonSlurper
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

Mobile.callTestCase(findTestCase('Login/MyAccount_Login'), [:], FailureHandling.STOP_ON_FAILURE)
Mobile.scrollToText('اتصل بنا')
Mobile.tap(findTestObject('ContactUs/ContactUsBtn_MyAccount'), 5, FailureHandling.STOP_ON_FAILURE)

//Check User info from App

def UserName_ContactUs=Mobile.getText(findTestObject('ContactUs/UserNameValue_ContactUs'), 5, FailureHandling.STOP_ON_FAILURE)
def UserPhone_ContactUs=Mobile.getText(findTestObject('ContactUs/UserPhoneValue_ContactUs'), 5, FailureHandling.STOP_ON_FAILURE)
def UserEmail_ContactUs=Mobile.getText(findTestObject('ContactUs/UserEmailValue_ContactUs'), 5, FailureHandling.STOP_ON_FAILURE)

//Get User Info from API

GetUserInfo_API = WS.sendRequest(findTestObject('GetUserAccountInfo'))
def slurper = new JsonSlurper()
def result = slurper.parseText(GetUserInfo_API.getResponseBodyContent())

def UserFullName_API = result.result.data.full_name
def UserPhone_API = result.result.data.phone_number
def UserEmail_API = result.result.data.M_email

Mobile.verifyEqual(UserName_ContactUs.toString(), UserFullName_API.toString(), FailureHandling.STOP_ON_FAILURE)
Mobile.verifyEqual(UserPhone_ContactUs.toString(), UserPhone_API.toString(), FailureHandling.STOP_ON_FAILURE)
Mobile.verifyEqual(UserEmail_ContactUs.toString(), UserEmail_API.toString(), FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('ContactUs/Category_Feedback'), 5, FailureHandling.STOP_ON_FAILURE)
Mobile.tap(findTestObject('ContactUs/ConditionOpt_Feedback'), 5, FailureHandling.STOP_ON_FAILURE)
Mobile.setText(findTestObject('ContactUs/SendYourIssueField_FeedBack'), 'test contact us screen testtttttttttt', 0, FailureHandling.STOP_ON_FAILURE)
Mobile.tap(findTestObject('ContactUs/SendBtn_Feedback'), 5, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementText(findTestObject('ContactUs/ThankUTxt_SuccessFB'), 'شكراً لك!', FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementText(findTestObject('ContactUs/FeedBackSent_FeedBack'), 'تم إرسال الشكوى', FailureHandling.STOP_ON_FAILURE)
Mobile.tap(findTestObject('ContactUs/BackToFBBtn_Success'), 5, FailureHandling.STOP_ON_FAILURE)

//Close the app
Mobile.closeApplication()
