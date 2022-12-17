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

//Call login 
Mobile.callTestCase(findTestCase('Login/MyAccount_Login'), [:], FailureHandling.STOP_ON_FAILURE)

//Thread.sleep(10)

//Verify values from my account
def UserViewsNum_MyAccount = Mobile.getText(findTestObject('Views/GetViewsValue_MyAccount'), 10, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementText(findTestObject('Views/ViewText_MyAccount'), 'المشاهدات', FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementExist(findTestObject('Views/GoToViewsBtn_MyAccount'), 0, FailureHandling.STOP_ON_FAILURE)
UserViewsNum_MyAccount =UserViewsNum_MyAccount.replaceAll(",", "")

//Get values from API
GetUserViews_API = WS.sendRequest(findTestObject('APIs/GetUserViews'))

def slurper = new JsonSlurper()
def result = slurper.parseText(GetUserViews_API.getResponseBodyContent())
def UserAccountViews_API = result.viewsCountTotal
def UserAdsViews_API = result.postCountTotal
def UserCvViews_API = result.cvCountTotal
def UserTotalViews_API=UserAccountViews_API+UserAdsViews_API

//Check values from App = Values from API
Mobile.verifyMatch(UserViewsNum_MyAccount.toString(), UserTotalViews_API.toString(), false)
Mobile.closeApplication()
