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

def GetValueOfMID_MyAccount = Mobile.getText(findTestObject('AcountDetails/MIDValue_MyAccount'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementText(findTestObject('AcountDetails/MIDText_MyAccount'), 'رقم العضوية')

Mobile.verifyElementExist(findTestObject('AcountDetails/AccountDeatils_Btn_Myaccount'), 0, FailureHandling.STOP_ON_FAILURE)

//Get value for credit from API
MIDValue_API = WS.sendRequest(findTestObject('GetUserAccountInfo'))

def slurper = new JsonSlurper()

def result = slurper.parseText(MIDValue_API.getResponseBodyContent())

def Mid_API = result.result.data.id

//Compare values API and APP
Mobile.verifyEqual(GetValueOfMID_MyAccount.toString(), Mid_API.toString(), FailureHandling.STOP_ON_FAILURE)

println((('Value for Member ID from my account ' + GetValueOfMID_MyAccount) + ' Equal value returned from API ') + Mid_API)

Mobile.closeApplication()

