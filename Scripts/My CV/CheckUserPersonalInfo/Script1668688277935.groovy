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

//Check and Get values from App
Mobile.callTestCase(findTestCase('Login/MyAccount_Login'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.scrollToText('أكمل السيرة الذاتية')

Mobile.tap(findTestObject('User CV Profile/CompletCVBtn_MyAccount'), 5, FailureHandling.STOP_ON_FAILURE)

def CV_UserName = Mobile.getText(findTestObject('User CV Profile/CV_UserFullName'), 5, FailureHandling.STOP_ON_FAILURE)

def CV_UserPhone = Mobile.getText(findTestObject('User CV Profile/CV_UserPhoneValue'), 5, FailureHandling.STOP_ON_FAILURE)

//Mobile.scrollToText('بلد الإقامة')
Mobile.scrollToText('تاريخ الميلاد')
def CV_UserBirthdate= Mobile.getText(findTestObject('User CV Profile/CV_UserBirthDate'), 5, FailureHandling.STOP_ON_FAILURE)
Mobile.scrollToText('الراتب')

def CV_UserSalary= Mobile.getText(findTestObject('User CV Profile/CV_UserSalary'), 5, FailureHandling.STOP_ON_FAILURE)
Mobile.scrollToText('هل لديك مركبة؟')

def CV_UserHasCar= Mobile.getText(findTestObject('User CV Profile/CV_UserHasCar'), 5, FailureHandling.STOP_ON_FAILURE)
def CV_UserHasDriverLicense= Mobile.getText(findTestObject('User CV Profile/CV_DriverLicense'), 5, FailureHandling.STOP_ON_FAILURE)
def CV_UserAbilityRelocate= Mobile.getText(findTestObject('User CV Profile/CV_AbilutyRelocate'), 5, FailureHandling.STOP_ON_FAILURE)


//def CV_UserBio = Mobile.getText(findTestObject('User CV Profile/CV_BioValue'), 5, FailureHandling.STOP_ON_FAILURE)

//GET values from API from CV API
CVResponse_API = WS.sendRequestAndVerify(findTestObject('CV_PersonalInfo'))

def slurper = new JsonSlurper()

def result = slurper.parseText(CVResponse_API.getResponseBodyContent())

def UserFirstName_API = result.result.data.draft.payload.firstNameField

def UserLastName_API = result.result.data.draft.payload.lastNameField

def UserBio_API = result.result.data.draft.payload.aboutMeField

def UserBirthdate_API = result.result.data.draft.payload.dateOfBirthField


def UserSalary_API = result.result.data.draft.payload.salaryField

def UserFullName_API = (UserFirstName_API + ' ') + UserLastName_API

//Get value for bundles from API

UserInfo_API = WS.sendRequest(findTestObject('GetUserAccountInfo'))

def slurperInfo = new JsonSlurper()

def resultUserInfo = slurperInfo.parseText(UserInfo_API.getResponseBodyContent())

def UserPhoneValue_API = resultUserInfo.result.data.phone_number

// Validate data returned from App = Data returned from API

Mobile.verifyEqual(CV_UserName.toString(), UserFullName_API.toString(), FailureHandling.STOP_ON_FAILURE)

//Mobile.verifyEqual(CV_UserBio.toString(), UserBio_API.toString(), FailureHandling.STOP_ON_FAILURE)

if (CV_UserPhone.contains(UserPhoneValue_API)) {
	println((('Correct >> Value for Cv' + CV_UserPhone) + ' Equal API value') + UserPhoneValue_API)
} else {
	throw new Exception((('Not Correct >> Value for Cv' + CV_UserPhone) + ' Not equal') +
	UserPhoneValue_API)
}

Mobile.verifyEqual(CV_UserBirthdate.toString(), UserBirthdate_API.toString(), FailureHandling.STOP_ON_FAILURE)
Mobile.verifyEqual(CV_UserSalary.toString(), UserSalary_API.toString(), FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

