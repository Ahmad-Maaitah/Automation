import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import java.util.concurrent.TimeUnit as TimeUnit
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
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.AppiumDriver as AppiumDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

Mobile.startApplication('C:\\Users\\Admin\\Downloads\\9.2.3.apk', true)

Mobile.tap(findTestObject('Valid login and Click on Add post button/Iraq Country'), 30)
Mobile.tap(findTestObject('Valid login and Click on Add post button/Addpost icone'), 30)
Mobile.tap(findTestObject('Valid login and Click on Add post button/Change Country'), 30)

Mobile.tap(findTestObject('Valid login and Click on Add post button/Jordan Country'), 30)

Mobile.setText(findTestObject('Valid login and Click on Add post button/Phone2'), '0703213212', 30)

Mobile.tap(findTestObject('Valid login and Click on Add post button/Nextphone'), 30)

Mobile.setEncryptedText(findTestObject('Valid login and Click on Add post button/Password2'), 'tnXB1jbPNDAOVoUnr2O+7A==', 
    30)

Mobile.tap(findTestObject('Valid login and Click on Add post button/Nextbutton'), 30)

Mobile.tap(findTestObject('Valid login and Click on Add post button/Nextbuttonafterfill'), 30)

