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

Mobile.tap(findTestObject('MyFollowing/FollowingBtn_MyAccount'), 0, FailureHandling.STOP_ON_FAILURE)


// Get random followers names from API
GetFollowing_RandomNamesAPI = WS.sendRequest(findTestObject('GetFollowings'))

def slurper = new JsonSlurper()

def result = slurper.parseText(GetFollowing_RandomNamesAPI.getResponseBodyContent())

def Following1_NameAPI = result.result.data.followings[0].name
def Following2_NameAPI = result.result.data.followings[2].name
def Following3_NameAPI = result.result.data.followings[4].name
def Following4_NameAPI = result.result.data.followings[7].name
def Following5_NameAPI = result.result.data.followings[9].name
def Following6_NameAPI = result.result.data.followings[10].name


Following1_NameAPI=Following1_NameAPI.toString()
Following2_NameAPI=Following2_NameAPI.toString()
Following3_NameAPI=Following3_NameAPI.toString()
Following4_NameAPI=Following4_NameAPI.toString()
Following5_NameAPI=Following5_NameAPI.toString()
Following6_NameAPI=Following6_NameAPI.toString()

def RendomName_APIValue=[Following1_NameAPI,Following2_NameAPI,Following3_NameAPI,Following4_NameAPI,Following5_NameAPI,Following6_NameAPI]

Random test = new Random();

int Rand_item = test.nextInt(RendomName_APIValue.size());

def searchvalue=RendomName_APIValue[Rand_item]

//Check value from app after search = value returned from API

Mobile.tap(findTestObject('MyFollowing/Search_Following'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.setText(findTestObject('MyFollowing/Search_Following'), searchvalue, 0)

def ReturnedUserName = Mobile.getText(findTestObject('MyFollowing/FollowingName'), 0, FailureHandling.STOP_ON_FAILURE)


Mobile.verifyMatch(searchvalue.toString(), ReturnedUserName.toString(), false)

println('Value from API : '+searchvalue+'Equal value from App : '+ReturnedUserName)

Mobile.closeApplication()

