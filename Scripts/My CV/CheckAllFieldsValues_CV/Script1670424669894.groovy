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
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.sql.*

//Check and Get values from App
Mobile.callTestCase(findTestCase('Login/MyAccount_Login'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.scrollToText('أكمل السيرة الذاتية')

Mobile.tap(findTestObject('JobProfile MyAccount/CompleteCV_Btn'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.swipe(180, 4500, 60, 5500)
Mobile.scrollToText('المسمى الوظيفي')


def CV_JobTitle_App = Mobile.getText(findTestObject('CV Values for fields/CV_JobTitle'), 0, FailureHandling.STOP_ON_FAILURE)
CV_JobTitle_App = CV_JobTitle_App.toString()

def CV_Sector_App = Mobile.getText(findTestObject('CV Values for fields/CV_Sector'), 0, FailureHandling.STOP_ON_FAILURE)
CV_Sector_App = CV_Sector_App.toString()


def CV_ResidenceCountry_App = Mobile.getText(findTestObject('CV Values for fields/CV_countryOfResidence'), 0, FailureHandling.STOP_ON_FAILURE)
CV_ResidenceCountry_App = CV_ResidenceCountry_App.toString()
Mobile.scrollToText('الجنس')

def CV_Gender_App = Mobile.getText(findTestObject('CV Values for fields/CV_Gender'), 0, FailureHandling.STOP_ON_FAILURE)
CV_Gender_App = CV_Gender_App.toString()


def CV_MaritalStatus_App = Mobile.getText(findTestObject('CV Values for fields/CV_marital'), 0, FailureHandling.STOP_ON_FAILURE)
CV_MaritalStatus_App = CV_MaritalStatus_App.toString()

def CV_Nationality_App = Mobile.getText(findTestObject('CV Values for fields/CV_Nationality'), 0, FailureHandling.STOP_ON_FAILURE)
CV_Nationality_App = CV_Nationality_App.toString()

def CV_Readiness_App = Mobile.getText(findTestObject('CV Values for fields/CV_Readiness'), 0, FailureHandling.STOP_ON_FAILURE)
CV_Readiness_App = CV_Readiness_App.toString()

Mobile.scrollToText('ما نوع عقد التوظيف؟')

Mobile.getElementLeftPosition(findTestObject('CV Values for fields/CV_ContractType'), 0)
Mobile.getElementTopPosition(findTestObject('CV Values for fields/CV_ContractType'), 0)

def CV_ContractType_App = Mobile.getText(findTestObject('CV Values for fields/CV_ContractType'), 0, FailureHandling.STOP_ON_FAILURE)
CV_ContractType_App = CV_ContractType_App.toString()

def CV_Skills_App = Mobile.getText(findTestObject('CV Values for fields/CV_Skills'), 0, FailureHandling.STOP_ON_FAILURE)
CV_Skills_App = CV_Skills_App.toString()

def CV_Languages_App = Mobile.getText(findTestObject('CV Values for fields/CV_Languages'), 0, FailureHandling.STOP_ON_FAILURE)
CV_Languages_App = CV_Languages_App.toString()

def CV_HasCar_App = Mobile.getText(findTestObject('CV Values for fields/CV_HasCar'), 0, FailureHandling.STOP_ON_FAILURE)
CV_HasCar_App = CV_HasCar_App.toString()

Mobile.getElementLeftPosition(findTestObject('CV Values for fields/CV_HasCar'), 0)
Mobile.getElementTopPosition(findTestObject('CV Values for fields/CV_HasCar'), 0)
//Mobile.scrollToText('هل لديك رخصة قيادة؟')
Mobile.swipe(180, 4500, 60, 5500)

def CV_DrivingLicense_App = Mobile.getText(findTestObject('CV Values for fields/CV_HasLicense'), 0, FailureHandling.STOP_ON_FAILURE)
CV_DrivingLicense_App = CV_DrivingLicense_App.toString()

def CV_LicenseType_App = Mobile.getText(findTestObject('CV Values for fields/CV_LicenseType'), 0, FailureHandling.STOP_ON_FAILURE)
CV_LicenseType_App = CV_LicenseType_App.toString()

def CV_Relocate_App = Mobile.getText(findTestObject('CV Values for fields/CV_Relocate'), 0, FailureHandling.STOP_ON_FAILURE)
CV_Relocate_App = CV_Relocate_App.toString()

def CV_WorkingHours_App = Mobile.getText(findTestObject('CV Values for fields/CV_WorkingHours'), 0, FailureHandling.STOP_ON_FAILURE)
CV_WorkingHours_App = CV_WorkingHours_App.toString()

def CV_EducationLevel_App = Mobile.getText(findTestObject('CV Values for fields/CV_EducationLevel'), 0, FailureHandling.STOP_ON_FAILURE)
CV_EducationLevel_App = CV_EducationLevel_App.toString()

Mobile.scrollToText('ما مستوى الخبرة؟')

def CV_WorkExperiance_App = Mobile.getText(findTestObject('CV Values for fields/CV_ExperianceLevel'), 0, FailureHandling.STOP_ON_FAILURE)
CV_WorkExperiance_App = CV_WorkExperiance_App.toString()

println(CV_JobTitle_App)
println('Sector>>>>>>>>>>>>>>>>>'+CV_Sector_App)
println('Residence Country>>>>>>>>>>>>'+CV_ResidenceCountry_App)
println('Gender>>>>>>>>>>>'+CV_Gender_App)
println('Marital State>>>>>>>>>>>'+CV_MaritalStatus_App)
println('Nationality>>>>>>>>>>>'+CV_Nationality_App)
println('Readiness>>>>>>>>>>>>>'+CV_Readiness_App)
println(CV_ContractType_App)
println('Languages>>>>>>>>>>>>>'+CV_Languages_App)
println('Has Car>>>>>>>>>>>>>>>'+CV_HasCar_App)
//println('Driver license???????????'+CV_DrivingLicense_App)

println(CV_LicenseType_App)
println(CV_WorkingHours_App)
println(CV_EducationLevel_App)
println(CV_WorkExperiance_App)


//GET values from API
GetUserInfo = WS.sendRequest(findTestObject('CV_PersonalInfo'))

def slurper = new JsonSlurper()

def result = slurper.parseText(GetUserInfo.getResponseBodyContent())

def workFromHome_API = result.result.data.draft.payload.workFromHomeField
def experienceLevel_API = result.result.data.draft.payload.experienceLevelField
def countryOfResidence_API = result.result.data.draft.payload.countryOfResidenceField
def workAvailability_API = result.result.data.draft.payload.workAvailabilityField
def jobSector_API = result.result.data.draft.payload.jobSectorField
def relocate_API = result.result.data.draft.payload.relocateField
def educationLevelField_API = result.result.data.draft.payload.educationLevelField
def drivingLicense_API = result.result.data.draft.payload.drivingLicenseField
def workingHours_API = result.result.data.draft.payload.workingHoursField
def marital_API = result.result.data.draft.payload.maritalField
def drivingLicenseType_API = result.result.data.draft.payload.drivingLicenseTypeField
def nationality_API = result.result.data.draft.payload.nationalityField
def languages_API = result.result.data.draft.payload.languagesField
def jobType_API = result.result.data.draft.payload.jobTypeField
def jobRole_API = result.result.data.draft.payload.jobRoleField
def hasCar = result.result.data.draft.payload.hasCarField
def skillsField = result.result.data.draft.payload.skillsField


//Convert to string

workFromHome_API = workFromHome_API.toString()
experienceLevel_API = experienceLevel_API.toString()
countryOfResidence_API = countryOfResidence_API.toString()
workAvailability_API = workAvailability_API.toString()
jobSector_API = jobSector_API.toString()
relocate_API = relocate_API.toString()
drivingLicense_API = drivingLicense_API.toString()
workingHours_API = workingHours_API.toString()
marital_API = marital_API.toString()
drivingLicenseType_API = drivingLicenseType_API.toString()
languages_API = languages_API.toString()
jobType_API = jobType_API.toString()
jobType_API = jobType_API.toString()
jobRole_API=jobRole_API.toString()
hasCar=hasCar.toString()
skillsField=skillsField.toString()

//Check Neighborhood ID and Name from DB

def data = findTestData('Data Files/Sectors')
String SectorValue = ''

for (int i =1; i < 29;i++) {
	String SectorDB = data.getValue(1, i)

	if (SectorDB.equals(jobSector_API)) {
		Mobile.verifyMatch(jobSector_API, SectorDB, false)
		SectorName = data.getValue(3, i)
		Mobile.verifyMatch(CV_Sector_App, SectorName, false)
	
	}
}
