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

WebUI.callTestCase(findTestCase('Login Page/Valid login Jordna Country'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Real Estate for Sale/Search by category'), 30)

Mobile.setText(findTestObject('Object Repository/Electronics/Send exampel by name'), 'عقارات للايجار', 30)

Mobile.tap(findTestObject('Real Estate for Rent/Real Estate for Rent'), 30)

Mobile.tap(findTestObject('Object Repository/Electronics/Search by name'), 30)

WebUI.delay(2)

Mobile.setText(findTestObject('Object Repository/Electronics/Send exampel by name'), 'Townhouses', 30)

Mobile.tap(findTestObject('Real Estate for Rent/Townhouses for Rent'), 30)

Mobile.tap(findTestObject('Car and bikes/Next media step button'), 30)

Mobile.tap(findTestObject('Car and bikes/Next youtupe Screen'), 30)

AppiumDriver<?> driver = MobileDriverFactory.getDriver()

List Numberofroom = driver.findElementsByXPath('//androidx.recyclerview.widget.RecyclerView[1]/android.widget.FrameLayout/android.view.ViewGroup[1]/android.widget.TextView[1]')

WebUI.delay(2)

def randomindex = Math.abs(new Random().nextInt() % [4]) + 0

def randomindextest = Math.abs(new Random().nextInt() % [1]) + 0

Numberofroom.get(randomindex).click()

WebUI.delay(2)

/////
List Numberofbathrooms = driver.findElementsByXPath('//androidx.recyclerview.widget.RecyclerView[1]/android.widget.FrameLayout/android.view.ViewGroup[1]/android.widget.TextView[1]')

Numberofbathrooms.get(randomindex).click()

WebUI.delay(2)

////
List Furnished = driver.findElementsByXPath('//androidx.recyclerview.widget.RecyclerView[1]/android.widget.FrameLayout/android.view.ViewGroup[1]/android.widget.TextView[1]')

Furnished.get(randomindextest).click()

WebUI.delay(2)

///
Mobile.tap(findTestObject('Real Estate for Sale/Surface Area'), 30)

Mobile.setText(findTestObject('Object Repository/Real Estate for Sale/Surface Area number'), '123', 30)

Mobile.tap(findTestObject('Car and bikes/Next Add ons'), 30)

Mobile.tap(findTestObject('Real Estate for Sale/LandArea'), 30)

Mobile.setText(findTestObject('Real Estate for Sale/LandArea'), '123', 30)

Mobile.tap(findTestObject('Car and bikes/Next Add ons'), 30)

///
List NumberofFloor = driver.findElementsByXPath('//androidx.recyclerview.widget.RecyclerView[1]/android.widget.FrameLayout/android.view.ViewGroup[1]/android.widget.TextView[1]')

NumberofFloor.get(randomindex).click()

WebUI.delay(2)

//
List Age = driver.findElementsByXPath('//androidx.recyclerview.widget.RecyclerView[1]/android.widget.FrameLayout/android.view.ViewGroup[1]/android.widget.TextView[1]')

Age.get(randomindex).click()

WebUI.delay(2)

////
List Rentalperiod = driver.findElementsByXPath('//androidx.recyclerview.widget.RecyclerView[1]/android.widget.FrameLayout/android.view.ViewGroup[1]/android.widget.TextView[1]')

Rentalperiod.get(randomindextest).click()

WebUI.delay(2)

/////
Mobile.tap(findTestObject('Object Repository/Real Estate for Sale/Opt 1'), 30)

Mobile.tap(findTestObject('Object Repository/Real Estate for Sale/Op2'), 30)

Mobile.tap(findTestObject('Object Repository/Real Estate for Sale/Next page'), 30)

WebUI.delay(2)

List City = driver.findElementsByXPath('//androidx.recyclerview.widget.RecyclerView[1]/androidx.cardview.widget.CardView/android.view.ViewGroup[1]')

City.get(randomindex).click()

WebUI.delay(2)

///
List area = driver.findElementsByXPath('//androidx.recyclerview.widget.RecyclerView[1]/android.widget.FrameLayout/android.view.ViewGroup[1]/android.widget.TextView[1]')

area.get(randomindex).click()

WebUI.delay(2)

Mobile.tap(findTestObject('Car and bikes/save map'), 30)

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

WebUI.callTestCase(findTestCase('Login Page/Removed post'), [:], FailureHandling.STOP_ON_FAILURE)

