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

//Go to my account
Mobile.callTestCase(findTestCase('SplashScreen_Countries/SplashScreen'), [:], FailureHandling.STOP_ON_FAILURE)

Thread.sleep(10)

Mobile.tap(findTestObject('Login_MyAccount/Account2'), 30)

Mobile.scrollToText('اتصل بنا')

Mobile.tap(findTestObject('ContactUs/ContactUsBtn_MyAccount'), 5, FailureHandling.STOP_ON_FAILURE)

//Check All elements exist
Mobile.verifyElementText(findTestObject('ContactUs/ContactUSTxt_Feedback'), 'تواصل معنا', FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('ContactUs/NameField_Feedback'), 5, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementExist(findTestObject('ContactUs/PhoneNum_FeedBack'), 5, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementExist(findTestObject('ContactUs/EmailField_Feedback'), 5, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementExist(findTestObject('ContactUs/Category_Feedback'), 5, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementExist(findTestObject('ContactUs/SendYourIssueField_FeedBack'), 5, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementExist(findTestObject('ContactUs/SendBtn_Feedback'), 5, FailureHandling.STOP_ON_FAILURE)
Mobile.scrollToText('jo@opensooq.com')
Mobile.verifyElementText(findTestObject('ContactUs/OrContactTxt_feedback'), 'أو يمكنك التواصل معنا على ما يلي', FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementText(findTestObject('ContactUs/Location_FeedBack'), 'شارع مكة المكرمة، أبراج الحجاز، عمارة رقم 158 - مكتب رقم 701 عمان، الأردن', FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementText(findTestObject('ContactUs/EmailValue_FeedBack'), 'jo@opensooq.com', FailureHandling.STOP_ON_FAILURE)
Mobile.scrollToText('ساعات العمل')
Mobile.verifyElementText(findTestObject('ContactUs/WorkingHours_feedBack'), 'ساعات العمل من الأحد إلى الخميس، الساعة 9:00 صباحاً - 6:00 مساءً', FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementExist(findTestObject('ContactUs/ContactUSTxt_Feedback'), 5, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementExist(findTestObject('ContactUs/ContactWA_Feedback'), 5, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementExist(findTestObject('ContactUs/LocationMap_Feedback'), 5, FailureHandling.STOP_ON_FAILURE)

//Close the app
Mobile.closeApplication()

