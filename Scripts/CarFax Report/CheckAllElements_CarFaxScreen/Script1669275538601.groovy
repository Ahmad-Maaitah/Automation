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
Mobile.tap(findTestObject('CarFax_Screens/RequestBtn_CarFax'), 5, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('CarFax_Screens/VINField_CarFax'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.hideKeyboard()
Mobile.verifyElementExist(findTestObject('CarFax_Screens/WhereVIN_Link'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementExist(findTestObject('CarFax_Screens/HelpLink_CarFax'), 0, FailureHandling.STOP_ON_FAILURE)


Mobile.scrollToText('احصل على جميع المعلومات')
Mobile.verifyElementExist(findTestObject('CarFax_Screens/CarFaxInfo_Txt_CarFax'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementText(findTestObject('CarFax_Screens/AccidentsTxt_CarFax'), 'الحوادث', FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementText(findTestObject('CarFax_Screens/MaintenanceTxt_CarFax'), 'الصيانة', FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementText(findTestObject('CarFax_Screens/MilageTxt_CarFax'), 'الممشى', FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementText(findTestObject('CarFax_Screens/DrowingTxt_CarFax'), 'الغرق', FailureHandling.STOP_ON_FAILURE)
Mobile.scrollToText('الحريق')
Mobile.verifyElementText(findTestObject('CarFax_Screens/FireTxt_CarFax'), 'الحريق', FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementText(findTestObject('CarFax_Screens/TheftTxt_CarFax'), 'السرقة', FailureHandling.STOP_ON_FAILURE)


Mobile.closeApplication()
