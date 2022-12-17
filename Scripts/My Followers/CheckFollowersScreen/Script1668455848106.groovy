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

Mobile.tap(findTestObject('Followers/MyAccount_FollowersBtn'), 0, FailureHandling.STOP_ON_FAILURE)

def FollowesText_Value = Mobile.getText(findTestObject('Object Repository/Followers/FollowersText'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementText(findTestObject('Followers/FollowersText'), 'المتابِعون')

def Follower2 = Mobile.getText(findTestObject('Followers/Folloer2_FollowersScreen'), 0, FailureHandling.STOP_ON_FAILURE)

Follower2 = Follower2.toString()

//Get value from API

GetFollowers_Names = WS.sendRequest(findTestObject('GrtFollowers'))

def slurper = new JsonSlurper()

def result = slurper.parseText(GetFollowers_Names.getResponseBodyContent())

def Follower2Value_API = result.result.data.followers[1].name

//Compare values API and APP

Mobile.verifyEqual(Follower2.toString(), Follower2Value_API.toString(), FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

