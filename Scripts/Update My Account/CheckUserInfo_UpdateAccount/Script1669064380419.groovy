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

//Check and Get values from App
Mobile.callTestCase(findTestCase('Login/MyAccount_Login'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('User Profile/EditAccount_MyAccount'), 0, FailureHandling.STOP_ON_FAILURE)

//Get values from update account

def UserFNName_UpdateAccount = Mobile.getText(findTestObject('User Profile/FNValue_EditProfile'), 10, FailureHandling.STOP_ON_FAILURE)
def UserLNName_UpdateAccount = Mobile.getText(findTestObject('User Profile/LNValue_EditProfile'), 10, FailureHandling.STOP_ON_FAILURE)
def UserEmail_UpdateAccount = Mobile.getText(findTestObject('User Profile/EmailValue_EditProfile'), 10, FailureHandling.STOP_ON_FAILURE)
def UserPhone_UpdateAccount = Mobile.getText(findTestObject('User Profile/PhoneValue_EditProfile'), 10, FailureHandling.STOP_ON_FAILURE)
def UserLink_UpdateAccount = Mobile.getText(findTestObject('User Profile/ProfileLink_EditProfile'), 10, FailureHandling.STOP_ON_FAILURE)
Mobile.scrollToText('تاريخ الميلاد')
//def UserFullLink_UpdateAccount = Mobile.getText(findTestObject('User Profile/FullUserLink_EditProfile'), 10, FailureHandling.STOP_ON_FAILURE)
def UserGender_UpdateAccount = Mobile.getText(findTestObject('User Profile/GenderValue_EditProfile'), 10, FailureHandling.STOP_ON_FAILURE)
def UserBirthdate_UpdateAccount = Mobile.getText(findTestObject('User Profile/BirthdateValue_EditProfile'), 10, FailureHandling.STOP_ON_FAILURE)


//Get values from API

GetUserInfo_API = WS.sendRequest(findTestObject('GetUserAccountInfo'))

def slurper = new JsonSlurper()

def result = slurper.parseText(GetUserInfo_API.getResponseBodyContent())

def FNValue_API = result.result.data.first_name
def LNValue_API = result.result.data.last_name
def EmailValue_API = result.result.data.M_email
def PhoneValue_API = result.result.data.phone_number
def UserLinkValue_API = result.result.data.M_user_name
def GenderValue_API = result.result.data.gender
GenderValue_API=GenderValue_API.toString()
def BirthdateValue_API = result.result.data.birthday

//Convert gender value to string

if(GenderValue_API.equals('1')) {
	GenderValue_API='ذكر'
}else if(GenderValue_API.equals('2')){
	GenderValue_API='انثى'
}


//Check values from App = Values from API

Mobile.verifyEqual(UserFNName_UpdateAccount.toString(), FNValue_API.toString(), FailureHandling.STOP_ON_FAILURE)
Mobile.verifyEqual(UserLNName_UpdateAccount.toString(), LNValue_API.toString(), FailureHandling.STOP_ON_FAILURE)
Mobile.verifyEqual(UserEmail_UpdateAccount.toString(), EmailValue_API.toString(), FailureHandling.STOP_ON_FAILURE)
Mobile.verifyEqual(UserPhone_UpdateAccount.toString(), PhoneValue_API.toString(), FailureHandling.STOP_ON_FAILURE)
Mobile.verifyEqual(UserLink_UpdateAccount.toString(), UserLinkValue_API.toString(), FailureHandling.STOP_ON_FAILURE)
Mobile.verifyEqual(UserGender_UpdateAccount.toString(), GenderValue_API.toString(), FailureHandling.STOP_ON_FAILURE)
Mobile.verifyEqual(UserBirthdate_UpdateAccount.toString(), BirthdateValue_API.toString(), FailureHandling.STOP_ON_FAILURE)


Mobile.closeApplication()





