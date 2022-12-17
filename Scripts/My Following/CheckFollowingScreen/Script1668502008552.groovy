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

Mobile.scrollToText('المتابِعون')

Mobile.tap(findTestObject('MyFollowing/FollowingBtn_MyAccount'), 0, FailureHandling.STOP_ON_FAILURE)

def FollowingText_Value = Mobile.getText(findTestObject('MyFollowing/FollowingText'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementText(findTestObject('MyFollowing/FollowingText'), 'المتابَعون')

def Following2 = Mobile.getText(findTestObject('MyFollowing/FollowingName'), 0, FailureHandling.STOP_ON_FAILURE)

Following2 = Following2.toString()

//Get value from API
GetFollowing_Names = WS.sendRequest(findTestObject('GetFollowings'))

def slurper = new JsonSlurper()

def result = slurper.parseText(GetFollowing_Names.getResponseBodyContent())

def Following2Value_API = result.result.data.followings[0].name

//Compare values API and APP
Mobile.verifyEqual(Following2.toString(), Following2Value_API.toString(), FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

