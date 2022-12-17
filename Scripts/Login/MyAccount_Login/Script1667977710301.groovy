import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileAbstractKeyword as MobileAbstractKeyword
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
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.AppiumDriver as AppiumDriver

Mobile.callTestCase(findTestCase('SplashScreen_Countries/SplashScreen'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Login_MyAccount/Account2'), 30)

Thread.sleep(10)

//Mobile.tap(findTestObject('BottomBar/AccountBtn_BottomBar'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.tap(findTestObject('Login_MyAccount/LoginButton'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Login_MyAccount/PhoneNumber_TextField'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.setText(findTestObject('Login_MyAccount/PhoneNumber_TextField'), '0701991995', 0)

Mobile.tap(findTestObject('Login_MyAccount/NexButton_PhoneStep'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.setEncryptedText(findTestObject('Login_MyAccount/Password_TextField'), 'aeHFOx8jV/A=', 0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Login_MyAccount/NextButton_PassStep'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Login_MyAccount/Continue_SuccessScreen'), 0, FailureHandling.STOP_ON_FAILURE)

