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

// Make sure the returned value from API = Returned value in my account details

Mobile.callTestCase(findTestCase('Login/MyAccount_Login'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('AcountDetails/AccountDetails_Button'), 5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('AcountDetails/UpgradeAccount_Header'), 5, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('UpdateAccount_Packages/UpdateYourAccount_Text'), 5, FailureHandling.STOP_ON_FAILURE)
def UpdateYourAccount = Mobile.getText(findTestObject('UpdateAccount_Packages/UpdateYourAccount_Text'), 5, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('UpdateAccount_Packages/SelectAccountType_Text'), 5, FailureHandling.STOP_ON_FAILURE)
def SelectAccountType = Mobile.getText(findTestObject('UpdateAccount_Packages/SelectAccountType_Text'), 5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('UpdateAccount_Packages/ShopPackages_Button'), 5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('UpdateAccount_Packages/GoldPackages_Button'), 5, FailureHandling.STOP_ON_FAILURE)


Mobile.verifyElementExist(findTestObject('UpdateAccount_Packages/NumberOFActiveAds_Text'), 5, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementExist(findTestObject('UpdateAccount_Packages/StatisticsDashbord_Text'), 5, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementExist(findTestObject('UpdateAccount_Packages/OpensooqLink_Text'), 5, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementExist(findTestObject('UpdateAccount_Packages/LeadsDetails_Text'), 5, FailureHandling.STOP_ON_FAILURE)
Mobile.scrollToText('الإعلانات المشابهة')

Mobile.verifyElementExist(findTestObject('UpdateAccount_Packages/SimilarListings_Text'), 5, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementExist(findTestObject('UpdateAccount_Packages/PromotedOnOpensooq_Text'), 5, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementExist(findTestObject('UpdateAccount_Packages/ShopsPage_Text'), 5, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementExist(findTestObject('UpdateAccount_Packages/LogoOnListings_Text'), 5, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementExist(findTestObject('UpdateAccount_Packages/FreeDesign_Text'), 5, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementExist(findTestObject('UpdateAccount_Packages/DedicatedAccountManager_Text'), 5, FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()
