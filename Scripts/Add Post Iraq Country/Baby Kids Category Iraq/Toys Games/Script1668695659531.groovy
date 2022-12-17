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

WebUI.callTestCase(findTestCase('Login Page/Valid login Iraq Country'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

Mobile.tap(findTestObject('Real Estate for Sale/Search by category'), 30)

Mobile.setText(findTestObject('Object Repository/Electronics/Send exampel by name'), 'لوازم الأطفال و الألعاب', 30)

Mobile.tap(findTestObject('Baby Kids/Baby -Kids'), 30)

WebUI.delay(2)

Mobile.tap(findTestObject('Object Repository/Electronics/Search by name'), 30)

Mobile.setText(findTestObject('Object Repository/Electronics/Send exampel by name'), 'ألعاب أطفال', 30)

Mobile.tap(findTestObject('Baby Kids/Toys Games'), 30)

Mobile.tap(findTestObject('Car and bikes/Next media step button'), 30)

Mobile.tap(findTestObject('Car for Rental/Delivery CPS'), 30)

Mobile.tap(findTestObject('Car and bikes/Car Used'), 30)

AppiumDriver<?> driver = MobileDriverFactory.getDriver()

def randomindex = Math.abs(new Random().nextInt() % [4]) + 0

List City = driver.findElementsByXPath('//androidx.recyclerview.widget.RecyclerView[1]/androidx.cardview.widget.CardView/android.view.ViewGroup[1]')

City.get(randomindex).click()

///
List area = driver.findElementsByXPath('//androidx.recyclerview.widget.RecyclerView[1]/android.widget.FrameLayout/android.view.ViewGroup[1]/android.widget.TextView[1]')

area.get(randomindex).click()

WebUI.delay(2)

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

Mobile.clearText(findTestObject('Valid login and Click on Add post button/change phone number/android.widget.EditText - 962703213212'), 
    30)

Mobile.setText(findTestObject('Valid login and Click on Add post button/change phone number/android.widget.EditText -'), 
    '7777777777', 30)

Mobile.tap(findTestObject('Car and bikes/Saved and republish'), 30)

WebUI.delay(2)

WebUI.callTestCase(findTestCase('Login Page/Removed post'), [:], FailureHandling.STOP_ON_FAILURE)

driver.quit()

