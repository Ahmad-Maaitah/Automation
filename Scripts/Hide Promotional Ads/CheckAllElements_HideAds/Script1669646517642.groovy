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
Mobile.scrollToText('إشتري الآن')

Mobile.tap(findTestObject('HideAds_Screen/GoToHideAds_MyAccount'), 5, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementExist(findTestObject('HideAds_Screen/XBtn_HideAds'), 10, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementText(findTestObject('HideAds_Screen/OpensooqPlusTxt_HideAds'), 'السوق المفتوح بلس +', FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementText(findTestObject('HideAds_Screen/RecentlyViewdAdsTxt_HideAds'), 'آخر الإعلانات المشاهدة', FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementText(findTestObject('HideAds_Screen/RecentlyViewdAdsInfo_HideAds'), 'تمكن من الرجوع لآخر ٣٠٠ إعلان مشاهد، لا تضيع أي لُقطة', FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementText(findTestObject('HideAds_Screen/RecentlySearchAdsTxt_HideAds'), 'آخر عمليات البحث', FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementText(findTestObject('HideAds_Screen/RecentlySearchAdsInfo_HideAds'), 'اذهب بدون عناء لآخر البحوث، فعل التنبيه لتكن أول من يعلم', FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementText(findTestObject('HideAds_Screen/HideAdsTxt_HideAds'), 'إخفاء الإعلانات التجارية', FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementText(findTestObject('HideAds_Screen/HideAdsInfo_HideAds'), 'تمتع بالسوق المفتوح بدون إعلانات تجارية', FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementText(findTestObject('HideAds_Screen/FeatureByOSPlusTxt_HideAds'), 'تميز بوسام بلس+', FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementText(findTestObject('HideAds_Screen/FeatureByOSPlusInfo_HideAds'), 'اربح ثقة المستخدمين الآخرين بوسام بلس+', FailureHandling.STOP_ON_FAILURE)

//Close the app
Mobile.closeApplication()