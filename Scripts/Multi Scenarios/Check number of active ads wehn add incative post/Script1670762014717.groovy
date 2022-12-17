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
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.AppiumDriver as AppiumDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import java.util.concurrent.TimeUnit as TimeUnit

//Go to accoutn details to get the count before add post
WebUI.callTestCase(findTestCase('Login/MyAccount_Login'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('AcountDetails/AccountDetails_Button'), 0, FailureHandling.STOP_ON_FAILURE)

def ActiveAdsValue = Mobile.getText(findTestObject('AcountDetails/ActiveAds_Value'), 0, FailureHandling.STOP_ON_FAILURE)

ActiveAdsValue = ActiveAdsValue.toInteger()

//Add post 
Mobile.tap(findTestObject('Multi Scenarios/Back Button From Account'), 30)

Mobile.tap(findTestObject('Valid login and Click on Add post button/Addpost icone'), 30)

AppiumDriver<?> driver = MobileDriverFactory.getDriver()

driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS)

Mobile.tap(findTestObject('Car and bikes/Car And bikes Category'), 30)

Mobile.tap(findTestObject('Car for Rental/Car R sub'), 30)

Mobile.tap(findTestObject('Car and bikes/Next media step button'), 30)

Mobile.tap(findTestObject('Car and bikes/Next youtupe Screen'), 30)

WebUI.delay(2)

//Mobile.tap(findTestObject('Car and bikes/Car Make'), 30)

List CarMake = driver.findElementsByXPath('//androidx.recyclerview.widget.RecyclerView[1]/android.widget.FrameLayout/android.view.ViewGroup[1]/android.widget.TextView[1]')

def randomindex = Math.abs(new Random().nextInt() % [5]) + 0

CarMake.get(randomindex).click()

WebUI.delay(2)

//Mobile.tap(findTestObject('Car and bikes/Car Model'), 30)
List carrmake = driver.findElementsByXPath('//androidx.recyclerview.widget.RecyclerView[1]/android.widget.FrameLayout/android.view.ViewGroup[1]/android.widget.TextView[1]')

carrmake.get(randomindex).click()

WebUI.delay(2)

//Mobile.tap(findTestObject('Car and bikes/Car Year'), 30)
List carrmakev = driver.findElementsByXPath('//androidx.recyclerview.widget.RecyclerView[1]/android.widget.FrameLayout/android.view.ViewGroup[1]/android.widget.TextView[1]')

carrmakev.get(randomindex).click()

WebUI.delay(2)

Mobile.tap(findTestObject('Car and bikes/Type of transmission'), 30)

Mobile.tap(findTestObject('Car and bikes/type of fuel'), 30)

Mobile.tap(findTestObject('Car for Rental/Rental period'), 30)

Mobile.tap(findTestObject('Car and bikes/Color Car'), 30)

Mobile.tap(findTestObject('Car for Rental/Car R citty'), 30)

WebUI.delay(3)

Mobile.tap(findTestObject('Car for Rental/Car R area'), 30)

def Randomtext = new Random().with({ 
        (1..20).collect({ 
                ('a'..'z').join()[nextInt(('a'..'z').join().length())]
            }).join()
    })

def Randomtextt = new Random().with({ 
        (1..20).collect({ 
                ('a'..'z').join()[nextInt(('a'..'z').join().length())]
            }).join()
    })

Mobile.setText(findTestObject('Object Repository/Car and bikes/Add titile'), Randomtext, 30)

Mobile.tap(findTestObject('Car and bikes/Add des'), 30)

Mobile.setText(findTestObject('Object Repository/Car and bikes/Add des'), Randomtextt, 30)

Mobile.tap(findTestObject('Car and bikes/Exite button car for sale'), 30)

Mobile.tap(findTestObject('Car and bikes/Next Add ons'), 30)

Mobile.tap(findTestObject('Car and bikes/Next Add ons'), 30)
Mobile.tap(findTestObject('Car and bikes/Saved and republish'), 30)

WebUI.delay(2)

Mobile.tap(findTestObject('Removedpost/Exite'), 90)

WebUI.delay(2)
def GetInactiveMsgTxt = Mobile.getText(findTestObject('Object Repository/Multi Scenarios/InactiveAdMsg'), 0)
if(GetInactiveMsgTxt.equals('GetInactiveMsgTxt')) {
	ActiveAdsValue=ActiveAdsValue
}

Mobile.tap(findTestObject('Multi Scenarios/android.widget.ImageButton'), 90)
Mobile.tap(findTestObject('Login_MyAccount/Account2'), 30)

Mobile.tap(findTestObject('AcountDetails/AccountDetails_Button'), 0, FailureHandling.STOP_ON_FAILURE)

def ActiveAdsValueafteraddpost = Mobile.getText(findTestObject('AcountDetails/ActiveAds_Value'), 0, FailureHandling.STOP_ON_FAILURE)

ActiveAdsValueafteraddpost = ActiveAdsValueafteraddpost.toInteger()

if (ActiveAdsValue.equals(ActiveAdsValueafteraddpost)) {
	println('The value are corrcect: '+ActiveAdsValueafteraddpost+ActiveAdsValue)
}
else {
	throw new Exception('The value are not corrcect: '+ActiveAdsValueafteraddpost+ActiveAdsValue)}


