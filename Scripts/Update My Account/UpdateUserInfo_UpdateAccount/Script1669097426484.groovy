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
import org.apache.commons.lang.RandomStringUtils
import groovy.json.JsonSlurper as JsonSlurper
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

//Generate random numbers 
def GenerateNum() {
String charset = ('0'..'9').join()
Integer length = 2
String randomNumber = RandomStringUtils.random(length, charset.toCharArray())
}

//Generate random straing
def GenerateString() {
String charset = ('a'..'z').join()
Integer length = 9
String randomString = RandomStringUtils.random(length, charset.toCharArray())
}

//Generate random numbers 1- 30 -FD
def GenerateNum_FD() {
String charset = ('0'..'9').join()
Integer length = 1
String randomNumber = RandomStringUtils.random(length, charset.toCharArray())
}

//Generate random numbers 1- 30 -SD
def GenerateNum_SD() {
String charset = ('1'..'9').join()
Integer length = 1
String randomNumber = RandomStringUtils.random(length, charset.toCharArray())
}


//Generate random months
def GenerateBirthdate() {
def RendomMonth_Name=['يناير ','فبراير','مارس','أبريل','مايو','يونيو','يوليو',' أغسطس','سبتمبر','أكتوبر','نوفمبر','ديسمبر']
Random test = new Random();
int Rand_item = test.nextInt(RendomMonth_Name.size());
String MonthName=RendomMonth_Name[Rand_item]
return MonthName
}

//Generate random years
def GenerateBirthYear() {
Date now = new Date();
int year = now.getYear() + 1900;
year=year-10
int year2=1900
String randomNumber = Math.abs( new Random().nextInt() % (year - year2) ) + year2

}
/*
//Get randome value from Gender
def RandomGender() {
	
	def FemalOption='User Profile/FemaleGenderOpt_UpdateGender'
	def MaleOption='User Profile/MaleGenderOpt_UpdateGender'
	
	String nums = [FemalOption,MaleOption]
	Random nums = new Random();
	
	
	
}*/


//Check and Get values from App
Mobile.callTestCase(findTestCase('Login/MyAccount_Login'), [:], FailureHandling.STOP_ON_FAILURE)
Mobile.tap(findTestObject('User Profile/EditAccount_MyAccount'), 5, FailureHandling.STOP_ON_FAILURE)

//Update First Name value
def FirstName='Test '+GenerateNum()
Mobile.tap(findTestObject('User Profile/FNValue_EditProfile'), 5, FailureHandling.STOP_ON_FAILURE)
Mobile.clearText(findTestObject('User Profile/FNValue_EditProfile'), 5, FailureHandling.STOP_ON_FAILURE)
Mobile.setText(findTestObject('User Profile/FNValue_EditProfile'), FirstName, 5, FailureHandling.STOP_ON_FAILURE)
Mobile.pressBack()

//Update Last name value 
def LastName='Test last'+GenerateNum()
Mobile.tap(findTestObject('User Profile/LNValue_EditProfile'), 5, FailureHandling.STOP_ON_FAILURE)
Mobile.clearText(findTestObject('User Profile/LNValue_EditProfile'), 5, FailureHandling.STOP_ON_FAILURE)
Mobile.setText(findTestObject('User Profile/LNValue_EditProfile'), LastName, 5, FailureHandling.STOP_ON_FAILURE)
Mobile.pressBack()

//Update Emai value
def Email=GenerateString()+'@'+GenerateString()+'.com'
Mobile.tap(findTestObject('User Profile/EmailValue_EditProfile'), 5, FailureHandling.STOP_ON_FAILURE)
Mobile.clearText(findTestObject('User Profile/EmailValue_EditProfile'), 5, FailureHandling.STOP_ON_FAILURE)
Mobile.setText(findTestObject('User Profile/EmailValue_EditProfile'), Email, 0, FailureHandling.STOP_ON_FAILURE)
Mobile.pressBack()

//Update Gender value
Mobile.tap(findTestObject('User Profile/GenderValue_EditProfile'), 5, FailureHandling.STOP_ON_FAILURE)
Mobile.tap(findTestObject('User Profile/FemaleGenderOpt_UpdateGender'), 5, FailureHandling.STOP_ON_FAILURE)


//Update Birthdate Day/ Month / Year
def BirthdayDay=GenerateNum_FD()+GenerateNum_SD()
def BirthdayMonth=GenerateBirthdate()
def BirthdayYear=GenerateBirthYear()

Mobile.tap(findTestObject('User Profile/BirthdateValue_EditProfile'), 5, FailureHandling.STOP_ON_FAILURE)

Mobile.clearText(findTestObject('User Profile/DayValue_UpdateBirthdate'), 5, FailureHandling.STOP_ON_FAILURE)
Mobile.clearText(findTestObject('User Profile/MonthValue_UpdateBirthdate'), 5, FailureHandling.STOP_ON_FAILURE)
Mobile.clearText(findTestObject('User Profile/YearValue_UpdateBirthdate'), 5, FailureHandling.STOP_ON_FAILURE)

Mobile.setText(findTestObject('User Profile/DayValue_UpdateBirthdate'), BirthdayDay, 5, FailureHandling.STOP_ON_FAILURE)
Mobile.setText(findTestObject('User Profile/MonthValue_UpdateBirthdate'), BirthdayMonth, 5, FailureHandling.STOP_ON_FAILURE)
Mobile.setText(findTestObject('User Profile/YearValue_UpdateBirthdate'), '1990', 5, FailureHandling.STOP_ON_FAILURE)

Mobile.tapAndHoldAtPosition(300, 400, 10)

//Mobile.delay(2)


Mobile.scrollToText('حفظ')

//Change Password
Mobile.tap(findTestObject('User Profile/EditPassField_EditProfile'), 5, FailureHandling.STOP_ON_FAILURE)
//Mobile.setText(findTestObject('User Profile/EditPassField_EditProfile'), '1990', 5, FailureHandling.STOP_ON_FAILURE)
 Mobile.pressBack()

//Save Change and Close App
Mobile.tap(findTestObject('User Profile/SaveChange_UpdateProfile'), 5, FailureHandling.STOP_ON_FAILURE)



//Get all info from API and make sure all info update correctlly 

//Get values from API

GetUserInfo_API = WS.sendRequest(findTestObject('GetUserAccountInfo'))
def slurper = new JsonSlurper()
def result = slurper.parseText(GetUserInfo_API.getResponseBodyContent())

def FNValue_Updated_API = result.result.data.first_name
def LNValue_Updated_API = result.result.data.last_name
def EmailValue_Updated_API = result.result.data.M_new_email

Mobile.verifyEqual(FirstName.toString(), FNValue_Updated_API.toString(), FailureHandling.STOP_ON_FAILURE)
Mobile.verifyEqual(LastName.toString(), LNValue_Updated_API.toString(), FailureHandling.STOP_ON_FAILURE)
Mobile.verifyEqual(Email.toString(), EmailValue_Updated_API.toString(), FailureHandling.STOP_ON_FAILURE)
println('>>First Name<< ......................'+FirstName +FNValue_Updated_API)
println('>>Last Name<< ......................'+LastName +LNValue_Updated_API)
println('>>Email<< ......................'+Email +EmailValue_Updated_API)



Mobile.closeApplication()