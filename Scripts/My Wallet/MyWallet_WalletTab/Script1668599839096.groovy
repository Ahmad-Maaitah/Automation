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
Mobile.tap(findTestObject('My Wallet/OpenWalletBtn_MyAccount'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementText(findTestObject('My Wallet/CurrentBalance_Text'), 'الرصيد المتوفر')

def GetWalletValue_MyWallet = Mobile.getText(findTestObject('My Wallet/CreditValue_MyWallet'), 0,FailureHandling.STOP_ON_FAILURE)
GetWalletValue_MyWallet=GetWalletValue_MyWallet.toString()

//Get value for credit from API
WalletValue_MyWallet_API = WS.sendRequest(findTestObject('GetMemberWallet'))

def slurper = new JsonSlurper()

def result = slurper.parseText(WalletValue_MyWallet_API.getResponseBodyContent())

def MidCreditValue_Mywallet_API = result.localBalance
MidCreditValue_Mywallet_API=MidCreditValue_Mywallet_API.toString()

//Compare values API and APP
//Credit
//Mobile.verifyEqual(GetWalletValue_MyWallet.toString(), MidCreditValue_Mywallet_API.toString(), FailureHandling.STOP_ON_FAILURE)
if (GetWalletValue_MyWallet.contains(MidCreditValue_Mywallet_API)) {
	println((('Value for credit from my wallet ' + GetWalletValue_MyWallet) + ' Equal value returned from API ') + MidCreditValue_Mywallet_API)
} else {
	throw new Exception((('Value for credit from my wallet ' + GetWalletValue_MyWallet) + 'Not Equal value returned from API ') + MidCreditValue_Mywallet_API)
}

Mobile.closeApplication()