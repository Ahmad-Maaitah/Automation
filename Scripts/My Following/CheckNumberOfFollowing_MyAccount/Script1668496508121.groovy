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

Mobile.callTestCase(findTestCase('Login/DynamicUser'), [('userPhone') : '0701991988', ('userPass') : '111111'], FailureHandling.STOP_ON_FAILURE)

Mobile.scrollToText('المتابِعون')

def GetValueOfFollowings_MyAccount = Mobile.getText(findTestObject('MyFollowing/NmberOfFollowing_MyAccount'), 0, FailureHandling.STOP_ON_FAILURE)

println('>>>>>>..............' + GetValueOfFollowings_MyAccount)

//GetValueOfFollowings_MyAccount = GetValueOfFollowings_MyAccount.toString()
//Get value from API
FollowersCount_API = WS.sendRequest(findTestObject('APIs/GetFollowingsNumcer_Myaccount'))

def slurper = new JsonSlurper()

def result = slurper.parseText(FollowersCount_API.getResponseBodyContent())

def Valuefollowings_API = result.result.data.count

//Valuefollowings_API = Valuefollowings_API.toString()
Mobile.verifyEqual(GetValueOfFollowings_MyAccount.toString(), Valuefollowings_API.toString(), FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

