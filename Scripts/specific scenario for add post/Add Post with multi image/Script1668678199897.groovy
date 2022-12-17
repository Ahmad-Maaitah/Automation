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
import io.appium.java_client.MobileElement as MobileElement
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.AppiumDriver as AppiumDriver
import org.openqa.selenium.WebElement as WebElement

WebUI.callTestCase(findTestCase('Login Page/Valid login Jordna Country'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Car and bikes/Car And bikes Category'), 30)

Mobile.tap(findTestObject('Car and bikes/Car For Sale subcategory'), 30)

Mobile.tap(findTestObject('Add image/Add Image'), 30)

Mobile.tap(findTestObject('Add image/Add first image'), 30)

Mobile.tap(findTestObject('Add image/Image 2'), 30)

Mobile.tap(findTestObject('Add image/Image 3'), 30)

Mobile.tap(findTestObject('Add image/Image 4'), 30)

Mobile.tap(findTestObject('Add image/Image 5'), 30)

Mobile.tap(findTestObject('Add image/Image 6'), 30)

Mobile.tap(findTestObject('Add image/Image 7'), 30)

Mobile.tap(findTestObject('Add image/Image 8'), 30)

Mobile.tap(findTestObject('Add image/image 9'), 30)

Mobile.tap(findTestObject('Add image/image 10'), 30)

Mobile.tap(findTestObject('Add image/image 11'), 30)

Mobile.tap(findTestObject('Add image/image 12'), 30)

Mobile.tap(findTestObject('Add image/image 13'), 30)

Mobile.tap(findTestObject('Add image/Save image'), 30)

Mobile.tap(findTestObject('Car and bikes/Next media step button'), 30)

//Mobile.setText(findTestObject('Object Repository/Car and bikes/Youtupe link'), 'https://www.youtube.com/watch?v=TBCQ5rjdX3k', 30)
Mobile.tap(findTestObject('Car and bikes/Next youtupe Screen'), 30)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

AppiumDriver<?> driver = MobileDriverFactory.getDriver()

List City = driver.findElementsByXPath('//androidx.recyclerview.widget.RecyclerView[1]/android.widget.FrameLayout/android.view.ViewGroup[1]/android.widget.TextView[1]')

def randomindex = Math.abs(new Random().nextInt() % [5]) + 0

City.get(randomindex).click()

WebUI.delay(2)

//Mobile.tap(findTestObject('Car and bikes/Car Make'), 30)
List carmake = driver.findElementsByXPath('//androidx.recyclerview.widget.RecyclerView[1]/android.widget.FrameLayout/android.view.ViewGroup[1]/android.widget.TextView[1]')

carmake.get(randomindex).click()

WebUI.delay(2)

//Mobile.tap(findTestObject('Car and bikes/Car Model'), 30)
List carModel = driver.findElementsByXPath('//androidx.recyclerview.widget.RecyclerView[1]/android.widget.FrameLayout/android.view.ViewGroup[1]/android.widget.TextView[1]')

carModel.get(randomindex).click()

WebUI.delay(2)

//Mobile.tap(findTestObject('Car and bikes/Car Year'), 30)
List carYear = driver.findElementsByXPath('//androidx.recyclerview.widget.RecyclerView[1]/android.widget.FrameLayout/android.view.ViewGroup[1]/android.widget.TextView[1]')

carYear.get(randomindex).click()

WebUI.delay(2)

Mobile.tap(findTestObject('Car and bikes/Regional Specifications'), 30)

Mobile.tap(findTestObject('Car and bikes/Type of transmission'), 30)

Mobile.tap(findTestObject('Car and bikes/type of fuel'), 30)

Mobile.tap(findTestObject('Car and bikes/Color Car'), 30)

Mobile.tap(findTestObject('Car and bikes/Add ons'), 30)

Mobile.tap(findTestObject('Car and bikes/Next Add ons'), 30)

Mobile.tap(findTestObject('Car and bikes/Car Used'), 30)

Mobile.tap(findTestObject('Car and bikes/Kilmiter'), 30)

Mobile.tap(findTestObject('Car and bikes/repainted'), 30)

Mobile.tap(findTestObject('Car and bikes/Condition'), 30)

Mobile.tap(findTestObject('Car and bikes/Registered'), 30)

Mobile.tap(findTestObject('Car and bikes/Lincensed'), 30)

Mobile.tap(findTestObject('Car and bikes/Insurance'), 30)

Mobile.setText(findTestObject('Object Repository/Car and bikes/Addprice'), '15000', 30)

Mobile.tap(findTestObject('Car and bikes/Next Add ons'), 30)

Mobile.tap(findTestObject('Car and bikes/Payment Method'), 30)

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

//Mobile.tap(findTestObject('Car and bikes/Area'), 30, FailureHandling.STOP_ON_FAILURE)
List Area = driver.findElementsByXPath('//androidx.recyclerview.widget.RecyclerView[1]/android.widget.FrameLayout/android.view.ViewGroup[1]/android.widget.TextView[1]')

Area.get(randomindex).click()

WebUI.delay(2)

Mobile.tap(findTestObject('Car and bikes/save map'), 30, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Car and bikes/Saved and republish'), 30, FailureHandling.STOP_ON_FAILURE)

WebUI.delay(10)

WebUI.callTestCase(findTestCase('Login Page/Removed post'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication(FailureHandling.STOP_ON_FAILURE)

driver.quit()

