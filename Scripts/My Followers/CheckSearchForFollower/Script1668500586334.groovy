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

Mobile.callTestCase(findTestCase('Login/MyAccount_Login'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.scrollToText('المتابِعون')

Mobile.tap(findTestObject('Followers/MyAccount_FollowersBtn'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Followers/Search_Followers'), 0, FailureHandling.STOP_ON_FAILURE)


// Get random followers names from API
GetFollowers_NamesAPI = WS.sendRequest(findTestObject('GrtFollowers'))

def slurper = new JsonSlurper()

def result = slurper.parseText(GetFollowers_NamesAPI.getResponseBodyContent())

def Followe1_NameAPI = result.result.data.followers[0].name
def Followe2_NameAPI = result.result.data.followers[1].name
def Followe3_NameAPI = result.result.data.followers[2].name
def Followe4_NameAPI = result.result.data.followers[3].name
def Followe5_NameAPI = result.result.data.followers[4].name
def Followe6_NameAPI = result.result.data.followers[5].name
def Followe7_NameAPI = result.result.data.followers[6].name


Followe1_NameAPI=Followe1_NameAPI.toString()
Followe2_NameAPI=Followe2_NameAPI.toString()
Followe3_NameAPI=Followe3_NameAPI.toString()
Followe4_NameAPI=Followe4_NameAPI.toString()
Followe5_NameAPI=Followe5_NameAPI.toString()
Followe6_NameAPI=Followe6_NameAPI.toString()
Followe7_NameAPI=Followe7_NameAPI.toString()

def RendomName_APIValue=[Followe1_NameAPI,Followe2_NameAPI,Followe3_NameAPI,Followe4_NameAPI,Followe5_NameAPI,Followe6_NameAPI,Followe7_NameAPI]

Random test = new Random();

int Rand_item = test.nextInt(RendomName_APIValue.size());

def searchvalue=RendomName_APIValue[Rand_item]

//Check value from app after search = value returned from API

Mobile.setText(findTestObject('MyFollowing/Search_Following'), searchvalue, 0)

def ReturnedUserName = Mobile.getText(findTestObject('Followers/NameForFollower'), 0, FailureHandling.STOP_ON_FAILURE)


Mobile.verifyMatch(searchvalue.toString(), ReturnedUserName.toString(), false)

println('Value from API : '+searchvalue+'Equal value from App : '+ReturnedUserName)