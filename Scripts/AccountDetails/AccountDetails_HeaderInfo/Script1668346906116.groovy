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
import groovy.json.JsonSlurper as JsonSlurper
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

// Make sure the returned value from API = Returned value in my account details 
Mobile.callTestCase(findTestCase('Login/MyAccount_Login'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('AcountDetails/AccountDetails_Button'), 0, FailureHandling.STOP_ON_FAILURE)

def AdsLimitValue_Header = Mobile.getText(findTestObject('AcountDetails/LimitActiveAds_Value'), 0)
def ActiveAdsValue_Header = Mobile.getText(findTestObject('AcountDetails/ActiveAds_Header'), 0)
def RemainingAdsValue_Header = Mobile.getText(findTestObject('AcountDetails/RemainingAds_Header'), 0)
def AccountAdsLimit_Header = Mobile.getText(findTestObject('AcountDetails/AccountAdsLimit_Header'), 0)


AdsLimitValue_Header=AdsLimitValue_Header.toInteger()
ActiveAdsValue_Header=ActiveAdsValue_Header.toInteger()
RemainingAdsValue_Header=RemainingAdsValue_Header.toInteger()
AccountAdsLimit_Header=AccountAdsLimit_Header.toInteger()

if(RemainingAdsValue_Header==(AccountAdsLimit_Header-ActiveAdsValue_Header)) {
	println('Value for remaining Ads correct')
}else {
	 throw new Exception('Not Correct >> value for remaining ads not correct')
	
}