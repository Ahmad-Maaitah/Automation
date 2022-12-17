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

Mobile.tap(findTestObject('NeedHelp_MyAccount/Quastions_MyAccount'), 5, FailureHandling.STOP_ON_FAILURE)
 
//Check all elements(Quastions) Exist


Mobile.verifyElementText(findTestObject('Questions/ContactUsTxt_Question'), 'تواصل معنا', FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementText(findTestObject('Questions/StartWithOSTxt_Questions'), 'إبدأ مع السوق المفتوح', FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementText(findTestObject('Questions/ConditionsTxt_Questions'), 'الشروط والأحكام', FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementText(findTestObject('Questions/PaymentOptTxt_Questions'), 'خيارات الدفع', FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementText(findTestObject('Questions/MyAccountTxt_Questions'), 'حسابي', FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementText(findTestObject('Questions/MyAdsTxt_Questions'), 'إعلاناتي', FailureHandling.STOP_ON_FAILURE)


Mobile.verifyElementText(findTestObject('Questions/FeaturedArticlesTxt_Question'), 'مقالات مميزة', FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Questions/Q1_Quastions'), 5, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementExist(findTestObject('Questions/Q2_Quastions'), 5, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementExist(findTestObject('Questions/Q3_Quastions'), 5, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementExist(findTestObject('Questions/Q4_Questions'), 5, FailureHandling.STOP_ON_FAILURE)

Mobile.scrollToText('هل النشر مدفوع؟')
Mobile.verifyElementExist(findTestObject('Questions/Q5_Quastions'), 5, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementExist(findTestObject('Questions/MoreHelpTxt_Quastions'), 5, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementExist(findTestObject('Questions/ContactUsBtn_Quastions'), 5, FailureHandling.STOP_ON_FAILURE)

//Close the app
Mobile.closeApplication()