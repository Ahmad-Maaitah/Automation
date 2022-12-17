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

def GetValueOfCredit_MyAccount = Mobile.getText(findTestObject('My Wallet/CreditValue_MyAccount'), 0, FailureHandling.STOP_ON_FAILURE)

def GetValueOfBundle_MyAccount = Mobile.getText(findTestObject('My Wallet/BundlesValue_MyAccount'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementText(findTestObject('My Wallet/WalletText_MyAccount'), 'المحفظة')

Mobile.verifyElementText(findTestObject('My Wallet/AddCreditText_MyAccount'), '• أضف رصيد أو اشحن بطاقة لتعبئة الرصيد')

Mobile.verifyElementText(findTestObject('My Wallet/CreditText_MyAccount'), 'الرصيد')

Mobile.verifyElementText(findTestObject('Object Repository/My Wallet/BundlesText_MyAccount'), 'الباقات')

Mobile.verifyElementExist(findTestObject('My Wallet/OpenWalletBtn_MyAccount'), 0, FailureHandling.STOP_ON_FAILURE)

//Get value for credit from API
WalletValue_API = WS.sendRequest(findTestObject('GetMemberWallet'))

def slurper = new JsonSlurper()

def result = slurper.parseText(WalletValue_API.getResponseBodyContent())

def MidCreditValue_API = result.localBalance

//Get value for bundles from API
BundleValue_API = WS.sendRequest(findTestObject('GetMemberBundleCount'))

def slurperBundle = new JsonSlurper()

def resultBundle = slurperBundle.parseText(BundleValue_API.getResponseBodyContent())

def MidBundleValue_API = resultBundle.result.data.bundle_count

//Compare values API and APP
//Credit
Mobile.verifyEqual(GetValueOfCredit_MyAccount.toString(), MidCreditValue_API.toString(), FailureHandling.STOP_ON_FAILURE)

println((('Value for credit from my account ' + GetValueOfCredit_MyAccount) + ' Equal value returned from API ') + MidCreditValue_API)

//Bundle
Mobile.verifyEqual(GetValueOfBundle_MyAccount.toString(), MidBundleValue_API.toString(), FailureHandling.STOP_ON_FAILURE)

println((('Value for Bundle from my account ' + GetValueOfBundle_MyAccount) + ' Equal value returned from API ') + MidBundleValue_API)

Mobile.closeApplication()

