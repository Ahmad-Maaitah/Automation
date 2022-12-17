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

Mobile.callTestCase(findTestCase('Login/MyAccount_Login'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.scrollToText('إشتري الآن')

Mobile.tap(findTestObject('HideAds_Screen/GoToHideAds_MyAccount'), 5, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('HideAds_Screen/XBtn_HideAds'), 10, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('HideAds_Screen/GoOpensooqPlusBtn_HideAds'), 5, FailureHandling.STOP_ON_FAILURE)

//Get values from app
def OSPlus_3MText = Mobile.getText(findTestObject('HideAds_Screen/3MText_OSPlusPayment'), 5, FailureHandling.STOP_ON_FAILURE)

def OSPlus_6MText = Mobile.getText(findTestObject('HideAds_Screen/6MText_OSPlusPayment'), 5, FailureHandling.STOP_ON_FAILURE)

def OSPlus_12MText = Mobile.getText(findTestObject('HideAds_Screen/12MText_OSPlusPayment'), 5, FailureHandling.STOP_ON_FAILURE)

def OSPlus_3MValue = Mobile.getText(findTestObject('HideAds_Screen/3MValue_OSPlusPayment'), 5, FailureHandling.STOP_ON_FAILURE)

def OSPlus_6MValue = Mobile.getText(findTestObject('HideAds_Screen/6MValue_OSPlusPayment'), 5, FailureHandling.STOP_ON_FAILURE)

def OSPlus_12MValue = Mobile.getText(findTestObject('HideAds_Screen/12MValue_OSPlusPayment'), 5, FailureHandling.STOP_ON_FAILURE)

println((((('>>>>>>>>>>>>' + OSPlus_3MText) + '>>>>>') + OSPlus_6MText) + '>>>') + OSPlus_12MText)

println((((('>>>>>>>>>>>>' + OSPlus_3MValue) + '>>>>>') + OSPlus_6MValue) + '>>>') + OSPlus_12MValue)


//def OSPlus6MValue_API = result.result.data[1].point
GetUserViews_API = WS.sendRequest(findTestObject('APIs/GetOpensooqPlusPackages'))

def slurper = new JsonSlurper()

def result = slurper.parseText(GetUserViews_API.getResponseBodyContent())

def UserAccountViews_API = result.viewsCountTotal

println('>>>>>>>>>>>>' + result)


def OSPlus3MValue_API = result[0].countryPrice

def OSPlus6MValue_API = result[1].countryPrice

def OSPlus12MValue_API = result[2].countryPrice

//Check values from App = Values from API
Mobile.verifyMatch(OSPlus_3MValue.toString(), OSPlus3MValue_API.toString(), false)

Mobile.verifyMatch(OSPlus_6MValue.toString(), OSPlus6MValue_API.toString(), false)

Mobile.verifyMatch(OSPlus_12MValue.toString(), OSPlus12MValue_API.toString(), false)

Mobile.closeApplication()

