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

Mobile.callTestCase(findTestCase('Login/MyAccount_Login'), [:], FailureHandling.STOP_ON_FAILURE)
Mobile.scrollToText('تقارير كارفاكس')


Mobile.tap(findTestObject('CarFax_MyAccount/GetCarFaxBtn_MyAccount'), 5, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementText(findTestObject('CarFax_Screens/CarsReports_CarFax'), 'تقارير السيارات', FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementText(findTestObject('CarFax_Screens/YouDontHaveReports_Txt'), 'لا يوجد لديك تقارير', FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementText(findTestObject('CarFax_Screens/EmptyCarFaxTxt_CarFax'), 'تقارير السيارات فارغة', FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementText(findTestObject('CarFax_Screens/RequestCarFaxTxt_CarFax'), 'اطلب تقرير للسيارة التي تريد شرائها', FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementExist(findTestObject('CarFax_Screens/RequestBtn_CarFax'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()