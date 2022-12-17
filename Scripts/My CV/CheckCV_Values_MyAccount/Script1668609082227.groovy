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

Mobile.scrollToText('السيرة الذاتية')

def CVPercentage_App = Mobile.getText(findTestObject('JobProfile MyAccount/CV_Percentage_MYAccount'), 0, FailureHandling.STOP_ON_FAILURE)

CVPercentage_App = CVPercentage_App.replaceAll('%+', '')

CVPercentage_App = CVPercentage_App.toInteger()

CVPercentage_App = CVPercentage_App.toString()

def CV_ViewsValue_App = Mobile.getText(findTestObject('JobProfile MyAccount/CV_ViewsValue_MYAccount'), 0, FailureHandling.STOP_ON_FAILURE)

def CV_ApplicationsValue_App = Mobile.getText(findTestObject('JobProfile MyAccount/CV_ApplicationsValue_MYAccount'), 0, 
    FailureHandling.STOP_ON_FAILURE)

// GET value from CV API 
GetCVPercentage_API = WS.sendRequestAndVerify(findTestObject('CV_completeness'))

def slurper = new JsonSlurper()

def result = slurper.parseText(GetCVPercentage_API.getResponseBodyContent())

def CV_PercentageValue_API = result.result.data.score

// GET value from Members API
GetMemberValues_API = WS.sendRequestAndVerify(findTestObject('APIs/GetCvViewsAndApplications'))

def slurperJobs = new JsonSlurper()

def resultJobs = slurperJobs.parseText(GetMemberValues_API.getResponseBodyContent())

def CV_ViewsValue_API = resultJobs.result.data.cv.views_count

def CV_ApplicationsValue_API = resultJobs.result.data.cv.applied_jobs_count

//Check returned value from APP = value returned from API
Mobile.verifyEqual(CVPercentage_App.toString(), CV_PercentageValue_API.toString(), FailureHandling.STOP_ON_FAILURE)

Mobile.verifyEqual(CV_ViewsValue_App.toString(), CV_ViewsValue_API.toString(), FailureHandling.STOP_ON_FAILURE)

Mobile.verifyEqual(CV_ApplicationsValue_App.toString(), CV_ApplicationsValue_API.toString(), FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

