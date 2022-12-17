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
import groovy.json.JsonSlurper
import com.kms.katalon.core.util.KeywordUtil

// Make sure the returned value from API = Returned value in my account details
Mobile.callTestCase(findTestCase('Login/MyAccount_Login'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('AcountDetails/AccountDetails_Button'), 0, FailureHandling.STOP_ON_FAILURE)

def PaidAds_AccountDeatils = Mobile.getText(findTestObject('AcountDetails/PaidAds_Value'), 0, FailureHandling.STOP_ON_FAILURE)


// Get Paid Ads from API
Thread.sleep(500)

ActiveAdsValue = WS.sendRequest(findTestObject('GetMyPaidAds'))

def slurper = new JsonSlurper()

def result = slurper.parseText(ActiveAdsValue.getResponseBodyContent())

def PaidAdsNumber = result._meta.totalCount


//Check value from My account == API value
if (PaidAdsNumber.toString().equals(PaidAds_AccountDeatils)) {
    println((('Correct >> value exact with value in My ads screen || Value in My ads=' + PaidAds_AccountDeatils) + ' Value in my account details=') + 
        PaidAdsNumber)
} else {
   
	throw new Exception('Not Correct >> value not equal the value in My ads screen || Value in My ads=' + PaidAds_AccountDeatils + 
        ' Value in my account details=' + PaidAdsNumber)
	
}

Mobile.closeApplication()

