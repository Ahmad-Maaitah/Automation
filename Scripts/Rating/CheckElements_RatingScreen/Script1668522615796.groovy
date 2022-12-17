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

Mobile.tap(findTestObject('Rating/RatingButton_MyAccount'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementText(findTestObject('Rating/RatingAndCommentsText_RatingScreen'), 'التقييم و التعليقات')
Mobile.verifyElementText(findTestObject('Rating/RatingText_RatingScreen'), 'التقييم')
Mobile.verifyElementText(findTestObject('Rating/RatingAvg'), 'متوسط التقييم:')


Mobile.verifyElementText(findTestObject('Rating/FiveStars_Text'), '5 نجوم')
Mobile.verifyElementText(findTestObject('Rating/FourStars_Text'), '4 نجوم')
Mobile.verifyElementText(findTestObject('Rating/ThreeStars_Text'), '3 نجوم')
Mobile.verifyElementText(findTestObject('Rating/TwoStars_Text'), 'نجمتان')
Mobile.verifyElementText(findTestObject('Rating/OneStars_Text'), 'نجمة')

//Get value from app

def Value_5stars_App = Mobile.getText(findTestObject('Rating/FiveStars_Value'), 0, FailureHandling.STOP_ON_FAILURE)
def Value_4stars_App = Mobile.getText(findTestObject('Rating/FourStars_Value'), 0, FailureHandling.STOP_ON_FAILURE)
def Value_3stars_App = Mobile.getText(findTestObject('Rating/ThreeStars_Value'), 0, FailureHandling.STOP_ON_FAILURE)
def Value_2stars_App = Mobile.getText(findTestObject('Rating/TwoStars_Value'), 0, FailureHandling.STOP_ON_FAILURE)
def Value_1stars_App = Mobile.getText(findTestObject('Rating/OneStars_Value'), 0, FailureHandling.STOP_ON_FAILURE)


//Get value from API

RatingValues_API = WS.sendRequest(findTestObject('GetMemberRating'))

def slurper = new JsonSlurper()

def result = slurper.parseText(RatingValues_API.getResponseBodyContent())

def Rating_5_StarsValue = result.result.data.stats.n_star_5_percentage
def Rating_4_StarsValue = result.result.data.stats.n_star_4_percentage
def Rating_3_StarsValue = result.result.data.stats.n_star_3_percentage
def Rating_2_StarsValue = result.result.data.stats.n_star_2_percentage
def Rating_1_StarsValue = result.result.data.stats.n_star_1_percentage


//Compare values API and APP

//5 Stars 
if (Value_5stars_App.toString().contains(Rating_5_StarsValue.toString())) {
    println((('Correct >> 5 stars value from app' + Value_5stars_App) + ' Equal API value') + Rating_5_StarsValue)
} else {
    throw new Exception((('Not Correct >> 5 stars value from app' + Value_5stars_App) + ' Not equal') + Rating_5_StarsValue)
}

//4 Stars
if (Value_4stars_App.toString().contains(Rating_4_StarsValue.toString())) {
	println((('Correct >> 4 stars value from app' + Value_4stars_App) + ' Equal API value') + Rating_4_StarsValue)
} else {
	throw new Exception((('Not Correct >> 4 stars value from app' + Value_4stars_App) + ' Not equal') + Rating_4_StarsValue)
}

//3 Stars
if (Value_3stars_App.toString().contains(Rating_3_StarsValue.toString())) {
	println((('Correct >> 3 stars value from app' + Value_3stars_App) + ' Equal API value') + Rating_3_StarsValue)
} else {
	throw new Exception((('Not Correct >> 3 stars value from app' + Value_3stars_App) + ' Not equal') + Rating_3_StarsValue)
}

//2 Stars
if (Value_2stars_App.toString().contains(Rating_2_StarsValue.toString())) {
	println((('Correct >> 2 stars value from app' + Value_2stars_App) + ' Equal API value') + Rating_2_StarsValue)
} else {
	throw new Exception((('Not Correct >> 2 stars value from app' + Value_2stars_App) + ' Not equal') + Rating_2_StarsValue)
}

//1 Stars
if (Value_1stars_App.toString().contains(Rating_1_StarsValue.toString())) {
	println((('Correct >> 1 stars value from app' + Value_1stars_App) + ' Equal API value') + Rating_1_StarsValue)
} else {
	throw new Exception((('Not Correct >> 1 stars value from app' + Value_1stars_App) + ' Not equal') + Rating_1_StarsValue)
}

Mobile.closeApplication()

