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

Mobile.callTestCase(findTestCase('Login/MyAccount_Login'), [:], FailureHandling.STOP_ON_FAILURE)

def GetValueOfRating_MyAccount = Mobile.getText(findTestObject('Rating/RatingValue_MyAccount'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementText(findTestObject('Rating/RatingText_MyAccount'), 'التقييم')

//Get value from API

RatingValue_API = WS.sendRequest(findTestObject('GetMemberRating'))

def slurper = new JsonSlurper()

def result = slurper.parseText(RatingValue_API.getResponseBodyContent())

def RatingValue_API = result.result.data.stats.average_star

//Compare values API and APP

Mobile.verifyEqual(GetValueOfRating_MyAccount.toString(), RatingValue_API.toString(), FailureHandling.STOP_ON_FAILURE)

println((('Value for rating from my account ' + GetValueOfRating_MyAccount) + ' Equal value returned from API ') + RatingValue_API)

Mobile.closeApplication()

