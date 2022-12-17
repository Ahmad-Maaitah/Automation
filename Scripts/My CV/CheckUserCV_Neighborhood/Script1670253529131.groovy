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

Mobile.scrollToText('مدينة السكن')


def CV_UserNeighborhood = Mobile.getText(findTestObject('Edit CV/CV_NeighborhoodValue'), 0, FailureHandling.STOP_ON_FAILURE)
CV_UserNeighborhood = CV_UserNeighborhood.toString()

//GET values from API
GetUserInfo = WS.sendRequest(findTestObject('CV_PersonalInfo'))

def slurper = new JsonSlurper()

def result = slurper.parseText(GetUserInfo.getResponseBodyContent())

def CV_UserNeighborhood_API = result.result.data.draft.payload.residenceField

CV_UserNeighborhood_API = CV_UserNeighborhood_API.toString()

// Check if data from App = API = DB
def data = findTestData('Data Files/NeighborhoodDB')



//Check Neighborhood ID and Name from DB

String NeighborhoodName = ''

for (int i =1; i < 500;i++) {
	String NeighborhoodDB = data.getValue(2, i)

	if (NeighborhoodDB.equals(CV_UserNeighborhood_API)) {
		Mobile.verifyMatch(CV_UserNeighborhood_API, NeighborhoodDB, false)
		NeighborhoodName = data.getValue(3, i)
		Mobile.verifyMatch(CV_UserNeighborhood, NeighborhoodName, false)
	
	}
}




Mobile.closeApplication()
