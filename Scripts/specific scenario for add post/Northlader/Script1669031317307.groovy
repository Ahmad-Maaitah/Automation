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

Mobile.startApplication('C:\\Users\\Admin\\Downloads\\9.2.3.apk', true)

Mobile.tap(findTestObject('Object Repository/Northlader/android.widget.TextView -'), 0)

Mobile.tap(findTestObject('Object Repository/Northlader/android.widget.TextView - (1)'), 0)

Mobile.tap(findTestObject('Object Repository/Northlader/android.widget.ImageView'), 0)

Mobile.tap(findTestObject('Object Repository/Northlader/android.widget.TextView - (2)'), 0)

Mobile.setText(findTestObject('Object Repository/Northlader/android.widget.EditText -'), '0703213212', 0)

Mobile.tap(findTestObject('Object Repository/Northlader/android.widget.Button -'), 0)

Mobile.setEncryptedText(findTestObject('Object Repository/Northlader/android.widget.EditText - (1)'), 'tnXB1jbPNDAOVoUnr2O+7A==', 
    0)

Mobile.tap(findTestObject('Object Repository/Northlader/android.widget.Button - (1)'), 0)

Mobile.tap(findTestObject('Object Repository/Northlader/android.widget.Button - (2)'), 0)

Mobile.tap(findTestObject('Object Repository/Northlader/android.widget.TextView -  -'), 0)

Mobile.tap(findTestObject('Object Repository/Northlader/android.widget.TextView - (3)'), 0)

Mobile.tap(findTestObject('Object Repository/Northlader/android.widget.Button - (3)'), 0)

Mobile.tap(findTestObject('Object Repository/Northlader/android.widget.TextView - (4)'), 0)

Mobile.tap(findTestObject('Object Repository/Northlader/android.widget.TextView -  13'), 0)

Mobile.tap(findTestObject('Object Repository/Northlader/android.widget.TextView - 128'), 0)

Mobile.tap(findTestObject('Object Repository/Northlader/android.widget.TextView - (5)'), 0)

Mobile.tap(findTestObject('Object Repository/Northlader/android.widget.TextView -  - (1)'), 0)

Mobile.tap(findTestObject('Object Repository/Northlader/android.widget.TextView - (6)'), 0)

Mobile.tap(findTestObject('Object Repository/Northlader/android.widget.TextView - (7)'), 0)

Mobile.tap(findTestObject('Object Repository/Northlader/android.view.ViewGroup'), 0)

Mobile.tap(findTestObject('Object Repository/Northlader/android.widget.Button - (4)'), 0)

Mobile.closeApplication()

